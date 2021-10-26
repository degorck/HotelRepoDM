package com.example.demo.service.impl;

import com.example.demo.dao.ChildGuestDAO;
import com.example.demo.dto.ChildGuestDTO;
import com.example.demo.dto.response.ResponseChildGuestDTO;
import com.example.demo.mapper.ChildGuestMapper;
import com.example.demo.service.ChildGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildGuestServiceImpl implements ChildGuestService {
    @Autowired
    ChildGuestDAO childGuestDAO;

    @Autowired
    ChildGuestMapper childGuestMapper;

    @Override
    public ResponseChildGuestDTO createChildGuest(ChildGuestDTO childGuestDTO) {
        return childGuestMapper.childGuestToResponseChildGuestDTO(childGuestDAO.save(childGuestMapper.childGuestDTOToChildGuest(childGuestDTO)));
    }
}
