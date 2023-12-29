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

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Achievment_Upgrade;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Response;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories.Achievment_Upgrade_Repository;

@RestController
@RequestMapping(path = "/api/achievmentupgrades")
public class AchievmentUpgradeController {
    private Logger logger = (Logger) LoggerFactory.getLogger(AchievmentUpgradeController.class);
    @Autowired
    private Achievment_Upgrade_Repository achievment_Upgrade_Repository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Achievment_Upgrade> getAchievmentUpgrades() {
        logger.info("Sending all Achievment Upgrades...");
        return achievment_Upgrade_Repository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Achievment_Upgrade getAchievment_Upgrade(@PathVariable int id) {
        logger.info("Sending achievment upgrade with id " + id);
        Optional<Achievment_Upgrade> _achievmentupgrade = achievment_Upgrade_Repository.findById(id);
        if (_achievmentupgrade.isEmpty())
            // throw new NotFoundException("" + id, "Player", "id");
            return null;
        else
            return _achievmentupgrade.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Achievment_Upgrade addAchievmentUpgrade(@RequestBody Achievment_Upgrade ach_upgrade) {
        Achievment_Upgrade savedAchievmentScore = achievment_Upgrade_Repository.save(ach_upgrade);
        logger.info("Saving achievment upgrade with id " + savedAchievmentScore.getId());
        return savedAchievmentScore;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteAchievmentUpgrade(@PathVariable int id) {
        logger.info("Deleting player with id " + id);
        // No verification to see if it exists
        achievment_Upgrade_Repository.deleteById(id);
        return new Response("Deleted achievment upgrade with id " + id, null);
    }

}
