package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.GuestType;

public interface GuestTypeDAO extends JpaRepository<GuestType, Long> {
    GuestType getGuestTypeByNameEquals(String name);

}
