package org.aibles.userservice.configuration;

import org.aibles.userservice.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapperConfiguration {

    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }

}
