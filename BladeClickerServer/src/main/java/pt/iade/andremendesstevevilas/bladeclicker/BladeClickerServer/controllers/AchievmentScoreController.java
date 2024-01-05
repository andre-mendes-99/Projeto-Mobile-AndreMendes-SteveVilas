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

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Achievment_Score;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Response;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories.Achievment_Score_Repository;

@RestController
@RequestMapping(path = "/api/achievmentscores")
public class AchievmentScoreController {
    private Logger logger = (Logger) LoggerFactory.getLogger(AchievmentScoreController.class);
    @Autowired
    private Achievment_Score_Repository achievment_Score_Repository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Achievment_Score> getAchievmentScores() {
        logger.info("Sending all Achievment Scores...");
        return achievment_Score_Repository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Achievment_Score getAchievment_Score(@PathVariable int id) {
        logger.info("Sending achievment score with id " + id);
        Optional<Achievment_Score> _achievmentscore = achievment_Score_Repository.findById(id);
        if (_achievmentscore.isEmpty())
             throw new NotFoundException("" + id, "Player", "id");
        else
            return _achievmentscore.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Achievment_Score addAchievmentScore(@RequestBody Achievment_Score achievment_Score) {
        Achievment_Score savedAchievmentScore = achievment_Score_Repository.save(achievment_Score);
        logger.info("Saving achievment score with id " + savedAchievmentScore.getId());
        return savedAchievmentScore;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteAchievmentScore(@PathVariable int id) {
        logger.info("Deleting player with id " + id);
        // No verification to see if it exists
        achievment_Score_Repository.deleteById(id);
        return new Response("Deleted achievment score with id " + id, null);
    }

}
