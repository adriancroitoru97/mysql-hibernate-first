package com.sqlproject.demo.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "USER")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString @Getter @Setter
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(length = 32)
    private String name;

    private String email;
    private Integer age;
}
