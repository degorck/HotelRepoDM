package com.example.demo.service;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.dto.ReservationLogDTO;
import com.example.demo.dto.request.FilterDTO;
import com.example.demo.dto.request.ReservationAndGuestDTO;
import com.example.demo.dto.request.ReservationGuestAndChildListDTO;
import com.example.demo.dto.response.ResponseReservationDTO;

import java.util.List;

public interface ReservationService {
    ResponseReservationDTO createReservation(ReservationDTO reservationDTO);
    ReservationLogDTO checkIn(Long id);
    ReservationLogDTO checkOut(Long id);
    void deleteReservation(Long id);
    List<ResponseReservationDTO> reservationList();
    List<ResponseReservationDTO> activeReservationList();
    List<ResponseReservationDTO> reservationListByHotel(long id);
    List<ResponseReservationDTO> activeReservationListByHotel(long id);
    ResponseReservationDTO createReservationAndSignIn(ReservationAndGuestDTO reservationAndGuestDTO);
    ResponseReservationDTO createReservationAndSignInChild(ReservationGuestAndChildListDTO reservationGuestAndChildListDTO);
    List<ResponseReservationDTO> activeReservationListByHotelAndFilter(long id, FilterDTO filterDTO);
}
