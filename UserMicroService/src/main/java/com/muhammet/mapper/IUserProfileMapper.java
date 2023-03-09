package com.muhammet.mapper;

import com.muhammet.dto.request.UserProfileSaveRequestDto;
import com.muhammet.dto.request.UserSaveResquestDto;
import com.muhammet.rabbitmq.model.CreateUser;
import com.muhammet.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IUserProfileMapper {

    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);

    UserProfile toUserProfile(final UserSaveResquestDto dto);
    UserProfile toUserProfile(final CreateUser createUser);

    UserProfileSaveRequestDto fromUserProfile(final UserProfile profile);

}
