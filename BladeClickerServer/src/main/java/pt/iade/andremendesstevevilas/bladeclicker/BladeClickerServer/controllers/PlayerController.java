package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.controllers;

import java.util.Optional;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Player;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Response;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.exceptions.AlreadyExistsException;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.exceptions.NotFoundException;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories.PlayerRepository;

@RestController
@RequestMapping(path = "/api/players")
public class PlayerController {
    private Logger logger = (Logger) LoggerFactory.getLogger(PlayerController.class);
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Player> getPlayers() {
        logger.info("Sending all Players...");
        return playerRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player getPlayerbyId(@PathVariable int id) {
        logger.info("Sending player with id " + id);
        Optional<Player> _player = playerRepository.findById(id);
        if (_player.isEmpty())
            throw new NotFoundException("" + id, "Player", "id");
        else
            return _player.get();
    }

    // @GetMapping(path = "{email:[^0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    // public Player getPlayerbyEmail(@PathVariable String email) {
    //     logger.info("Sending player with id " + email);
    //     Optional<Player> _player = playerRepository.findByEmail(email);
    //     if (_player.isEmpty())
    //         throw new NotFoundException("" + email, "Player", "email");
    //     else
    //         return _player.get();
    // }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player addPLayer(@RequestBody Player addplayer) {
        Iterable<Player> listPlayers = playerRepository.findAll();
        for (Player player : listPlayers) {
            if(player.getEmail() == addplayer.getEmail())
            {
                throw new AlreadyExistsException("" + player.getEmail(), "Player", "email");
            }
        }
        Player savedPlayer = playerRepository.save(addplayer);
        logger.info("Saving player with id " + savedPlayer.getId());
        return savedPlayer;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deletePlayer(@PathVariable int id) {
        logger.info("Deleting player with id " + id);
        // No verification to see if it exists
        playerRepository.deleteById(id);
        return new Response("Deleted player with id " + id, null);
    }
}
