package com.muhammet.rabbitmq.consumer;

import com.muhammet.mapper.IUserProfileMapper;
import com.muhammet.rabbitmq.model.CreateUser;
import com.muhammet.repository.entity.UserProfile;
import com.muhammet.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserConsumer {
    private final UserProfileService userProfileService;
    /**
     * Bir servis sürekli olarak belirlenen kuyrukları dinlemeli.
     */
    @RabbitListener(queues = "queue-auth-create-user")
    public void createUserConsumerListener(CreateUser createUser){
        System.out.println("Gelen Mesaj....: "+ createUser.toString());
        userProfileService.save(createUser);
    }
}
