package com.example.demo.service.impl;

import com.example.demo.dao.GuestDAO;
import com.example.demo.dao.GuestTypeDAO;
import com.example.demo.dto.GuestDTO;
import com.example.demo.dto.request.FilterDTO;
import com.example.demo.dto.response.ResponseGuestDTO;
import com.example.demo.entity.Guest;
import com.example.demo.entity.GuestType;
import com.example.demo.mapper.GuestMapper;
import com.example.demo.mapper.GuestTypeMapper;
import com.example.demo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.utils.Constants.BOOLEAN_TRUE;
import static com.example.demo.utils.Constants.VIP_LABEL;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    GuestDAO guestDAO;

    @Autowired
    GuestMapper guestMapper;

    @Autowired
    GuestTypeDAO guestTypeDAO;

    @Autowired
    GuestTypeMapper guestTypeMapper;

    @Override
    public ResponseGuestDTO createGuest(GuestDTO guestDTO) {
        Guest guest = (guestMapper.guestDTOToGuest(guestDTO));
        guest.setStatus(BOOLEAN_TRUE);
        return guestMapper.guestToResponseGuestDTO(guestDAO.save(guest));
    }

    @Override
    public List<ResponseGuestDTO> guestList() {
        List<Guest> guestList = guestDAO.findAll();
        List<ResponseGuestDTO> guestListDTO = new ArrayList<>();
        for(Guest guest:guestList){
            guestListDTO.add(guestMapper.guestToResponseGuestDTO(guest));
        }
        return guestListDTO;
    }

    @Override
    public List<ResponseGuestDTO> guestListFilter(FilterDTO filterDTO) {
        return guestList()
                .stream()
                .filter(g -> g.getFirstName().contains(filterDTO.getValue()) || g.getLastName().contains(filterDTO.getValue()) || g.getEmail().contains(filterDTO.getValue()) || g.getType().getName().contains(filterDTO.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseGuestDTO upgradeToVIP(ResponseGuestDTO responseGuestDTO) {
        Guest guest = guestMapper.responseGuestDTOToGuest(responseGuestDTO);
        GuestType guestType = guestTypeDAO.getGuestTypeByNameEquals(VIP_LABEL);
        guest.setType(guestType);
        return guestMapper.guestToResponseGuestDTO(guestDAO.save(guest));
    }
}
