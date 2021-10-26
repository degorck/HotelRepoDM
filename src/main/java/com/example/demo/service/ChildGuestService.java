package com.example.demo.service;

import com.example.demo.dto.ChildGuestDTO;
import com.example.demo.dto.response.ResponseChildGuestDTO;

public interface ChildGuestService {
    ResponseChildGuestDTO createChildGuest(ChildGuestDTO childGuestDTO);
}
