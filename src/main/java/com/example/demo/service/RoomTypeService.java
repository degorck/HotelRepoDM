package com.example.demo.service;

import com.example.demo.dto.RoomTypeDTO;
import com.example.demo.dto.response.ResponseRoomTypeDTO;

import java.util.List;

public interface RoomTypeService {
    ResponseRoomTypeDTO createRoomType (RoomTypeDTO roomTypeDTO);
    List<ResponseRoomTypeDTO> roomTypeList();
}
