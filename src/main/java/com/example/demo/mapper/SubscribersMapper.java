package com.example.demo.mapper;

import com.example.demo.dto.SubscribersDTO;
import com.example.demo.entity.Subscribers;
import com.example.demo.utils.observer.Subscriber;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubscribersMapper {
    @Autowired
    ModelMapper modelMapper;

    public Subscribers subscribersDTOToSubscribers(SubscribersDTO subscribersDTO){
        return modelMapper.map(subscribersDTO, Subscribers.class);
    }

    public SubscribersDTO subscribersToSubscribersDTO(Subscribers subscribers){
        return modelMapper.map(subscribers, SubscribersDTO.class);
    }
}
