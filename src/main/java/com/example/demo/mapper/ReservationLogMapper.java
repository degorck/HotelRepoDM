package com.example.demo.mapper;

import com.example.demo.dto.ReservationLogDTO;
import com.example.demo.dto.response.ResponseReservationDTO;
import com.example.demo.entity.ReservationLog;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationLogMapper {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    GuestMapper guestMapper;

    public ReservationLog responseReservationDTOToReservationLog(ResponseReservationDTO responseReservationDTO){
       ReservationLog reservationLog = new ReservationLog();
       reservationLog.setHotelName(responseReservationDTO.getRoom().getHotel().getName());
       reservationLog.setRoomName(responseReservationDTO.getRoom().getName());
       reservationLog.setGuest(guestMapper.responseGuestDTOToGuest(responseReservationDTO.getGuest()));
       reservationLog.setEndDate(responseReservationDTO.getEndDate());
       reservationLog.setStartDate(responseReservationDTO.getStartDate());
       return reservationLog;
    }

    public ReservationLogDTO reservationLogToReservationLogDTO(ReservationLog reservationLog){
        ReservationLogDTO reservationLogDTO = ReservationLogDTO.builder()
                .id(reservationLog.getId())
                .hotelName(reservationLog.getHotelName())
                .roomName(reservationLog.getRoomName())
                .guest(guestMapper.guestToResponseGuestDTO(reservationLog.getGuest()))
                .startDate(reservationLog.getStartDate())
                .endDate(reservationLog.getEndDate())
                .build();
        return reservationLogDTO;
    }

}
