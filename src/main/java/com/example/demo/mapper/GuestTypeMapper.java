package com.example.demo.mapper;

import com.example.demo.dto.GuestTypeDTO;
import com.example.demo.dto.response.ResponseGuestTypeDTO;
import com.example.demo.entity.GuestType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuestTypeMapper {
    @Autowired
    ModelMapper modelMapper;

    public GuestType guestTypeDTOToGuestType(GuestTypeDTO guestTypeDTO){
        return modelMapper.map(guestTypeDTO, GuestType.class);
    }

    public ResponseGuestTypeDTO guestTypeToResponseGuestTypeDTO(GuestType guestType){
        return modelMapper.map(guestType, ResponseGuestTypeDTO.class);
    }
}
