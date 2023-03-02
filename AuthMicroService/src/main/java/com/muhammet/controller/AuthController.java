package com.muhammet.controller;

import com.muhammet.dto.request.DoLoginRequestDto;
import com.muhammet.dto.request.RegisterRequestDto;
import com.muhammet.exception.AuthException;
import com.muhammet.exception.EErrorType;
import com.muhammet.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.muhammet.constants.RestEndPoints.*;
@RestController
@RequestMapping(API+VERSION+AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @Value("${bu-benim-tanimim.bunedirki}")
    private String ifade;

    @PostMapping(REGISTER)
    public ResponseEntity<Boolean> register(@RequestBody @Valid RegisterRequestDto dto){
        if(!dto.getPassword().equals(dto.getRepassword()))
            throw new AuthException(EErrorType.AUTH_PASSWORD_ERROR);
        authService.register(dto);
        return ResponseEntity.ok(true);
    }
    @PostMapping(LOGIN)
    public ResponseEntity<String> doLogin(@RequestBody @Valid DoLoginRequestDto dto){
        return ResponseEntity.ok(authService.doLogin(dto));
    }
    @GetMapping("/message")
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok(ifade);
    }
}
