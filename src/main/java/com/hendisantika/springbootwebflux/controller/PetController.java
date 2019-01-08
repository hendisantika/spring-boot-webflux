package com.hendisantika.springbootwebflux.controller;

import com.hendisantika.springbootwebflux.domain.Pet;
import com.hendisantika.springbootwebflux.repository.PetRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

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
@Controller
public class PetController {

    private final PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @GetMapping(value = "/pets", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    Flux<Pet> findPets() {
        return petRepository.findWithTailableCursorBy().delayElements(Duration.ofMillis(2500));

    }

    @GetMapping(value = "/pets/{id}")
    Mono<Pet> findById(@PathVariable String id) {
        return petRepository.findPetById(id);
    }

    @GetMapping("/")
    Mono<String> home() {
        return Mono.just("pets");
    }
}