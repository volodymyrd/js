package com.gmail.volodymyrdotsenko.routing.backend.services;

import com.gmail.volodymyrdotsenko.routing.backend.domain.Hero;

import java.util.List;
import java.util.Optional;

/**
 * Created by Volodymyr Dotsenko on 12/12/16.
 */
public interface HeroService {
    Optional<Hero> getHero(Long id);

    List<Hero> getHeroes();
}