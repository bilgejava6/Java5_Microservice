package com.muhammet.service;

import com.muhammet.dto.request.BaseRequestDto;
import com.muhammet.dto.request.UserSaveResquestDto;
import com.muhammet.exception.EErrorType;
import com.muhammet.exception.UserException;
import com.muhammet.mapper.IUserProfileMapper;
import com.muhammet.repository.IUserProfileRepository;
import com.muhammet.repository.entity.UserProfile;
import com.muhammet.utility.ServiceManager;
import com.muhammet.utility.TokenManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,Long> {
    private final IUserProfileRepository repository;
    private final TokenManager tokenManager;
    public UserProfileService(IUserProfileRepository repository,
                              TokenManager tokenManager){
        super(repository);
        this.repository=repository;
        this.tokenManager = tokenManager;
    }
    public Boolean saveDto(UserSaveResquestDto dto){
        UserProfile userProfile= IUserProfileMapper.INSTANCE.toUserProfile(dto);
        save(userProfile);
        return true;
    }

    public List<UserProfile> findAll(String token){
        Long authid = tokenManager.getDecodeToken(token);
        Optional<UserProfile> userProfile = repository.findOptionalByAuthid(authid);
        if(userProfile.isEmpty())
            throw new UserException(EErrorType.INVALID_TOKEN);
        return findAll();
    }
}
