package com.springboot.sailornumber.repository;

import com.springboot.sailornumber.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findGameById(Long id);
}
