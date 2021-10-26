package com.example.demo.dto;

import com.example.demo.dto.response.ResponseHotelDTO;
import com.example.demo.dto.response.ResponseRoomTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
	@NotEmpty(message = "Room name is required")
	private String name;
	private String description;
	@Min(value = 1, message = "Floor field is required")
	private long floor;
	@Min(value = 1, message = "Maximum Guests field is required")
	private long maxGuests;
	private ResponseRoomTypeDTO roomType;
	private ResponseHotelDTO hotel;

}
