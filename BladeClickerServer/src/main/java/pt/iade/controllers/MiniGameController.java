package pt.iade.controllers;

import java.util.Optional;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Mini_Game;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Response;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories.Mini_Game_Repository;

@RestController
@RequestMapping(path = "/api/minigames")
public class MiniGameController {
    private Logger logger = (Logger) LoggerFactory.getLogger(PlayerController.class);
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
            // throw new NotFoundException("" + id, "Player", "id");
            return null;
        else
            return _minigame.get();
    }


}
