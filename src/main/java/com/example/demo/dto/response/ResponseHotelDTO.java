package com.example.demo.dto.response;

import com.example.demo.dto.HotelDTO;
import com.example.demo.dto.RoomDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ResponseHotelDTO {
    private Long id;
    private String name;
    private String description;
    private Long stars;

}
