package com.muhammet.rabbitmq.producer;

import com.muhammet.rabbitmq.model.CreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserProducer {
    /**
     * Nasıl ki posta göndermek için belli koşullar gerekli.(posta pulu, göndereb, alıcı)
     * bunun gibi rabbit ile iletim içinde bir yapıya ihtiyacınız var
     */
    private final RabbitTemplate rabbitTemplate;

    public void createSendMessage(CreateUser createUser){
        rabbitTemplate.convertAndSend("exchange-direct-auth","key-auth",createUser);
    }
}
