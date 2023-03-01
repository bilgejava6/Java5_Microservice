package com.muhammet.service;

import com.muhammet.dto.request.RegisterRequestDto;
import com.muhammet.exception.AuthException;
import com.muhammet.exception.EErrorType;
import com.muhammet.mapper.IAuthMapper;
import com.muhammet.repository.IAuthRepository;
import com.muhammet.repository.entity.Auth;
import com.muhammet.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository repository;
    public AuthService(IAuthRepository repository){
        super(repository);
        this.repository = repository;
    }
   public boolean register(RegisterRequestDto dto){
        if(repository.isUsername(dto.getUsername()))
            throw new AuthException(EErrorType.AUTH_USERNAME_ERROR);
       save(IAuthMapper.INSTANCE.fromRegisterDto(dto));
       return true;
   }
}
