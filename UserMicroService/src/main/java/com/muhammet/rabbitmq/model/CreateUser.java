package com.muhammet.rabbitmq.model;

import lombok.*;

import java.io.Serializable;

/**
 * DİKKAT!!!!!!!
 * burada gönderilecek veriler işlenmelidir. Ancak bu bilgilerin iletilebilmesiş için;
 * 1- serileştirme işleminin yapılması gereklidir.
 * 2- gönderilen sınıfı karşılayacak olan sınıf için tanımlamalar paket adına varana kadar aynı
 * olmalıdır.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class CreateUser implements Serializable {
    Long authid;
    String username;
    String email;
}
