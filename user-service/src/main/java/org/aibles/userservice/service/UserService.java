package org.aibles.userservice.service;

import org.aibles.userservice.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService extends UserDetailsService {

//    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
//    UserResponseDTO getUser(int id) ;
//    List <UserResponseDTO> getListOfUsers(int pageNumber, int pageSize);
//    void deleteUser(int id);
//    UserResponseDTO updateUser(int id, UserRequestDTO userRequestDTO);
//    Map<String, Object> login(String account);
//    UserResponseDTO findUserById (int userId);
//    UserResponseDTO findUserByEmail(String email);
//    List<UserResponseDTO> findAllUsers(int pageNumber, int pageSize);
//    Map<String, Object> login(String email);
//    boolean registerUser(UserResponseDTO user);
//    User saveUser(User user);
//    Role saveRole(Role role);
//    void addRoleToUser(String email, String roleName);
//    User getUser(String email);
    List<User> getUsers();
    Optional<User> findById(Long id);
    User save (User user);
    void remove(Long id);
    User findByEmail(String email);
    Map<String, Object> login(String email);
}
