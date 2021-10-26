package com.example.demo.service;

import com.example.demo.dto.HotelDTO;
import com.example.demo.dto.request.FilterDTO;
import com.example.demo.dto.request.HotelAndRoomListDTO;
import com.example.demo.dto.request.SearchAvailableRoomDTO;
import com.example.demo.dto.response.ResponseHotelDTO;
import com.example.demo.dto.response.ResponseRoomDTO;

import java.util.List;

public interface HotelService {
	ResponseHotelDTO createHotel(HotelDTO hotelDTO);
	ResponseHotelDTO updateHotel(long id, HotelDTO hotelDTO);
	void deleteHotel (long id);
	List<ResponseHotelDTO> hotelList(); //Using List because we can search by Id and is required by findAll method
	List<ResponseHotelDTO> hotelListFilter(FilterDTO filterDTO);
	HotelAndRoomListDTO createHotelAndRooms(HotelAndRoomListDTO hotelAndRoomListDTO);
	List<ResponseRoomDTO> roomList(long id);
	List<ResponseRoomDTO> availableRoomList(long id, SearchAvailableRoomDTO searchAvailableRoomDTO);
}
