package com.example.demo.dto.request;

import com.example.demo.dto.HotelDTO;
import com.example.demo.dto.RoomDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HotelAndRoomListDTO {
    @Valid
    HotelDTO hotel;
    @Valid
    List<RoomDTO> roomList;
}
