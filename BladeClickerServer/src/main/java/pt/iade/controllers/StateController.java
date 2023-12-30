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

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Response;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.State;
import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories.StateRepository;

@RestController
@RequestMapping(path = "/api/states")
public class StateController {
    private Logger logger = (Logger) LoggerFactory.getLogger(StateController.class);
    @Autowired
    private StateRepository stateRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<State> getStates() {
        logger.info("Sending all States...");
        return stateRepository.findAll();
    }

    @GetMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public State getState(@PathVariable int id) {
        logger.info("Sending state with id " + id);
        Optional<State> _state = stateRepository.findById(id);
        if (_state.isEmpty())
            // throw new NotFoundException("" + id, "State", "id");
            return null;
        else
            return _state.get();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public State addState(@RequestBody State state) {
        State savedState = stateRepository.save(state);
        logger.info("Saving state with id " + savedState.getId());
        return savedState;
    }

    @DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteState(@PathVariable int id) {
        logger.info("Deleting state with id " + id);
        // No verification to see if it exists
        stateRepository.deleteById(id);
        return new Response("Deleted state with id " + id, null);
    }
}
