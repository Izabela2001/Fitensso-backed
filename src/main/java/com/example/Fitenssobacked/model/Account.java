package com.example.Fitenssobacked.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;

    @ManyToOne
    @JoinColumn(name = "account_type_id")
    private AccountType accountType;
}
