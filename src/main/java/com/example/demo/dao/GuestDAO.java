package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Guest;

public interface GuestDAO extends JpaRepository<Guest, Long> {

}
