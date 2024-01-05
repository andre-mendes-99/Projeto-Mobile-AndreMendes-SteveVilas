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

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Player_Upgrade;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Response;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories.Player_Upgrade_Repository;

@RestController
@RequestMapping(path = "/api/playerupgrades")
public class PlayerUpgradeController {
     private Logger logger = (Logger) LoggerFactory.getLogger(PlayerUpgradeController.class);
    @Autowired
    private Player_Upgrade_Repository player_upgrade_Repository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Player_Upgrade> getPlayer_Upgrades() {
        logger.info("Sending all...");
        return player_upgrade_Repository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player_Upgrade getPlayer_Upgrade(@PathVariable int id) {
        logger.info("Sending Player_Upgrade with id " + id);
        Optional<Player_Upgrade> _playyerupgrade = player_upgrade_Repository.findById(id);
        if (_playyerupgrade.isEmpty())
            throw new NotFoundException("" + id, "Player", "id");
        else
            return _playyerupgrade.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player_Upgrade addAchievmentPlayer_Upgrade(@RequestBody Player_Upgrade player_upg) {
        Player_Upgrade savedPlayerUpgrade = player_upgrade_Repository.save(player_upg);
        logger.info("Saving Player_Upgrade with id " + savedPlayerUpgrade.getId());
        return savedPlayerUpgrade;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteAchievmentPlayer_Upgrade(@PathVariable int id) {
        logger.info("Deleting Player_Upgrade with id " + id);
        // No verification to see if it exists
        player_upgrade_Repository.deleteById(id);
        return new Response("Deleted Player_Upgrade with id " + id, null);
    }
}
