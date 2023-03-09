package com.muhammet.manager;

import com.muhammet.dto.request.UserProfileSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.muhammet.constants.RestEndPoints.SAVE;

@FeignClient(
        name = "elastic-service-feign",
        url = "http://localhost:9999/user",
        decode404 = true
)
public interface IElasticServiceManager {

    @PostMapping(SAVE)
    ResponseEntity<Void> save(@RequestBody UserProfileSaveRequestDto dto);
}
