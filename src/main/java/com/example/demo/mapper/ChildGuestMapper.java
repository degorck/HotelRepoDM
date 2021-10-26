package com.example.demo.mapper;

import com.example.demo.dto.ChildGuestDTO;
import com.example.demo.dto.response.ResponseChildGuestDTO;
import com.example.demo.entity.ChildGuest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChildGuestMapper {
    @Autowired
    ModelMapper modelMapper;

    public ChildGuest childGuestDTOToChildGuest(ChildGuestDTO childGuestDTO){
        return modelMapper.map(childGuestDTO, ChildGuest.class);
    }
    public ResponseChildGuestDTO childGuestToResponseChildGuestDTO(ChildGuest childGuest){
        return modelMapper.map(childGuest, ResponseChildGuestDTO.class);
    }

    public ChildGuest responseChildGuestDTOToChildGuest(ResponseChildGuestDTO responseChildGuestDTO){
        return modelMapper.map(responseChildGuestDTO, ChildGuest.class);
    }
}
