package com.example.demo.service.impl;

import com.example.demo.dao.RoomTypeDAO;
import com.example.demo.dto.RoomTypeDTO;
import com.example.demo.dto.response.ResponseRoomTypeDTO;
import com.example.demo.entity.RoomType;
import com.example.demo.mapper.RoomTypeMapper;
import com.example.demo.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    @Autowired
    RoomTypeDAO roomTypeDAO;

    @Autowired
    RoomTypeMapper roomTypeMapper;

    @Override
    public ResponseRoomTypeDTO createRoomType(RoomTypeDTO roomTypeDTO) {
        return roomTypeMapper.roomTypeToResponseRoomTypeDTO(roomTypeDAO.save(roomTypeMapper.roomTypeDTOTORoomType(roomTypeDTO)));
    }

    @Override
    public List<ResponseRoomTypeDTO> roomTypeList() {
        List<RoomType> roomTypeList = roomTypeDAO.findAll();
        List<ResponseRoomTypeDTO> responseRoomTypeDTOList = new ArrayList<>();
        for (RoomType roomType:roomTypeList){
            responseRoomTypeDTOList.add(roomTypeMapper.roomTypeToResponseRoomTypeDTO(roomType));
        }
        return responseRoomTypeDTOList;
    }
}
