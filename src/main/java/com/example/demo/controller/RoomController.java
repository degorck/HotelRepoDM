package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.RoomDTO;
import com.example.demo.service.RoomService;
import com.example.demo.utils.Constants;
import com.example.demo.utils.aspect.TrackExecutionTime;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static  com.example.demo.utils.Constants.DELETED_SUCCESSFULLY;

@RestController
@RequestMapping(value ="room")
public class RoomController {
    @Autowired
    RoomService roomService;

    @Operation(summary="Create a Room")
    @PutMapping(value = "/create")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<RoomDTO>> createRoom (@Valid @RequestBody RoomDTO roomDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), roomService.createRoom(roomDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary="Update a Room by Id")
    @PutMapping(value = "{id}")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<RoomDTO>> updateRoom (@PathVariable("id") long id, @Valid @RequestBody RoomDTO roomDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), roomService.updateRoom(id, roomDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Operation(summary="Delete a Room by Id")
    @DeleteMapping(value = "/delete")
    @TrackExecutionTime
    public ResponseEntity<ResponseDTO<RoomDTO>> deleteRoom (@RequestParam long id){
        roomService.deleteRoom(id);
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstant.SUCCESS.getDescription(), DELETED_SUCCESSFULLY);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
