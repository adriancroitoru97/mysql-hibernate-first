package com.sqlproject.demo.config;

import com.sqlproject.demo.dto.UserDTO;
import com.sqlproject.demo.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        TypeMap<User, UserDTO> propertyMapper = modelMapper.createTypeMap(User.class, UserDTO.class);
        propertyMapper.addMappings(mapper -> mapper.skip(UserDTO::setId));

        return modelMapper;
    }
}
