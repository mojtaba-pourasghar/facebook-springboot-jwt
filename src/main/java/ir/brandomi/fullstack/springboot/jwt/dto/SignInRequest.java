package ir.brandomi.fullstack.springboot.jwt.dto;

import lombok.Data;

@Data
public class SignInRequest {
    private String username;
    private String password;
}
