package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RoomType;

public interface RoomTypeDAO extends JpaRepository<RoomType, Long> {
    RoomType getRoomTypeByNameEquals(String name);

}
