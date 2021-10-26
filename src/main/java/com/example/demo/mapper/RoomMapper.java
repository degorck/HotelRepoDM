package com.example.demo.mapper;

import com.example.demo.dto.RoomDTO;
import com.example.demo.dto.response.ResponseRoomDTO;
import com.example.demo.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    @Autowired
    HotelMapper hotelMapper;

    @Autowired
    RoomTypeMapper roomTypeMapper;

    public Room roomDTOToRoom (RoomDTO roomDTO){
        Room room = new Room();
        room.setName(roomDTO.getName());
        room.setDescription(roomDTO.getDescription());
        room.setFloor(roomDTO.getFloor());
        room.setMaxGuests(roomDTO.getMaxGuests());
        room.setHotel(hotelMapper.responseHotelDTOToHotel(roomDTO.getHotel()));
        room.setRoomType(roomTypeMapper.responseRoomTypeDTOTORoomType(roomDTO.getRoomType()));
        return room;
    }

    public ResponseRoomDTO responseRoomDTOToRoom(Room room){
        ResponseRoomDTO responseRoomDTO = ResponseRoomDTO.builder()
                .id(room.getId())
                .name(room.getName())
                .description(room.getDescription())
                .floor(room.getFloor())
                .maxGuests(room.getMaxGuests())
                .hotel(hotelMapper.hotelToResponseHotelDTO(room.getHotel()))
                .roomType(roomTypeMapper.roomTypeToResponseRoomTypeDTO(room.getRoomType()))
                .build();
        return  responseRoomDTO;
    }
}
