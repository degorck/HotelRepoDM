package com.example.demo.service.impl;

import com.example.demo.dao.RoomDAO;
import com.example.demo.dto.request.FilterDTO;
import com.example.demo.dto.request.HotelAndRoomListDTO;
import com.example.demo.dto.request.SearchAvailableRoomDTO;
import com.example.demo.dto.response.ResponseHotelDTO;
import com.example.demo.dto.response.ResponseRoomDTO;
import com.example.demo.entity.Hotel;
import com.example.demo.entity.Room;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.HotelDAO;
import com.example.demo.dto.HotelDTO;
import com.example.demo.mapper.HotelMapper;
import com.example.demo.service.HotelService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService{
	@Autowired
	HotelDAO hotelDAO;
	
	@Autowired
	HotelMapper hotelMapper;

	@Autowired
	RoomService roomService;

	@Autowired
	RoomDAO roomDAO;

	@Autowired
	RoomMapper roomMapper;

	@Override
	public ResponseHotelDTO createHotel(HotelDTO hotelDTO) {
		return hotelMapper.hotelToResponseHotelDTO(hotelDAO.save(hotelMapper.hotelDTOToHotel(hotelDTO)));
	}

	@Override
	public ResponseHotelDTO updateHotel(long id, HotelDTO hotelDTO) {
		Hotel hotel = hotelMapper.hotelDTOToHotel(hotelDTO);
		hotel.setId(id);
		return hotelMapper.hotelToResponseHotelDTO(hotelDAO.save(hotel));
	}

	@Override
	public void deleteHotel(long id) {
		hotelDAO.delete(hotelDAO.getById(id));
	}

	@Override
	public List<ResponseHotelDTO> hotelList() {
		List<Hotel> hotelList = hotelDAO.findAll();
		List<ResponseHotelDTO> hotelListDTO = new ArrayList<>();
		for (Hotel hotel:hotelList){
			hotelListDTO.add(hotelMapper.hotelToResponseHotelDTO(hotel));
		}
		return hotelListDTO;
	}

	@Override
	public List<ResponseHotelDTO> hotelListFilter(FilterDTO filterDTO) {
		return hotelList()
				.stream()
				.filter(h -> h.getName().contains(filterDTO.getValue()) || h.getDescription().contains(filterDTO.getValue()))
				.collect(Collectors.toList());
	}

	@Override
	public HotelAndRoomListDTO createHotelAndRooms(HotelAndRoomListDTO hotelAndRoomListDTO) {
		ResponseHotelDTO responseHotelDTO = createHotel(hotelAndRoomListDTO.getHotel());
		hotelAndRoomListDTO.getRoomList()
				.stream()
				.forEach(s -> {
					s.setHotel(responseHotelDTO);
					roomService.createRoom(s);
				});
		return hotelAndRoomListDTO;
	}

	@Override
	public List<ResponseRoomDTO> roomList(long id) {
		List<Room> roomList = roomDAO.findRoomsByHotelId(id);
		List<ResponseRoomDTO> responseRoomDTOList = new ArrayList<>();
		for (Room room:roomList){
			responseRoomDTOList.add(roomMapper.responseRoomDTOToRoom(room));
		}
		return responseRoomDTOList;
	}

	@Override
	public List<ResponseRoomDTO> availableRoomList(long id, SearchAvailableRoomDTO searchAvailableRoomDTO) {
		List<ResponseRoomDTO> responseRoomDTOList = new ArrayList<>();
				roomDAO.findRoomsByHotelId(id)
				.stream()
				.forEach(room -> {
					room.getReservationList()
							.stream()
							.filter(reservation -> reservation.getEndDate().before(searchAvailableRoomDTO.getFrom()) || reservation.getStartDate().after(searchAvailableRoomDTO.getTo()))
							.forEach(reservation -> {
								responseRoomDTOList.add(roomMapper.responseRoomDTOToRoom(room));
							});
					if(room.getReservationList().isEmpty()){
						responseRoomDTOList.add(roomMapper.responseRoomDTOToRoom(room));
					}
					});
		return responseRoomDTOList;
	}

}
