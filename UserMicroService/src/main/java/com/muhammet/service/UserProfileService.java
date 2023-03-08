package com.muhammet.service;

import com.muhammet.dto.request.BaseRequestDto;
import com.muhammet.dto.request.UserSaveResquestDto;
import com.muhammet.exception.EErrorType;
import com.muhammet.exception.UserException;
import com.muhammet.mapper.IUserProfileMapper;
import com.muhammet.repository.IUserProfileRepository;
import com.muhammet.repository.entity.UserProfile;
import com.muhammet.utility.JwtTokenManager;
import com.muhammet.utility.ServiceManager;
import com.muhammet.utility.TokenManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,Long> {
    private final IUserProfileRepository repository;

    private final JwtTokenManager jwtTokenManager;
    public UserProfileService(IUserProfileRepository repository,
                              JwtTokenManager jwtTokenManager
                              ){
        super(repository);
        this.repository=repository;
        this.jwtTokenManager = jwtTokenManager;
    }
    public Boolean saveDto(UserSaveResquestDto dto){
        UserProfile userProfile= IUserProfileMapper.INSTANCE.toUserProfile(dto);
        save(userProfile);
        return true;
    }

    public List<UserProfile> findAll(String token){
        Optional<Long> authid = jwtTokenManager.getIdFromToken(token);
        if(authid.isEmpty())
            throw new UserException(EErrorType.INVALID_TOKEN);
        Optional<UserProfile> userProfile = repository.findOptionalByAuthid(authid.get());
        if(userProfile.isEmpty())
            throw new UserException(EErrorType.INVALID_TOKEN,"Token için gönderilen kullanıcı sistemde kayıtlı değildir.");
        return findAll();
    }


    @Cacheable(value = "getUpperName")
    public String getUpperName(String name){
        try{
            Thread.sleep(3000);
        }catch (Exception exception){

        }
        return name.toUpperCase();
    }

    @CacheEvict(value ="getUpperName", allEntries = true )
    public void clearCache(){
        System.out.println("Tüm Cache temizlendi.");
    }
}
