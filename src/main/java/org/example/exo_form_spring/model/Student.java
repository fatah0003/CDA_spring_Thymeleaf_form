package org.example.exo_form_spring.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private UUID id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

}
