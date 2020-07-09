package com.springboot.sailornumber.controller;

import com.springboot.sailornumber.exception.ResourceNotFoundException;
import com.springboot.sailornumber.payload.request.GuessRequest;
import com.springboot.sailornumber.service.GameLogic;
import com.springboot.sailornumber.model.Guess;
import com.springboot.sailornumber.model.GuessResult;
import com.springboot.sailornumber.payload.response.GuessResponse;
import com.springboot.sailornumber.repository.GuessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/guess")
public class GuessController {
    private final GameLogic gameLogic = new GameLogic();
    @Autowired
    private GuessRepository guessRepository;

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
        Guess guess = new Guess(guessRequest.getGameId(), guessRequest.getGuess());
        Guess savedGuess = guessRepository.save(guess);
        GuessResult guessResult = gameLogic.guessResult(savedGuess);

        return new GuessResponse(savedGuess, guessResult);
    }

}
