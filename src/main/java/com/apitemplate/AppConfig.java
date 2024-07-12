package com.apitemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apitemplate.dto.BoletoDTO;
import com.apitemplate.dto.UserDTO;

@Configuration
public class AppConfig {

    @Bean
    UserDTO userDTO() {
        return new UserDTO();
    }

    @Bean
    BoletoDTO boletoDTO() {
        return new BoletoDTO();
    }

}