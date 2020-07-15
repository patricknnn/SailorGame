package com.springboot.sailornumber.controller;

import com.springboot.sailornumber.exception.ResourceNotFoundException;
import com.springboot.sailornumber.model.Game;
import com.springboot.sailornumber.payload.request.NewGameRequest;
import com.springboot.sailornumber.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/all")
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/gameId/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable(value = "id") String gameId) throws ResourceNotFoundException {
        Game game = gameRepository.findById(Long.parseLong(gameId)).orElseThrow(
                () -> new ResourceNotFoundException("Game not found for this id : " + gameId)
        );
        return ResponseEntity.ok().body(game);
    }

    @PostMapping("/new")
    public Long newGame(@Valid @RequestBody NewGameRequest newGameRequest) {
        Game game = new Game(newGameRequest.getName(), newGameRequest.getDateOfBirth(), newGameRequest.getNrOfDigits());
        return gameRepository.save(game).getId();
    }
}
