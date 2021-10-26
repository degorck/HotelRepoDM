package com.example.demo.service.impl;

import com.example.demo.dao.SubscribersDAO;
import com.example.demo.dto.request.NewDTO;
import com.example.demo.entity.Subscribers;
import com.example.demo.service.NewsService;
import com.example.demo.utils.observer.NewsLetter;
import com.example.demo.utils.observer.NewsSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    SubscribersDAO subscribersDAO;

    @Override
    public void sendNews(NewDTO newDTO) {
        //NewsLetter observable = new NewsLetter();
        //NewsSubscriber observer = new NewsSubscriber();
        //NewsSubscriber observer2 = new NewsSubscriber();
        //observable.addObserver(observer);
        //observable.addObserver(observer2);
        //observable.setNews(newDTO);
        NewsLetter newsLetter = new NewsLetter();
        List<Subscribers> subscribers = subscribersDAO.findAll();
        subscribers.forEach(subscriber -> {
            NewsSubscriber observer = new NewsSubscriber();
            observer.setEmail(subscriber.getEmail());
            newsLetter.addObserver(observer);
        });
        newsLetter.setNews(newDTO);
    }
}
