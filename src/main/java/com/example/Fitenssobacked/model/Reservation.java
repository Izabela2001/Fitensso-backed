package com.example.Fitenssobacked.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@Table(name = "reservation")
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataReservation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "fitness_class_id")
    private FitnessClass fitnessClass;

    @Column(name = "is_accepted")
    private Boolean isPurchased;

    public Reservation() {
        this.isPurchased = false;
    }


}
