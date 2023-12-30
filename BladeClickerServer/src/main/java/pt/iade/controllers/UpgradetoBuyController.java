package pt.iade.controllers;

import java.util.Optional;
import java.util.logging.Logger;

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

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Upgrade_to_Buy;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Response;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories.Upgrade_to_Buy_Repository;

@RestController
@RequestMapping(path = "/api/upgradestobuy")
public class UpgradetoBuyController {
    private Logger logger = (Logger) LoggerFactory.getLogger(UpgradetoBuyController.class);
    @Autowired
    private Upgrade_to_Buy_Repository upgrade_Repository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Upgrade_to_Buy> getUpgrades() {
        logger.info("Sending all...");
        return upgrade_Repository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Upgrade_to_Buy getUpgrade(@PathVariable int id) {
        logger.info("Sending upgrade with id " + id);
        Optional<Upgrade_to_Buy> _upgrade = upgrade_Repository.findById(id);
        if (_upgrade.isEmpty())
            // throw new NotFoundException("" + id, "Player", "id");
            return null;
        else
            return _upgrade.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Upgrade_to_Buy addUpgrade(@RequestBody Upgrade_to_Buy upg) {
        Upgrade_to_Buy savedUpgrade = upgrade_Repository.save(upg);
        logger.info("Saving upgrade with id " + savedUpgrade.getId());
        return savedUpgrade;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUpgrade(@PathVariable int id) {
        logger.info("Deleting Upgrade with id " + id);
        // No verification to see if it exists
        upgrade_Repository.deleteById(id);
        return new Response("Deleted Upgrade with id " + id, null);
    }

}
