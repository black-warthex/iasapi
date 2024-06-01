package com.example.demo.service;

import com.example.demo.entity.EventEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IEventService {
    EventEntity saveEvent(EventEntity eventEntity);
    List<EventEntity> getAllEvents();
    Optional<EventEntity> getEventById(int id);
    String deleteEventById(int id);
    EventEntity updateEvent(int id,EventEntity eventEntity);
}
