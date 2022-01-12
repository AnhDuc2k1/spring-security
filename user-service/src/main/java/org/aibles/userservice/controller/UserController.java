package org.aibles.userservice.controller;

import lombok.AllArgsConstructor;
import org.aibles.userservice.dto.user.UserResponseDTO;
import org.aibles.userservice.dto.user.UserRequestDTO;
import org.aibles.userservice.model.User;
import org.aibles.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {


    @Autowired
    private UserService userService;
//
//    @GetMapping
//    public ResponseEntity<List<User>> getUsers(){
//        return ResponseEntity.ok().body(userService.getUsers());
//    }


//    @GetMapping("/{id}")
//    public ResponseEntity<UserResponseDTO> getUser(@PathVariable("id") int id){
//        UserResponseDTO userResponseDTO = userService.findUserById(id);
//        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<UserResponseDTO>> getListOfUsers(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
//                                                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
//        List<UserResponseDTO> listOfUsersResponseDTO = userService.findAllUsers(pageNumber,pageSize);
//        return new ResponseEntity<>(listOfUsersResponseDTO, HttpStatus.OK);
//    }
//
//        @PostMapping
//        public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
//            UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
//            return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
//        }
//    @PostMapping("/save")
//    public ResponseEntity<User> createUser(@RequestBody User user){
////        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
//        User newUser = userService.save(user);
//        return new ResponseEntity<>(newUser, HttpStatus.OK);
//    }
//
//        @GetMapping("/{id}")
//    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
//        User user = userService.findById(id);
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable ("id") int id,@Valid @RequestBody UserRequestDTO userRequestDTO) {
//        UserResponseDTO userResponseDTO = userService.updateUser(id,userRequestDTO);
//        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
//        userService.deleteUser(id);
//        return new ResponseEntity<>("Delete Successfully",HttpStatus.OK);
//    }
}
