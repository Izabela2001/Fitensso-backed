package com.example.Fitenssobacked.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "fitness_class")
public class FitnessClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberClass;
    @ManyToOne
    @JoinColumn(name = "fitness_type_class")
    private FitenssTypeClass fitenssTypeClass;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer activePlace;
    private Integer maxPlace;

    @ManyToOne
    @JoinColumn(name = "id_account")
    private  Account account;
}
