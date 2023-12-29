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

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Player_Achievment_Score;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Response;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories.Player_Achievment_Score_Repository;

@RestController
@RequestMapping(path = "/api/playerachievmentscores")
public class PlayerAchievmentScoreController {
     private Logger logger = (Logger) LoggerFactory.getLogger(PlayerAchievmentScoreController.class);
    @Autowired
    private Player_Achievment_Score_Repository player_achievment_score_Repository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Player_Achievment_Score> getPlayer_Achievment_Scores() {
        logger.info("Sending all...");
        return player_achievment_score_Repository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player_Achievment_Score getPlayer_Achievment_Score(@PathVariable int id) {
        logger.info("Sending Player_Achievment_Score with id " + id);
        Optional<Player_Achievment_Score> _playerachievmentscore = player_achievment_score_Repository.findById(id);
        if (_playerachievmentscore.isEmpty())
            // throw new NotFoundException("" + id, "Player", "id");
            return null;
        else
            return _playerachievmentscore.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player_Achievment_Score addAchievmentPlayer_Achievment_Score(@RequestBody Player_Achievment_Score player_ach_score) {
        Player_Achievment_Score savedPlayerAchievmentScore = player_achievment_score_Repository.save(player_ach_score);
        logger.info("Saving player_achievment_score with id " + savedPlayerAchievmentScore.getId());
        return savedPlayerAchievmentScore;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteAchievmentPlayer_Achievment_Score(@PathVariable int id) {
        logger.info("Deleting Player_Achievment_Score with id " + id);
        // No verification to see if it exists
        player_achievment_score_Repository.deleteById(id);
        return new Response("Deleted Player_Achievment_Score with id " + id, null);
    }
}
