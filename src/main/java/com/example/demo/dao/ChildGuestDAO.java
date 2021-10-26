package com.example.demo.dao;

import com.example.demo.entity.ChildGuest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildGuestDAO extends JpaRepository<ChildGuest, Long> {
}
