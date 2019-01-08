package com.hendisantika.springbootwebflux.repository;

import com.hendisantika.springbootwebflux.domain.Pet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-09
 * Time: 05:46
 * To change this template use File | Settings | File Templates.
 */
public interface PetRepository extends ReactiveMongoRepository<Pet, String> {

    @Tailable
    Flux<Pet> findWithTailableCursorBy();

    Mono<Pet> findPetById(String id);

}