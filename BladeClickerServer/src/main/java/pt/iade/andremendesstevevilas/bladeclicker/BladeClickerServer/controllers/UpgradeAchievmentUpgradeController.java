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
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.exceptions.NotFoundException;

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Upgrade_Achievment_Upgrade;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Response;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories.Upgrade_Achievment_Upgrade_Repository;


@RestController
@RequestMapping(path = "/api/upgradeachievmentupgrades")
public class UpgradeAchievmentUpgradeController {
    private Logger logger = (Logger) LoggerFactory.getLogger(UpgradeAchievmentUpgradeController.class);
    @Autowired
    private Upgrade_Achievment_Upgrade_Repository upgrade_achievment_upgrade_Repository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Upgrade_Achievment_Upgrade> getUpgrade_Achievment_Upgrades() {
        logger.info("Sending all...");
        return upgrade_achievment_upgrade_Repository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Upgrade_Achievment_Upgrade getUpgrade_Achievment_Upgrade(@PathVariable int id) {
        logger.info("Sending Upgrade_Achievment_Upgrade with id " + id);
        Optional<Upgrade_Achievment_Upgrade> _playyerupgrade = upgrade_achievment_upgrade_Repository.findById(id);
        if (_playyerupgrade.isEmpty())
             throw new NotFoundException("" + id, "Player", "id");
        else
            return _playyerupgrade.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Upgrade_Achievment_Upgrade addAchievmentUpgrade_Achievment_Upgrade(@RequestBody Upgrade_Achievment_Upgrade upg_achievment_upg) {
        Upgrade_Achievment_Upgrade savedPlayerUpgrade = upgrade_achievment_upgrade_Repository.save(upg_achievment_upg);
        logger.info("Saving Upgrade_Achievment_Upgrade with id " + savedPlayerUpgrade.getId());
        return savedPlayerUpgrade;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteAchievmentUpgrade_Achievment_Upgrade(@PathVariable int id) {
        logger.info("Deleting Upgrade_Achievment_Upgrade with id " + id);
        // No verification to see if it exists
        upgrade_achievment_upgrade_Repository.deleteById(id);
        return new Response("Deleted Upgrade_Achievment_Upgrade with id " + id, null);
    }

}
