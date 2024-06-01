package com.example.demo.controller;

import com.example.demo.entity.EventEntity;
import com.example.demo.service.IEventService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "iasapi/events")
@RequiredArgsConstructor
public class EventController {


    final IEventService eventService;


    @GetMapping()
    public ResponseEntity<List<EventEntity>> getAllEvents(){
        return new ResponseEntity<>(eventService.getAllEvents(),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<EventEntity>>getEventById(@PathVariable int id){
        return new ResponseEntity<>(eventService.getEventById(id),HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EventEntity>updateEventById(@PathVariable int id,@RequestBody EventEntity eventEntity){
        return new ResponseEntity<>(eventService.updateEvent(id,eventEntity),HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteEventById(@PathVariable int id){
        return new ResponseEntity<>(eventService.deleteEventById(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<EventEntity> saveEvent(@RequestBody EventEntity eventEntity){
        return new ResponseEntity<>(eventService.saveEvent(eventEntity), HttpStatus.OK);
    }
}
