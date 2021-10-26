package com.example.demo.controller;

import com.example.demo.dto.request.FilterDTO;
import com.example.demo.dto.request.HotelAndRoomListDTO;
import com.example.demo.dto.request.SearchAvailableRoomDTO;
import com.example.demo.dto.response.ResponseHotelDTO;
import com.example.demo.dto.response.ResponseReservationDTO;
import com.example.demo.dto.response.ResponseRoomDTO;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.HotelDTO;
import com.example.demo.service.HotelService;
import com.example.demo.dto.ResponseDTO;

import javax.validation.Valid;
import java.util.List;

import static  com.example.demo.utils.Constants.DELETED_SUCCESSFULLY;
import static com.example.demo.utils.Constants.VALUE_LABEL;

@RestController
@RequestMapping(value = "hotel")
public class HotelController {
	@Autowired
	HotelService hotelService;

	@Autowired
	ReservationService reservationService;

	@Operation(summary="Create hotel")
	@PutMapping(value = "/create")
	@TrackExecutionTime
	public ResponseEntity<ResponseDTO<HotelDTO>> createHotel (@Valid @RequestBody HotelDTO hotelDTO){
		ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), hotelService.createHotel(hotelDTO));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@Operation(summary="Create Hotel and Rooms")
	@PutMapping(value = "/create/rooms")
	@TrackExecutionTime
	public ResponseEntity<ResponseDTO<HotelDTO>> createHotelAndRooms (@Valid @RequestBody HotelAndRoomListDTO roomListDTO){
		ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), hotelService.createHotelAndRooms(roomListDTO));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@Operation(summary="Update hotel by id")
	@PutMapping(value = "{id}")
	@TrackExecutionTime
	public ResponseEntity<ResponseDTO<HotelDTO>> updateHotel (@PathVariable("id") long id, @Valid @RequestBody HotelDTO hotelDTO){
		ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), hotelService.updateHotel(id, hotelDTO));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@Operation(summary="Get list of all Rooms by Hotel")
	@GetMapping(value = "{id}/rooms")
	@TrackExecutionTime
	public ResponseEntity<ResponseDTO<List<ResponseRoomDTO>>> roomsByHotel(@PathVariable("id") long id){
		ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), hotelService.roomList(id));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@Operation(summary="Delete Hotel by Id")
	@DeleteMapping(value = "/delete")
	@TrackExecutionTime
	public ResponseEntity<ResponseDTO<HotelDTO>> deleteHotel (@RequestParam long id){
		hotelService.deleteHotel(id);
		ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), DELETED_SUCCESSFULLY);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@Operation(summary="Get list of all Hotels")
	@GetMapping(value = "/list")
	@TrackExecutionTime
	public ResponseEntity<ResponseDTO<ResponseHotelDTO>> hotelList (){
		ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), hotelService.hotelList());
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@Operation(summary="Get list of all Hotels by filter")
	@PostMapping (value = "/list/filter/")
	@TrackExecutionTime
	public ResponseEntity<ResponseDTO<ResponseHotelDTO>> hotelListFilter (@RequestBody FilterDTO filterDTO){
		Validation.validateBlankOrNullString(VALUE_LABEL, filterDTO.getValue());
		ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), hotelService.hotelListFilter(filterDTO));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@Operation(summary="Get list of all Reservations by Hotel")
	@GetMapping(value = "{id}/reservations")
	@TrackExecutionTime
	public ResponseEntity<ResponseDTO<List<ResponseReservationDTO>>> reservationsByHotel(@PathVariable("id") long id){
		ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), reservationService.reservationListByHotel(id));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@Operation(summary="Get list of all Active Reservations")
	@GetMapping(value = "{id}/reservations/active")
	@TrackExecutionTime
	public ResponseEntity<ResponseDTO<List<ResponseReservationDTO>>> activeReservationsByHotel(@PathVariable("id") long id){
		ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), reservationService.activeReservationListByHotel(id));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@Operation(summary="Get list of all Available Rooms by Hotel")
	@PostMapping(value = "{id}/rooms/available")
	@TrackExecutionTime
	public ResponseEntity<ResponseDTO<List<ResponseRoomDTO>>> roomsByHotelAvailable(@PathVariable("id") long id, @RequestBody SearchAvailableRoomDTO searchAvailableRoomDTO){
		Validation.validateDayAfter(searchAvailableRoomDTO.getTo(), searchAvailableRoomDTO.getFrom());
		ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), hotelService.availableRoomList(id, searchAvailableRoomDTO));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@Operation(summary="Get list of all Active Reservations by Filter")
	@PostMapping(value = "{id}/reservations/active/filter")
	@TrackExecutionTime
	public ResponseEntity<ResponseDTO<List<ResponseReservationDTO>>> activeReservationsByHotelAndFilter(@PathVariable("id") long id, @RequestBody FilterDTO filterDTO){
		ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), reservationService.activeReservationListByHotelAndFilter(id, filterDTO));
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

}
