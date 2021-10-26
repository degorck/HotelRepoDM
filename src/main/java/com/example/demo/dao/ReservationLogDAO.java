package com.example.demo.dao;

import com.example.demo.entity.Guest;
import com.example.demo.entity.ReservationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationLogDAO extends JpaRepository<ReservationLog, Long> {
    int countReservationLogByGuest(Guest guest);
}
