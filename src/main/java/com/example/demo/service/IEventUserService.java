package com.example.demo.service;

import com.example.demo.entity.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface IEventUserService {
    String saveEventUser(int id, UserDTO userEntity);
}
