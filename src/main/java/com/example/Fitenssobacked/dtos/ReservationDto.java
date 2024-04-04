package com.example.Fitenssobacked.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDto {
    private Long id;
    private LocalDateTime dataReservation;
    private Long user;
    private Long fitnessClass;
    private Boolean isPurchased;

}
