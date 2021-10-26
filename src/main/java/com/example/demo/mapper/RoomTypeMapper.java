package com.example.demo.mapper;

import com.example.demo.dto.RoomTypeDTO;
import com.example.demo.dto.response.ResponseRoomTypeDTO;
import com.example.demo.entity.RoomType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomTypeMapper {
    @Autowired
    ModelMapper modelMapper;

    public RoomType roomTypeDTOTORoomType(RoomTypeDTO roomTypeDTO){
        return modelMapper.map(roomTypeDTO, RoomType.class);
    }

    public RoomType responseRoomTypeDTOTORoomType(ResponseRoomTypeDTO responseRoomTypeDTO){
        return modelMapper.map(responseRoomTypeDTO, RoomType.class);
    }

    public  ResponseRoomTypeDTO roomTypeToResponseRoomTypeDTO(RoomType roomType){
        return modelMapper.map(roomType, ResponseRoomTypeDTO.class);
    }
}
