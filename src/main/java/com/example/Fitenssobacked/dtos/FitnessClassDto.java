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
public class FitnessClassDto {
    private Long id;
    private Integer numberClass;
    private  Long fitenssTypeClass;;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer activePlace;
    private Integer maxPlace;
    private Long user;
}
