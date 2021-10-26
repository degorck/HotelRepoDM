package com.example.demo.service;

import com.example.demo.dto.GuestDTO;
import com.example.demo.dto.request.FilterDTO;
import com.example.demo.dto.response.ResponseGuestDTO;

import java.util.List;

public interface GuestService {
    ResponseGuestDTO createGuest(GuestDTO guestDTO);
    List<ResponseGuestDTO> guestList();
    List<ResponseGuestDTO> guestListFilter(FilterDTO filterDTO);
    ResponseGuestDTO upgradeToVIP(ResponseGuestDTO responseGuestDTO);
}
