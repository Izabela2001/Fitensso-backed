package com.example.Fitenssobacked.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataReservation;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private  Account account;
    @ManyToOne
    @JoinColumn(name = "fitness_class_id")
    private  FitnessClass fitnessClass;

    @Column(name = "is_accepted")
    private Boolean isPurchased;

    public Reservation(){
        this.isPurchased = false;
    }

}
