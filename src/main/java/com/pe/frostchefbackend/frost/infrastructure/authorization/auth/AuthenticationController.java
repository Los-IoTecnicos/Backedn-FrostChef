package com.pe.frostchefbackend.frost.infrastructure.authorization.auth;

import com.pe.frostchefbackend.frost.infrastructure.entity.requestCode.ActivationRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(
            @RequestBody @Valid RegistrationRequest request
    ) throws MessagingException {
        service.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        AuthenticationResponse response = service.authenticate(request);

        String verificationCode = "";

        service.storeVerificationCode(request.getEmail(), verificationCode);

        return ResponseEntity.ok(response);
    }


    @PostMapping("/activate-account")
    public ResponseEntity<?> confirm(
            @RequestBody ActivationRequest request
    ) throws MessagingException {
        service.activateAccount(request.getEmail(), request.getCode());
        return ResponseEntity.ok().build();
    }


}