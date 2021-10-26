package com.example.demo.controller;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.request.ReservationAndGuestDTO;
import com.example.demo.dto.request.ReservationGuestAndChildListDTO;
import com.example.demo.service.ReservationService;
import com.example.demo.utils.Constants;
import com.example.demo.utils.Validation;
import com.example.demo.utils.aspect.TrackExecutionTime;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.demo.utils.Constants.DELETED_SUCCESSFULLY;

@RestController
@RequestMapping(value = "reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @Operation(summary="Create a Reservation")
    @PutMapping(value = "/create")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<ReservationDTO>> createReservation (@RequestBody ReservationDTO reservationDTO){
        Validation.validateDayAfter(reservationDTO.getEndDate(), reservationDTO.getStartDate());
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), reservationService.createReservation(reservationDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary="Create a Reservation and Register Guest")
    @PutMapping(value = "/create/sign-in")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<ReservationDTO>> createReservationAndSignIn (@Valid @RequestBody ReservationAndGuestDTO reservationAndGuestDTO) {
        Validation.validateDayAfter(reservationAndGuestDTO.getReservation().getEndDate(), reservationAndGuestDTO.getReservation().getStartDate());
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), reservationService.createReservationAndSignIn(reservationAndGuestDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary="Create Reservation, Register Guest and add Child Guests")
    @PutMapping(value = "/create/sign-in/child-list")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<ReservationDTO>> createReservationAndSignInPlusChild (@Valid @RequestBody ReservationGuestAndChildListDTO reservationGuestAndChildListDTO){
        Validation.validateDayAfter(reservationGuestAndChildListDTO.getReservation().getEndDate(), reservationGuestAndChildListDTO.getReservation().getStartDate());
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), reservationService.createReservationAndSignInChild(reservationGuestAndChildListDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary="Check in reservation by Id")
    @PutMapping(value = "/{id}/check-in")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<ReservationDTO>> checkInReservation (@PathVariable("id") long id){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), reservationService.checkIn(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary="Delete reservation by Id")
    @DeleteMapping(value = "/delete")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<ReservationDTO>> deleteReservation (@RequestParam long id){
        reservationService.deleteReservation(id);
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), DELETED_SUCCESSFULLY);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary="Get list of all Reservation")
    @GetMapping(value = "/list")
    @TrackExecutionTime
    public  ResponseEntity<ResponseDTO<ReservationDTO>> reservationList(){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), reservationService.reservationList());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary="Get list of all Active Reservations")
    @GetMapping(value = "/list/active")
    @TrackExecutionTime
    public  ResponseEntity<ResponseDTO<ReservationDTO>> activeReservationList(){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), reservationService.activeReservationList());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
