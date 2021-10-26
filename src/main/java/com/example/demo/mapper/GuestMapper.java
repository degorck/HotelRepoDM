package com.example.demo.mapper;

import com.example.demo.dto.GuestDTO;
import com.example.demo.dto.response.ResponseGuestDTO;
import com.example.demo.entity.Guest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuestMapper {
    @Autowired
    ModelMapper modelMapper;

    public Guest guestDTOToGuest(GuestDTO guestDTO){
        return modelMapper.map(guestDTO, Guest.class);
    }

    public ResponseGuestDTO guestToResponseGuestDTO(Guest guest){
        return modelMapper.map(guest, ResponseGuestDTO.class);
    }

    public Guest responseGuestDTOToGuest(ResponseGuestDTO responseGuestDTO){
        return modelMapper.map(responseGuestDTO, Guest.class);
    }
}
