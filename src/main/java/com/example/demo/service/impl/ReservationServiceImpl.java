package com.example.demo.service.impl;

import com.example.demo.dao.HotelDAO;
import com.example.demo.dao.ReservationDAO;
import com.example.demo.dto.ReservationDTO;
import com.example.demo.dto.ReservationLogDTO;
import com.example.demo.dto.request.FilterDTO;
import com.example.demo.dto.request.ReservationAndGuestDTO;
import com.example.demo.dto.request.ReservationGuestAndChildListDTO;
import com.example.demo.dto.response.ResponseHotelDTO;
import com.example.demo.dto.response.ResponseReservationDTO;
import com.example.demo.entity.ChildGuest;
import com.example.demo.entity.Reservation;
import com.example.demo.exception.InvalidDataException;
import com.example.demo.mapper.ChildGuestMapper;
import com.example.demo.mapper.HotelMapper;
import com.example.demo.mapper.ReservationLogMapper;
import com.example.demo.mapper.ReservationMapper;
import com.example.demo.service.ChildGuestService;
import com.example.demo.service.GuestService;
import com.example.demo.service.ReservationLogService;
import com.example.demo.service.ReservationService;
import com.example.demo.utils.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.utils.Constants.BOOLEAN_FALSE;
import static com.example.demo.utils.Constants.BOOLEAN_TRUE;
import static com.example.demo.utils.Constants.ALREADY_CHECKED_IN;
import static com.example.demo.utils.Constants.DATE_NOT_AFTER;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationDAO reservationDAO;

    @Autowired
    ReservationMapper reservationMapper;

    @Autowired
    ReservationLogService reservationLogService;

    @Autowired
    ReservationLogMapper reservationLogMapper;

    @Autowired
    GuestService guestService;

    @Autowired
    HotelDAO hotelDAO;

    @Autowired
    HotelMapper hotelMapper;

    @Autowired
    ChildGuestService childGuestService;

    @Autowired
    ChildGuestMapper childGuestMapper;

    @Override
    public ResponseReservationDTO createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.reservationDTOToReservation(reservationDTO);
        reservation.setStatus(BOOLEAN_TRUE);
        return reservationMapper.reservationToResponseReservationDTO(reservationDAO.save(reservation));
    }

    @Override
    public ReservationLogDTO checkIn(Long id) {
        Reservation reservation = reservationDAO.getById(id);
        if (reservation.isCheckIn() == false){
            reservation.setCheckIn(BOOLEAN_TRUE);
            ReservationLogDTO reservationLogDTO =  reservationLogService.createReservationLog(reservationMapper.reservationToResponseReservationDTO(reservation));
            if(reservationLogService.successfullyReservations(reservationLogDTO.getGuest()) > 4){
                guestService.upgradeToVIP(reservationLogDTO.getGuest());
            }
            return reservationLogDTO;
        }else {
            throw new InvalidDataException(ALREADY_CHECKED_IN);
        }
    }

    @Override
    public ReservationLogDTO checkOut(Long id) {
        return null;
    }

    @Override
    public void deleteReservation(Long id) {
        Reservation reservation = reservationDAO.getById(id);
        Validation.validateDateABeforeToday(reservation.getStartDate());
        reservation.setStatus(BOOLEAN_FALSE);
        reservationDAO.save(reservation);
    }

    @Override
    public List<ResponseReservationDTO> reservationList() {
        List<Reservation> reservationList = reservationDAO.findAll();
        List<ResponseReservationDTO> responseReservationDTOList = new ArrayList<>();
        for(Reservation reservation:reservationList){
            responseReservationDTOList.add(reservationMapper.reservationToResponseReservationDTO(reservation));
        }
        return responseReservationDTOList;
    }

    @Override
    public List<ResponseReservationDTO> activeReservationList() {
        return reservationList()
                .stream()
                .filter(r -> r.isStatus() == BOOLEAN_TRUE)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponseReservationDTO> reservationListByHotel(long id) {
        ResponseHotelDTO responseHotelDTO = hotelMapper.hotelToResponseHotelDTO(hotelDAO.getById(id));
        return reservationList()
                .stream()
                .filter(r -> r.getRoom().getHotel().getId() == responseHotelDTO.getId())
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponseReservationDTO> activeReservationListByHotel(long id) {
        ResponseHotelDTO responseHotelDTO = hotelMapper.hotelToResponseHotelDTO(hotelDAO.getById(id));
        return activeReservationList()
                .stream()
                .filter(r -> r.getRoom().getHotel().getId() == responseHotelDTO.getId() && r.isStatus() == BOOLEAN_TRUE)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseReservationDTO createReservationAndSignIn(ReservationAndGuestDTO reservationAndGuestDTO) {
        ReservationDTO reservationDTO = reservationAndGuestDTO.getReservation();
        reservationDTO.setGuest(guestService.createGuest(reservationAndGuestDTO.getGuest()));
        return createReservation(reservationDTO);
    }

    @Override
    public ResponseReservationDTO createReservationAndSignInChild(ReservationGuestAndChildListDTO reservationGuestAndChildListDTO) {
        ReservationDTO reservationDTO = reservationGuestAndChildListDTO.getReservation();
        List<ChildGuest> childGuests = new ArrayList<>();
        reservationDTO.setGuest(guestService.createGuest(reservationGuestAndChildListDTO.getGuest()));
        reservationGuestAndChildListDTO.getChildList()
                .stream()
                .forEach(c -> {
                    c.setGuest(reservationDTO.getGuest());
                    childGuests.add(childGuestMapper.childGuestDTOToChildGuest(c));
                });
        return createReservation(reservationDTO, childGuests);
    }

    @Override
    public List<ResponseReservationDTO> activeReservationListByHotelAndFilter(long id, FilterDTO filterDTO) {
        ResponseHotelDTO responseHotelDTO = hotelMapper.hotelToResponseHotelDTO(hotelDAO.getById(id));
        return activeReservationList()
                .stream()
                .filter(r -> r.getRoom().getHotel().getId() == responseHotelDTO.getId() && r.isStatus() == BOOLEAN_TRUE  && (r.getGuest().getFirstName().contains(filterDTO.getValue()) || r.getGuest().getLastName().contains(filterDTO.getValue()) || r.getGuest().getEmail().contains(filterDTO.getValue())))
                .collect(Collectors.toList());
    }

    public ResponseReservationDTO createReservation(ReservationDTO reservationDTO, List<ChildGuest> childGuests){
        Reservation reservation = reservationMapper.reservationDTOToReservation(reservationDTO);
        reservation.setStatus(BOOLEAN_TRUE);
        reservation.setChildGuests(childGuests);
        return reservationMapper.reservationToResponseReservationDTO(reservationDAO.save(reservation));
    }
}
