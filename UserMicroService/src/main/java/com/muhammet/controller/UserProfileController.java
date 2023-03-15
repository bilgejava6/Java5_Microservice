package com.muhammet.controller;

import com.muhammet.dto.request.BaseRequestDto;
import com.muhammet.dto.request.FindAllPageRequestDto;
import com.muhammet.dto.request.UserSaveResquestDto;
import com.muhammet.repository.entity.UserProfile;
import com.muhammet.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.muhammet.constants.RestEndPoints.*;
@RestController
@RequestMapping(API+VERSION+USER)
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody UserSaveResquestDto dto){
        return ResponseEntity.ok(userProfileService.saveDto(dto));
    }

    @GetMapping(FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<UserProfile>> getAll(@Valid BaseRequestDto dto){
        return ResponseEntity.ok(userProfileService.findAll(dto.getToken()));
    }

    @GetMapping("/getname")
    public ResponseEntity<String> getUpperCaseName(String name){
        return ResponseEntity.ok(userProfileService.getUpperName(name));
    }

    @GetMapping("/clearcache")
    public ResponseEntity<Void> clearCache(){
        userProfileService.clearCache();
        return  ResponseEntity.ok().build();
    }
    @PostMapping(FINDALLPAGE)
    @CrossOrigin("*")
    public ResponseEntity<Page<UserProfile>> findAllPage(@RequestBody  FindAllPageRequestDto dto){
        return ResponseEntity.ok(userProfileService.findAll(dto.getDirection(), dto.getCurrentPage(),
                dto.getPageSize(), dto.getSortingParameter()));
    }


    @GetMapping("/ad")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public ResponseEntity<String> getAd(){
        return ResponseEntity.ok("Muhammet");
    }

    @GetMapping("/soyad")
    @PreAuthorize("hasAuthority('YUKSEK_YERDE_DAYIM_VAR')")
    public ResponseEntity<String> getSoyad(){
        return ResponseEntity.ok("HOCA");
    }

}
