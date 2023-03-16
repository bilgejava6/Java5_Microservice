package com.muhammet.mapper;

import com.muhammet.dto.request.UserProfileSaveRequestDto;
import com.muhammet.dto.request.UserSaveResquestDto;
import com.muhammet.rabbitmq.model.CreateUser;
import com.muhammet.repository.entity.UserProfile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-16T15:21:52+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.3.1 (Oracle Corporation)"
)
@Component
public class IUserProfileMapperImpl implements IUserProfileMapper {

    @Override
    public UserProfile toUserProfile(UserSaveResquestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder<?, ?> userProfile = UserProfile.builder();

        userProfile.authid( dto.getAuthid() );
        userProfile.username( dto.getUsername() );
        userProfile.email( dto.getEmail() );

        return userProfile.build();
    }

    @Override
    public UserProfile toUserProfile(CreateUser createUser) {
        if ( createUser == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder<?, ?> userProfile = UserProfile.builder();

        userProfile.authid( createUser.getAuthid() );
        userProfile.username( createUser.getUsername() );
        userProfile.email( createUser.getEmail() );

        return userProfile.build();
    }

    @Override
    public UserProfileSaveRequestDto fromUserProfile(UserProfile profile) {
        if ( profile == null ) {
            return null;
        }

        UserProfileSaveRequestDto.UserProfileSaveRequestDtoBuilder<?, ?> userProfileSaveRequestDto = UserProfileSaveRequestDto.builder();

        userProfileSaveRequestDto.state( profile.isState() );
        userProfileSaveRequestDto.createdate( profile.getCreatedate() );
        userProfileSaveRequestDto.updatedate( profile.getUpdatedate() );
        userProfileSaveRequestDto.id( profile.getId() );
        userProfileSaveRequestDto.authid( profile.getAuthid() );
        userProfileSaveRequestDto.username( profile.getUsername() );
        userProfileSaveRequestDto.email( profile.getEmail() );
        userProfileSaveRequestDto.photo( profile.getPhoto() );
        userProfileSaveRequestDto.about( profile.getAbout() );
        userProfileSaveRequestDto.phone( profile.getPhone() );
        userProfileSaveRequestDto.age( profile.getAge() );
        userProfileSaveRequestDto.website( profile.getWebsite() );

        return userProfileSaveRequestDto.build();
    }
}
