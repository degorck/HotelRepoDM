package com.example.demo.controller;

import com.example.demo.dto.GuestDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.request.FilterDTO;
import com.example.demo.service.GuestService;
import com.example.demo.utils.Constants;
import com.example.demo.utils.aspect.TrackExecutionTime;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "guest")
public class GuestController {
    @Autowired
    GuestService guestService;

    @Operation(summary="Create a Guest")
    @PutMapping(value = "/create")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<GuestDTO>> createGuest (@Valid @RequestBody GuestDTO guestDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), guestService.createGuest(guestDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary="Get list of all Guest")
    @GetMapping(value = "/list")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<GuestDTO>> guestList (){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), guestService.guestList());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary="Get list of all Guest and search by filter")
    @PostMapping(value = "/list/filter")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<GuestDTO>> guestFilterList (@RequestBody FilterDTO filterDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), guestService.guestListFilter(filterDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
