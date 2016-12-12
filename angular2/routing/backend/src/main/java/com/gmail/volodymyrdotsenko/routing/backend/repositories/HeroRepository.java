package com.gmail.volodymyrdotsenko.routing.backend.repositories;

import com.gmail.volodymyrdotsenko.routing.backend.domain.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Volodymyr Dotsenko on 12/12/16.
 */
public interface HeroRepository extends JpaRepository<Hero, Long> {
}