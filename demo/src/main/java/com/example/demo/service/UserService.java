package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // data transaction
public class UserService {
    @Autowired
    private UserRepo userRepo;
    // data will be filtered through the repo

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUser(){
      List<User>userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());

    }
    public UserDTO saveUser(UserDTO userDTO) {
        // Map DTO to entity\
        System.out.println("Received UserDTO: " + userDTO);
        User user = modelMapper.map(userDTO, User.class);
        System.out.println("Mapped User entity: " + user);
        // Save user entity (id will be auto-generated)
        User savedUser = userRepo.save(user);
        System.out.println("Saved User entity: " + savedUser);
        // Map saved entity back to DTO
        return modelMapper.map(savedUser, UserDTO.class);
    }
    public UserDTO updateUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

   public String deleteUser(UserDTO userDTO) {
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return "User deleted";
   }
}
//flow =  Controller->DTO->Model->user repo->service(data will be stored as efferent format