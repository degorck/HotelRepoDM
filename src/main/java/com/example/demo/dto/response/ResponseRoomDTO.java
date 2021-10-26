package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ResponseRoomDTO {
    private Long id;
    private String name;
    private String description;
    private long floor;
    private long maxGuests;
    private ResponseRoomTypeDTO roomType;
    private ResponseHotelDTO hotel;
}
