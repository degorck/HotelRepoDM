package com.example.demo.mapper;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.dto.response.ResponseReservationDTO;
import com.example.demo.entity.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    @Autowired
    ModelMapper modelMapper;

    public Reservation reservationDTOToReservation(ReservationDTO reservationDTO){
        return modelMapper.map(reservationDTO, Reservation.class);
    }

    public ResponseReservationDTO reservationToResponseReservationDTO(Reservation reservation){
        return modelMapper.map(reservation, ResponseReservationDTO.class);
    }

    public Reservation responseReservationDTOToReservation (ResponseReservationDTO responseReservationDTO){
        return modelMapper.map(responseReservationDTO, Reservation.class);
    }

}
