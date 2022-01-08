package org.aibles.userservice.service.iml;

import org.aibles.userservice.model.User;
import org.aibles.userservice.repository.UserRepository;
//import org.aibles.userservice.security.UserDetailsImpl;
//import org.aibles.userservice.security.jwt.JwtProvider;
import org.aibles.userservice.security.JwtProvider;
import org.aibles.userservice.security.UserPrincipal;
import org.aibles.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newUser = userRepository.save(user);
        return newUser;
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User existingUser = userRepository.findByEmail(email);
        if (existingUser == null){
            throw new UsernameNotFoundException(email);
        }
        return UserPrincipal.create(existingUser);
    }

    @Override
    public Map<String, Object> login(String email) {
        User user = userRepository.findByEmail(email);
        String userRole = user.getRoles().iterator().next().getName();
        String token = jwtProvider.generateToken(email, userRole);

        Map<String, Object> response = new HashMap<>();
        response.put("email", email);
        response.put("token", token);
        response.put("userRole", userRole);
        return response;
    }

    //    @Override
//    public UserResponseDTO findUserById(int userId) {
//        User existingUser = userRepository.findById(userId).orElse(null);
//        if (existingUser == null ) {
//                throw new UserNotFoundException();
//        }
//        else {
//            return userMapper.convertToUserResponseDTO(existingUser);
//        }
//    }
//
//    @Override
//    public UserResponseDTO findUserByEmail(String email) {
//        User existingUser = userRepository.findByEmail(email);
//        return userMapper.convertToUserResponseDTO(existingUser);
//    }
//
//    @Override
//    public List<UserResponseDTO> findAllUsers(int pageNumber, int pageSize) {
//        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
//        return  userRepository.findAll(pageable).stream().map(user -> userMapper.convertToUserResponseDTO(user))
//                       .collect(Collectors.toList());
//    }
//
//    @Override
//    public Map<String, Object> login(String email) {
//        User user = userRepository.findByEmail(email);
//        String userRole = user.getRoles().iterator().next().name();
//        String token = jwtTokenProvider.createToken(email, userRole);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("email", email);
//        response.put("token", token);
//        response.put("userRole", userRole);
//        return response;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email){
//        User user = userRepository.findByEmail(email);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return UserDetailsImpl.create(user);
//    }
//
//        @Override
//    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
//        User existingUser = userRepository.findById(userMapper.convertToEntity(userRequestDTO).getId()).orElse(null);
//        if (existingUser !=null ) {
//            throw new UserAlreadyExistsException();
//        }
//        User userCreated = userRepository.save(userMapper.convertToEntity(userRequestDTO));
//        return userMapper.convertToUserResponseDTO(userCreated);
//    }

//    @Override
//    public UserResponseDTO getUser(int id){
//        User existingUser = userRepository.findById(id).orElse(null);
//        if (existingUser == null ) {
//                throw new UserNotFoundException();
//        }
//        else {
//            return userMapper.convertToUserResponseDTO(existingUser);
//        }
//    }
//
//    @Override
//    public List<UserResponseDTO> getListOfUsers(int pageNumber, int pageSize) {
//        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
//        return  userRepository.findAll(pageable).stream().map(user -> userMapper.convertToUserResponseDTO(user))
//                       .collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteUser(int id){
//        User existingUser = userRepository.findById(id).orElse(null);
//        if (existingUser == null) {
//            throw new UserNotFoundException();
//        } else {
//            userRepository.delete(existingUser);
//        }
//    }
//
//    @Override
//    public UserResponseDTO updateUser(int id, UserRequestDTO newUserDetails){
//        User existingUser = userRepository.findById(id).orElse(null);
//        if (existingUser == null) {
//            throw new UserNotFoundException();
//        } else {
//            existingUser.setName(newUserDetails.getName());
//            existingUser.setAge(newUserDetails.getAge());
//            existingUser.setPassword(newUserDetails.getPassword());
//            existingUser.setAccount(newUserDetails.getAccount());
//            existingUser.setEmail(newUserDetails.getEmail());
//            User updatedUser = userRepository.save(existingUser);
//            return userMapper.convertToUserResponseDTO(updatedUser);
//        }
//    }
}
