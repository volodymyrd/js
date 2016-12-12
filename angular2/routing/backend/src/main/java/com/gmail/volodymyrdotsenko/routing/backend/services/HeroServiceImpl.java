package com.gmail.volodymyrdotsenko.routing.backend.services;

import com.gmail.volodymyrdotsenko.routing.backend.domain.Hero;
import com.gmail.volodymyrdotsenko.routing.backend.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Volodymyr Dotsenko on 12/12/16.
 */
@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Optional<Hero> getHero(Long id) {
        return Optional.ofNullable(heroRepository.findOne(id));
    }

    @Override
    public List<Hero> getHeroes() {
        return heroRepository.findAll();
    }
}