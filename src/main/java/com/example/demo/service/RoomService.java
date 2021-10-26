package com.example.demo.service;

import com.example.demo.dto.RoomDTO;
import com.example.demo.dto.response.ResponseRoomDTO;

public interface RoomService {
    ResponseRoomDTO createRoom (RoomDTO roomDTO);
    ResponseRoomDTO updateRoom (long id, RoomDTO roomDTO);
    void deleteRoom(long id);
}
