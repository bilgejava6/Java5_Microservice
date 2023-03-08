package com.muhammet.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(indexName = "userprofile")
public class UserProfile extends BaseEntity{
    @Id
    String id;
    Long userid;
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
