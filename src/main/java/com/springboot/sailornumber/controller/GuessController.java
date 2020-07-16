package com.springboot.sailornumber.controller;

import com.springboot.sailornumber.exception.ResourceNotFoundException;
import com.springboot.sailornumber.model.Game;
import com.springboot.sailornumber.payload.request.GuessRequest;
import com.springboot.sailornumber.repository.GameRepository;
import com.springboot.sailornumber.service.GameLogic;
import com.springboot.sailornumber.model.Guess;
import com.springboot.sailornumber.model.GuessResult;
import com.springboot.sailornumber.payload.response.GuessResponse;
import com.springboot.sailornumber.repository.GuessRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/guess")
public class GuessController {
    Logger logger = LoggerFactory.getLogger(GuessController.class);
    private final GameLogic gameLogic = new GameLogic();
    @Autowired
    private GuessRepository guessRepository;
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/all")
    public List<Guess> getAllGuesses() {
        return guessRepository.findAll();
    }

    @GetMapping("/gameId/{id}")
    public List<Guess> getAllGuessesByGameId(@PathVariable(value = "id") Long gameId) {
        return guessRepository.findAllByGameId(gameId);
    }

    @GetMapping("/guessId/{id}")
    public ResponseEntity<Guess> getGuessById(@PathVariable(value = "id") Long guessId) throws ResourceNotFoundException {
        Guess guess = guessRepository.findById(guessId).orElseThrow(
                () -> new ResourceNotFoundException("Guess not found for id : " + guessId)
        );

        return ResponseEntity.ok().body(guess);
    }

    @PostMapping("/submit")
    public GuessResponse submitGuess(@Valid @RequestBody GuessRequest guessRequest) throws ResourceNotFoundException {
        Guess savedGuess = guessRepository.save(new Guess(guessRequest.getGameId(), guessRequest.getGuess()));
        Game game = gameRepository.findById(savedGuess.getGameId())
                .orElseThrow(() -> new ResourceNotFoundException("Game not found for  id : " + savedGuess.getGameId()));
        GuessResult guessResult = gameLogic.getGuessResult(game.getNrToGuess(), savedGuess.getGuess());

        return new GuessResponse(savedGuess, guessResult);
    }

}
