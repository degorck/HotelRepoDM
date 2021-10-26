package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.RoomTypeDTO;
import com.example.demo.service.RoomTypeService;
import com.example.demo.utils.Constants;
import com.example.demo.utils.aspect.TrackExecutionTime;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "room-type")
public class RoomTypeController {

    @Autowired
    RoomTypeService roomTypeService;

    @Operation(summary="Create a Room Type")
    @PutMapping(value = "/create")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<RoomTypeDTO>> createRoomType (@Valid @RequestBody RoomTypeDTO roomTypeDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), roomTypeService.createRoomType(roomTypeDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary="Get list of all Room Types")
    @GetMapping(value = "/list")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<RoomTypeDTO>> roomTypeList () {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), roomTypeService.roomTypeList());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
