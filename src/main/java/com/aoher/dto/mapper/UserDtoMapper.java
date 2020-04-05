package com.aoher.dto.mapper;

import com.aoher.dto.UserDto;
import com.aoher.entity.User;
import com.aoher.services.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class UserDtoMapper {

    @Autowired
    private UserService userService;

    ModelMapper modelmapper = new ModelMapper();

    PropertyMap<UserDto, User> userMap = new PropertyMap<>() {
        protected void configure() {
            map().setFirstName(source.getFirstName());
            map().setLastName(source.getLastName());
            map().setEmail(source.getEmail());
            map().setDesignation(source.getDesignation());
        }
    };

    @SuppressWarnings("unused")
    private UserDtoMapper EntityToDTO(User user) {
        return modelmapper.map(user, UserDtoMapper.class);
    }


    public User saveUser(UserDto userDto) {
        TypeMap<UserDto, User> typeMap = modelmapper.getTypeMap(UserDto.class, User.class);
        if (typeMap == null) {
            modelmapper.addMappings(userMap);
        }

        User user = modelmapper.map(userDto, User.class);
        return userService.saveUser(user);
    }

    public List<UserDto> getAllUsers() {
        List<User> user = userService.getUsers();
        Type listType = new TypeToken<List<UserDto>>() {
        }.getType();
        return new ModelMapper().map(user, listType);
    }

    public UserDto deleteUser(int userId) {
        userService.deleteUserById(userId);
        return null;
    }

    public void updateUsers(UserDto userDto) {
        User user = modelmapper.map(userDto, User.class);
        EntityToDTO(userService.updateUser(user));
    }
}