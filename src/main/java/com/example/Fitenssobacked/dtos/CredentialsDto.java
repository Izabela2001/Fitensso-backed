package com.example.Fitenssobacked.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CredentialsDto {

    private String login;
    private String password;
}
