package com.example.demo.dao;

import com.example.demo.entity.Subscribers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribersDAO extends JpaRepository<Subscribers, Long> {

}
