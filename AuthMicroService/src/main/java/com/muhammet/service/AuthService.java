package com.muhammet.service;

import com.muhammet.dto.request.RegisterRequestDto;
import com.muhammet.dto.request.UserSaveResquestDto;
import com.muhammet.exception.AuthException;
import com.muhammet.exception.EErrorType;
import com.muhammet.manager.IUserProfileManager;
import com.muhammet.mapper.IAuthMapper;
import com.muhammet.repository.IAuthRepository;
import com.muhammet.repository.entity.Auth;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository repository;
    private final IUserProfileManager userProfileManager;

    public AuthService(IAuthRepository repository,IUserProfileManager userProfileManager){
        super(repository);
        this.repository = repository;
        this.userProfileManager = userProfileManager;
    }
   public boolean register(RegisterRequestDto dto){
        if(repository.isUsername(dto.getUsername()))
            throw new AuthException(EErrorType.AUTH_USERNAME_ERROR);
       Auth auth = save(IAuthMapper.INSTANCE.fromRegisterDto(dto));
       userProfileManager.save(UserSaveResquestDto.builder()
                       .authid(auth.getId())
                       .email(auth.getEmail())
                       .username(auth.getUsername())
               .build());
       return true;
   }
}
