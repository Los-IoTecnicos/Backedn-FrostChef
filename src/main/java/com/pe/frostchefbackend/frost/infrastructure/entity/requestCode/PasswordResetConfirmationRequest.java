package com.pe.frostchefbackend.frost.infrastructure.entity.requestCode;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordResetConfirmationRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String token;

    @NotBlank
    private String newPassword;
}

