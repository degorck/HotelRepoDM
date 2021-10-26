package com.example.demo.service;

import com.example.demo.dto.GuestTypeDTO;
import com.example.demo.dto.response.ResponseGuestTypeDTO;

import java.util.List;

public interface GuestTypeService {
    ResponseGuestTypeDTO createGuestType(GuestTypeDTO guestTypeDTO);
    List<ResponseGuestTypeDTO> guestTypeList();
}
