package com.example.Fitenssobacked.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(nullable = true)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private  Account account;
}
