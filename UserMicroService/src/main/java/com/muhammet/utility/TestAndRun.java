package com.muhammet.utility;

import com.muhammet.manager.IElasticServiceManager;
import com.muhammet.mapper.IUserProfileMapper;
import com.muhammet.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestAndRun {

    private final UserProfileService userProfileService;
    private final IElasticServiceManager elasticServiceManager;
    /**
     * Bu sınıftan bir nesne yaratılırken çalıştırmak istediğim kodları
     * yazacağım. Ancak, bu sınıfın bir constructor gibi hareket etmesi için
     * @PostContruct anotosyonu ile işaretlenmesi gereklidir.
     */
    @PostConstruct
    public void init(){
        new Thread(()->{
           // run();
        }).start();
    }

    /**
     * Buraya çalıştırmak istediğim kodları yazacağım
     */
    public void run(){
        try{
            /**
             * Tüm kullanıcı datalarını çekiyoruz ve tek tek dolaşıuyoruz.
             * feignClient ile bu kullanıcı bilgilerini elasticseervice e gönderiyoruz. Burada
             * göndermek istediğimiz bilgi Dto şeklinde olduğu için USerProfile dan Dto ya Mapper ile
             * dönüşüm yapmamız gerekiyor.
             */
            userProfileService.findAll().forEach(x->{
                elasticServiceManager.save(IUserProfileMapper.INSTANCE.fromUserProfile(x));
            });
            System.out.println("İşlem sona erdi.");
        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }
}
