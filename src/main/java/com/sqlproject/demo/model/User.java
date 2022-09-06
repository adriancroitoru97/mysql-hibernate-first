package com.sqlproject.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter @Setter
public class User {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    private Integer id;

    @Column(length = 32)
    private String name;

    private String email;
    private Integer age;
}
