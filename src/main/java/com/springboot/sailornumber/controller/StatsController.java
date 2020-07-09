package com.springboot.sailornumber.controller;

import com.springboot.sailornumber.exception.ResourceNotFoundException;
import com.springboot.sailornumber.model.Game;
import com.springboot.sailornumber.payload.response.GameStatsResponse;
import com.springboot.sailornumber.model.Guess;
import com.springboot.sailornumber.repository.GameRepository;
import com.springboot.sailornumber.repository.GuessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/stats")
public class StatsController {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GuessRepository guessRepository;

    @GetMapping("/gameId/{id}")
    public GameStatsResponse getGameStats(@PathVariable(value = "id") Long gameId) throws ResourceNotFoundException {
        Game game = gameRepository.findById(gameId).orElseThrow(
                () -> new ResourceNotFoundException("Game not found for this id : " + gameId)
        );
        List<Guess> guesses = guessRepository.findAllByGameId(gameId);
        return new GameStatsResponse(game, guesses);
    }
}
