package com.sqlproject.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private String id;
    private String name;
    private String email;
    private Integer age;
}
