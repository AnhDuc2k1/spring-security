package org.aibles.userservice.mapper;

import org.aibles.userservice.dto.user.UserRequestDTO;
import org.aibles.userservice.dto.user.UserResponseDTO;
import org.aibles.userservice.model.User;
import org.modelmapper.ModelMapper;

public class UserMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public User convertToEntity(UserRequestDTO userRequestDTO){
        return modelMapper.map(userRequestDTO, User.class);
    }

    public UserResponseDTO convertToUserResponseDTO(User user){
        return modelMapper.map(user, UserResponseDTO.class);
    }

}
