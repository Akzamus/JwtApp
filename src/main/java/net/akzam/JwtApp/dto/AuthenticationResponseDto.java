package net.akzam.JwtApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthenticationResponseDto {
    private String username;
    private String token;
}
