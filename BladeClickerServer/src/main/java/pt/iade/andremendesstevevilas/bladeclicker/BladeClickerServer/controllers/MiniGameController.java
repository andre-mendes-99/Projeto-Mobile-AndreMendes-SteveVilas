package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.controllers;

import java.util.Optional;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.exceptions.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Mini_Game;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories.Mini_Game_Repository;

@RestController
@RequestMapping(path = "/api/minigames")
public class MiniGameController {
    private Logger logger = (Logger) LoggerFactory.getLogger(MiniGameController.class);
    @Autowired
    private Mini_Game_Repository mini_game_Repository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Mini_Game> getMiniGames() {
        logger.info("Sending all Mini-Games...");
        return mini_game_Repository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mini_Game getMiniGmae(@PathVariable int id) {
        logger.info("Sending sending mini-game with id " + id);
        Optional<Mini_Game> _minigame = mini_game_Repository.findById(id);
        if (_minigame.isEmpty())
            throw new NotFoundException("" + id, "Player", "id");
        else
            return _minigame.get();
    }


}
