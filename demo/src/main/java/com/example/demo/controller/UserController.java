package com.example.demo.controller;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

@RequestMapping("api/v1/")
public class UserController {
@Autowired
private UserService userService;

    @GetMapping("/getuser")
    public List<UserDTO> getUser() {
          return userService.getAllUser();
    }
    @PostMapping("/adduser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }
}
