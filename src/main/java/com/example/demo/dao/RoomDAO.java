package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Room;

import java.util.List;

public interface RoomDAO extends JpaRepository<Room, Long> {

    List<Room> findRoomsByHotelId(Long id);

}
