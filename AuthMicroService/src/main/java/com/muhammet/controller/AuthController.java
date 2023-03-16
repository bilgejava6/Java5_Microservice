package com.muhammet.controller;

import com.muhammet.dto.request.DoLoginRequestDto;
import com.muhammet.dto.request.RegisterRequestDto;
import com.muhammet.dto.response.DoLoginResponseDto;
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
    @CrossOrigin("*")
    public ResponseEntity<Boolean> register(@RequestBody @Valid RegisterRequestDto dto){
        if(!dto.getPassword().equals(dto.getRepassword()))
            throw new AuthException(EErrorType.AUTH_PASSWORD_ERROR);
        authService.register(dto);
        return ResponseEntity.ok(true);
    }
    @PostMapping(LOGIN)
    @CrossOrigin("*")
    public ResponseEntity<DoLoginResponseDto> doLogin(@RequestBody @Valid DoLoginRequestDto dto){
        return ResponseEntity.ok(
                DoLoginResponseDto.builder()
                        .token(authService.doLogin(dto))
                        .build()
        );
    }
    @GetMapping("/message")
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok(ifade);
    }
}
