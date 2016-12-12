package com.gmail.volodymyrdotsenko.routing.frontend.web.api;

import com.gmail.volodymyrdotsenko.routing.backend.domain.Hero;
import com.gmail.volodymyrdotsenko.routing.backend.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by Volodymyr Dotsenko on 12/12/16.
 */
@RestController
@RequestMapping("/api/hero")
public class HeroRestController {

    @Autowired
    private HeroService heroService;

    @RequestMapping(value = "/all")
    public ResponseEntity<?> getHeroes() {
        return ResponseEntity.ok(heroService.getHeroes());
    }

    @RequestMapping(value = "/one/{id}")
    public ResponseEntity<?> getHeroes(@PathVariable("id") Long id) {
        Optional<Hero> hero = heroService.getHero(id);
        return ResponseEntity.ok(hero.isPresent() ? hero.get() : "");
    }
}