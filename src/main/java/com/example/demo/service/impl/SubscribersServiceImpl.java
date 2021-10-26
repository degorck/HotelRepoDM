package com.example.demo.service.impl;

import com.example.demo.dao.SubscribersDAO;
import com.example.demo.dto.SubscribersDTO;
import com.example.demo.mapper.SubscribersMapper;
import com.example.demo.service.SubscribersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribersServiceImpl implements SubscribersService {
    @Autowired
    SubscribersMapper subscribersMapper;

    @Autowired
    SubscribersDAO subscribersDAO;

    @Override
    public SubscribersDTO createSubscriber(SubscribersDTO subscribersDTO) {
        return subscribersMapper.subscribersToSubscribersDTO(subscribersDAO.save(subscribersMapper.subscribersDTOToSubscribers(subscribersDTO)));
    }
}
