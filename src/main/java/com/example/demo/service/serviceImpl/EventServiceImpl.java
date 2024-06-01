package com.example.demo.service.serviceImpl;

import com.example.demo.entity.EventEntity;
import com.example.demo.repository.IEventRepository;
import com.example.demo.service.IEventService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements IEventService {

    final IEventRepository repository;

    @Override
    public EventEntity saveEvent(EventEntity eventEntity) {
        return repository.save(eventEntity);
    }

    @Override
    public List<EventEntity> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public Optional<EventEntity> getEventById(int id) throws EntityNotFoundException {
        Optional<EventEntity> event = repository.findById((long) id);
        if (event.isEmpty()) {
            System.out.println("not found");
            throw new EntityNotFoundException("Event not found");
        }
        return event;
    }

    @Override
    public String deleteEventById(int id) {
        try {
            repository.deleteById((long) id);
            return "event deleted";
        } catch (RuntimeException e) {
            throw new RuntimeException("error on delete");

        }
    }

    @Override
    public EventEntity updateEvent(int id , EventEntity eventEntity) {

        Optional<EventEntity> event = repository.findById((long) id);

        if (event.isPresent()){
            event.get().setEventName(eventEntity.getEventName());
            event.get().setEventDate(eventEntity.getEventDate());
            event.get().setEventLocation(eventEntity.getEventLocation());
            return repository.save(event.get());
        }
        throw new EntityNotFoundException("Event not found");

    }
}
