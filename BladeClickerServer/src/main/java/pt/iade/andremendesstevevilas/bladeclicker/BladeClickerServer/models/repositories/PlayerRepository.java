package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    //public Optional<Player> findByEmail(String email);
}
