package com.example.demo.utils.observer;

import com.example.demo.dto.request.NewDTO;

import java.util.ArrayList;
import java.util.List;

public class NewsLetter{
    private NewDTO news;
    private List<Subscriber> subscribers = new ArrayList<>();

    public void addObserver(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void removeObserver(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }

    public void setNews(NewDTO news){
        this.news = news;
        for(Subscriber subscriber : this.subscribers){
            subscriber.update(this.news);
        }
    }


}
