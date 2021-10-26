package com.example.demo.service.impl;

import com.example.demo.dao.RoomDAO;
import com.example.demo.dto.RoomDTO;
import com.example.demo.dto.response.ResponseRoomDTO;
import com.example.demo.entity.Room;
import com.example.demo.mapper.RoomMapper;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomDAO roomDAO;

    @Autowired
    RoomMapper roomMapper;

    @Override
    public ResponseRoomDTO createRoom(RoomDTO roomDTO) {
        return roomMapper.responseRoomDTOToRoom(roomDAO.save(roomMapper.roomDTOToRoom(roomDTO)));
    }

    @Override
    public ResponseRoomDTO updateRoom(long id, RoomDTO roomDTO) {
        Room room = roomMapper.roomDTOToRoom(roomDTO);
        room.setId(id);
        return roomMapper.responseRoomDTOToRoom(roomDAO.save(room));
    }

    @Override
    public void deleteRoom(long id) {
        roomDAO.delete(roomDAO.getById(id));
    }
}
