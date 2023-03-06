package com.muhammet.controller;

import com.muhammet.dto.request.BaseRequestDto;
import com.muhammet.dto.request.UserSaveResquestDto;
import com.muhammet.repository.entity.UserProfile;
import com.muhammet.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.muhammet.constants.RestEndPoints.*;
@RestController
@RequestMapping(API+VERSION+USER)
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody UserSaveResquestDto dto){
        return ResponseEntity.ok(userProfileService.saveDto(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<UserProfile>> getAll(@Valid BaseRequestDto dto){
        return ResponseEntity.ok(userProfileService.findAll(dto.getToken()));
    }

}
