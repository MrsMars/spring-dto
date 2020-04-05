package com.aoher.controller;

import com.aoher.dto.UserDto;
import com.aoher.dto.mapper.UserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDtoMapper userDtoMapper;

    @PostMapping("/saveUser")
    public HttpStatus saveProject(@Valid @RequestBody UserDto userDto) {
        userDtoMapper.saveUser(userDto);
        return HttpStatus.CREATED;
    }

    @GetMapping("/getAllUsers")
    public List<UserDto> getUsers() {
        return userDtoMapper.getAllUsers();
    }

    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable int id) {
        userDtoMapper.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto) {
        userDtoMapper.updateUsers(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.NO_CONTENT);
    }
}