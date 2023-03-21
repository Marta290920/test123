package com.example.test123.service;

import com.example.test123.dto.UserViewDTO;

import java.util.List;

public interface UserService {
    void saveData();

    List<UserViewDTO> getAllUsers();
}
