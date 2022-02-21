package org.aibles.userservice;

import lombok.RequiredArgsConstructor;
import org.aibles.userservice.model.Role;
import org.aibles.userservice.model.User;
import org.aibles.userservice.repository.RoleRepository;
import org.aibles.userservice.repository.UserRepository;
import org.aibles.userservice.service.RoleService;
import org.aibles.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.*;

@SpringBootApplication
public class UserServiceApplication {

    @Autowired
    private   UserService userService;

    @Autowired
    private  RoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @PostConstruct
    public String initUser(){
        Role roleAdmin = new Role();
        roleAdmin.setId(1L);
        roleAdmin.setName("ROLE_ADMIN");
        roleService.save(roleAdmin);
        Role roleUser = new Role();
        roleUser.setId(2L);
        roleUser.setName("ROLE_USER");
        roleService.save(roleUser);

        User admin = new User();
        Set<Role> roles = new HashSet<>();
        roles.add(roleAdmin);
        admin.setId(1L);
        admin.setName("admin");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("123456");
        admin.setActived(true);
        admin.setRoles(roles);
        userService.save(admin);

        User admin1 = new User();
        Set<Role> role1s = new HashSet<>();
        role1s.add(roleAdmin);
        admin.setId(2L);
        admin.setName("anhduc");
        admin.setEmail("anhduc2k1vn@gmail.com");
        admin.setPassword("Anhduc2001");
        admin.setActived(true);
        admin.setRoles(roles);
        userService.save(admin);

        return "saved";
    }

//    @PostConstruct
//    public void init() {
//            Role roleAdmin = new Role();
//            roleAdmin.setId(1L);
//            roleAdmin.setName("ROLE_ADMIN");
//            roleService.save(roleAdmin);
//            Role roleUser = new Role();
//            roleUser.setId(2L);
//            roleUser.setName("ROLE_USER");
//            roleService.save(roleUser);
//
//            User admin = new User();
//            Set<Role> roles = new HashSet<>();
//            Role roleAdmin1 = new Role();
//            roleAdmin1.setId(1L);
//            roleAdmin1.setName("ROLE_ADMIN");
//            roles.add(roleAdmin1);
//            admin.setEmail("admin");
//            admin.setPassword("123456");
//            admin.setRoles(roles);
//            userService.save(admin);
//
//    }

}