package com.hendisantika.springbootwebflux.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-09
 * Time: 05:45
 * To change this template use File | Settings | File Templates.
 */
@Document(collection = "pets")
@Data
public class Pet {
    @Id
    private String id;
    private String name;
    private String age;
    private String email;
    private String address1;
    private String city;
    private String state;
    private String thumbnailImage;
}