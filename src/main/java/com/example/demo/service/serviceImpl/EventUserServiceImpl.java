package com.example.demo.service.serviceImpl;

import com.example.demo.entity.EventEntity;
import com.example.demo.entity.EventUserEntity;
import com.example.demo.entity.UserDTO;
import com.example.demo.repository.IEventUserRepository;
import com.example.demo.service.IEventService;
import com.example.demo.service.IEventUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventUserServiceImpl implements IEventUserService {
    final IEventService eventService;
    final IEventUserRepository repository;

    @Override
    public String saveEventUser(int id, UserDTO userDTO) {
        Optional<EventEntity> event = eventService.getEventById(id);
        if(event.isPresent()){
            repository.save(EventUserEntity.builder().userId(userDTO.getUserId()).eventId(id).build());
            return "ok";
        }
        throw new EntityNotFoundException("Event not found");
    }
}
