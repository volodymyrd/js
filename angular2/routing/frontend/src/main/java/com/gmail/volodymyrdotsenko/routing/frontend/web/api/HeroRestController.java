package com.gmail.volodymyrdotsenko.routing.frontend.web.api;

import com.gmail.volodymyrdotsenko.routing.backend.domain.Hero;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Volodymyr Dotsenko on 12/12/16.
 */
@RestController
@RequestMapping("/api/hero")
public class HeroRestController {

    @RequestMapping(value = "/heroes")
    public ResponseEntity<?> getHeroes() {
        return ResponseEntity.ok(Stream.of(new Hero(11l, "Mr. Nice")).collect(Collectors.toList()));
    }
}