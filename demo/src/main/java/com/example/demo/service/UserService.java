package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // data transaction
public class UserService {
    @Autowired
    private UserRepo userRepo;
    // data will be filtered through the repo

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUser(){
      List<User>userList=userRepo.findAll();
        return modelMapper.map(userList new MethodDescription.TypeToken());
    }
}
//flow =  Controller->DTO->Model->user repo->service(data will be stored as efferent format