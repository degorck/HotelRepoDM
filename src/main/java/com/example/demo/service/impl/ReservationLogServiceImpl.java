package com.example.demo.service.impl;

import com.example.demo.dao.ReservationLogDAO;
import com.example.demo.dto.ReservationLogDTO;
import com.example.demo.dto.response.ResponseGuestDTO;
import com.example.demo.dto.response.ResponseReservationDTO;
import com.example.demo.mapper.GuestMapper;
import com.example.demo.mapper.ReservationLogMapper;
import com.example.demo.service.ReservationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationLogServiceImpl implements ReservationLogService {
    @Autowired
    ReservationLogMapper reservationLogMapper;

    @Autowired
    ReservationLogDAO reservationLogDAO;

    @Autowired
    GuestMapper guestMapper;

    @Override
    public ReservationLogDTO createReservationLog(ResponseReservationDTO responseReservationDTO) {
        return reservationLogMapper.reservationLogToReservationLogDTO(reservationLogDAO.save(reservationLogMapper.responseReservationDTOToReservationLog(responseReservationDTO)));
    }

    @Override
    public int successfullyReservations(ResponseGuestDTO responseGuestDTO) {
        return reservationLogDAO.countReservationLogByGuest(guestMapper.responseGuestDTOToGuest(responseGuestDTO));
    }
}
