package com.sqlproject.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final Integer id;
    private final String name;
    private final String email;
    private final Integer age;
}
