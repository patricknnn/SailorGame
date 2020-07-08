package com.springboot.sailornumber.repository;

import com.springboot.sailornumber.model.Guess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuessRepository extends JpaRepository<Guess, Long> {
    List<Guess> findAllByGameId(Long gameId);
}
