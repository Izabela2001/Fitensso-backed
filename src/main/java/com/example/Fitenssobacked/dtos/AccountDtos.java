package com.example.Fitenssobacked.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDtos {
    private Long id;
    private String login;
    private String password;
    private Long accountType;
}
