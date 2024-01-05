package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.controllers;

import java.util.Optional;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.exceptions.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Player_State;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Response;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories.Player_StateRepository;

@RestController
@RequestMapping(path = "/api/playerstates")
public class PlayerStateController {
    private Logger logger = (Logger) LoggerFactory.getLogger(PlayerStateController.class);
    @Autowired
    private Player_StateRepository playerstateRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Player_State> getStates() {
        logger.info("Sending all player_states...");
        return playerstateRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player_State getState(@PathVariable int id) {
        logger.info("Sending player_state with id " + id);
        Optional<Player_State> _playerstate = playerstateRepository.findById(id);
        if (_playerstate.isEmpty())
             throw new NotFoundException("" + id, "State", "id");
        else
            return _playerstate.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player_State addState(@RequestBody Player_State player_state) {
        Player_State savedPlayerState = playerstateRepository.save(player_state);
        logger.info("Saving player_state with id " + savedPlayerState.getId());
        return savedPlayerState;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteState(@PathVariable int id) {
        logger.info("Deleting player_state with id " + id);
        // No verification to see if it exists
        playerstateRepository.deleteById(id);
        return new Response("Deleted player_state with id " + id, null);
    }
}
