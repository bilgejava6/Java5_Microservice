package com.muhammet.dto.request;

import com.muhammet.repository.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class UserProfileSaveRequestDto extends BaseEntity {
    Long id;
    /**
     * Kullanıcı kayıt olurken oluşan ve user,pass bilgileri tutulan
     * kayda ait eşleştirmede kullanılacaktır.
     */
    Long authid;
    String username;
    String email;
    String photo;
    String about;
    String phone;
    String age;
    String website;

}
