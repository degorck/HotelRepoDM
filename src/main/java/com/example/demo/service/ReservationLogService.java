package com.example.demo.service;

import com.example.demo.dto.ReservationLogDTO;
import com.example.demo.dto.response.ResponseGuestDTO;
import com.example.demo.dto.response.ResponseReservationDTO;

public interface ReservationLogService {
    ReservationLogDTO createReservationLog(ResponseReservationDTO responseReservationDTO);
    int successfullyReservations(ResponseGuestDTO responseGuestDTO);
}
