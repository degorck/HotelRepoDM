package com.example.demo.mapper;

import com.example.demo.dto.response.ResponseHotelDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.HotelDTO;
import com.example.demo.entity.Hotel;

@Component
public class HotelMapper {

	@Autowired
	ModelMapper modelMapper;

	public Hotel hotelDTOToHotel(HotelDTO hotelDTO){
		return modelMapper.map(hotelDTO, Hotel.class);
	}
	
	public ResponseHotelDTO hotelToResponseHotelDTO(Hotel hotel){
		return modelMapper.map(hotel, ResponseHotelDTO.class);
		}

	public Hotel responseHotelDTOToHotel(ResponseHotelDTO responseHotelDTO){
		return modelMapper.map(responseHotelDTO, Hotel.class);
		}

}
