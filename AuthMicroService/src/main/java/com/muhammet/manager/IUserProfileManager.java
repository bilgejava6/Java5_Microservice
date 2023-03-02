package com.muhammet.manager;

import com.muhammet.dto.request.UserSaveResquestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.muhammet.constants.RestEndPoints.SAVE;

/**
 * name => uniq oolmalıdır. kopyala yapıştır yaparken genellikle insanlar unutuyorlar
 *  ve isimleri aynı kullanıyortlar bu nedenle doğru çalşmıyor.
 */
@FeignClient(
        name = "user-profile-service-feign",
        url = "${bu-benim-tanimim.userprofile-url}",
        decode404 = true
)
public interface IUserProfileManager {

    @PostMapping(SAVE)
    ResponseEntity<Boolean> save(@RequestBody UserSaveResquestDto dto);
}
