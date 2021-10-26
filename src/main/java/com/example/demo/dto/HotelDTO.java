package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
	@NotEmpty(message = "Hotel name is required")
	private String name;
	private String description;
	@Max(value = 5, message = "Stars value must be below 5")
	@Min(value = 1, message = "Stars value must be above 1")
	private Long stars;
}
