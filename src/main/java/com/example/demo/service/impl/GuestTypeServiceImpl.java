package com.example.demo.service.impl;

import com.example.demo.dao.GuestTypeDAO;
import com.example.demo.dto.GuestTypeDTO;
import com.example.demo.dto.response.ResponseGuestTypeDTO;
import com.example.demo.entity.GuestType;
import com.example.demo.mapper.GuestTypeMapper;
import com.example.demo.service.GuestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestTypeServiceImpl implements GuestTypeService {
    @Autowired
    GuestTypeDAO guestTypeDAO;

    @Autowired
    GuestTypeMapper guestTypeMapper;

    @Override
    public ResponseGuestTypeDTO createGuestType(GuestTypeDTO guestTypeDTO) {
        return guestTypeMapper.guestTypeToResponseGuestTypeDTO(guestTypeDAO.save(guestTypeMapper.guestTypeDTOToGuestType(guestTypeDTO)));
    }

    @Override
    public List<ResponseGuestTypeDTO> guestTypeList() {
        List<GuestType> guestTypeList = guestTypeDAO.findAll();
        List<ResponseGuestTypeDTO> guestTypeDTOList = new ArrayList<>();
        for(GuestType guestType:guestTypeList){
            guestTypeDTOList.add(guestTypeMapper.guestTypeToResponseGuestTypeDTO(guestType));
        }
        return guestTypeDTOList;
    }
}
