package com.example.test123.controller;

import com.example.test123.dto.UserViewDTO;
import com.example.test123.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final UserService userServiceImpl;

    public MainController(final UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    private String openMainPage(ModelMap map) {
        userServiceImpl.saveData();
        List<UserViewDTO> users = userServiceImpl.getAllUsers();
        map.addAttribute("users", users);
        return "index";
    }
}
