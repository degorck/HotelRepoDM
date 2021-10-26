package com.example.demo.controller;

import com.example.demo.dto.GuestTypeDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.GuestTypeService;
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
@RequestMapping(value = "guest-type")
public class GuestTypeController {
    @Autowired
    GuestTypeService guestTypeService;

    @Operation(summary="Create a Guest Type")
    @PutMapping(value = "/create")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<GuestTypeDTO>> createGuestType (@Valid @RequestBody GuestTypeDTO guestTypeDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), guestTypeService.createGuestType(guestTypeDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary="Get list of all Guest Types")
    @GetMapping(value = "/list")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<GuestTypeDTO>> guestTypeList(){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), guestTypeService.guestTypeList());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
