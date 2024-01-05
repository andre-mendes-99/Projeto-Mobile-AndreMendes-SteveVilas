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

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Reward;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Response;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories.Reward_Repository;

@RestController
@RequestMapping(path = "/api/reward")
public class RewardController {
    private Logger logger = (Logger) LoggerFactory.getLogger(RewardController.class);
    @Autowired
    private Reward_Repository reward_Repository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Reward> getReward() {
        logger.info("Sending all...");
        return reward_Repository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reward getReward(@PathVariable int id) {
        logger.info("Sending reward with id " + id);
        Optional<Reward> _reward = reward_Repository.findById(id);
        if (_reward.isEmpty())
             throw new NotFoundException("" + id, "Player", "id");
        else
            return _reward.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reward addAchievmentReward(@RequestBody Reward reward) {
        Reward savedReward = reward_Repository.save(reward);
        logger.info("Saving reward with id " + savedReward.getId());
        return savedReward;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteAchievmentReward(@PathVariable int id) {
        logger.info("Deleting reward with id " + id);
        // No verification to see if it exists
        reward_Repository.deleteById(id);
        return new Response("Deleted reward with id " + id, null);
    }

}
