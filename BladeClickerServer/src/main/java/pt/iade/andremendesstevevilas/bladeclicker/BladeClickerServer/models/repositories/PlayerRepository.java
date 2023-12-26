package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    
}
