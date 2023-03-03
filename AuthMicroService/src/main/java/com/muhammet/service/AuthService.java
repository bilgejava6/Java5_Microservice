package com.muhammet.service;

import com.muhammet.dto.request.DoLoginRequestDto;
import com.muhammet.dto.request.RegisterRequestDto;
import com.muhammet.dto.request.UserSaveResquestDto;
import com.muhammet.exception.AuthException;
import com.muhammet.exception.EErrorType;
import com.muhammet.manager.IUserProfileManager;
import com.muhammet.mapper.IAuthMapper;
import com.muhammet.repository.IAuthRepository;
import com.muhammet.repository.entity.Auth;
import com.muhammet.utility.JwtTokenManager;
import com.muhammet.utility.ServiceManager;
import com.muhammet.utility.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository repository;
    private final IUserProfileManager userProfileManager;
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private JwtTokenManager jwtTokenManager;

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

   public String doLogin(DoLoginRequestDto dto){
      Optional<Auth> auth =  repository.findOptionalByUsernameAndPassword(dto.getUsername(),dto.getPassword());
      if(auth.isEmpty())
          throw new AuthException(EErrorType.AUTH_LOGIN_ERROR);
      Optional<String> token = jwtTokenManager.createToken(auth.get().getId());
      if(token.isEmpty())
          throw new AuthException(EErrorType.TOKEN_ERROR);
      return token.get();
   }
}
