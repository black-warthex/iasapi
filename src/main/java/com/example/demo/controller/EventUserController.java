package com.example.demo.controller;

import com.example.demo.entity.UserDTO;
import com.example.demo.service.IEventUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("iasapi/events")
@RequiredArgsConstructor
public class EventUserController {

    final IEventUserService eventUserService;

    @PostMapping(path = "/{id}/register")
    public ResponseEntity<String> saveEventUser(@PathVariable int id, @RequestBody UserDTO userEntity){
        try {
            return new ResponseEntity<>(eventUserService.saveEventUser(id,userEntity), HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>("Event with id " +id+ " not found",HttpStatus.NOT_FOUND);
        }
    }



}
