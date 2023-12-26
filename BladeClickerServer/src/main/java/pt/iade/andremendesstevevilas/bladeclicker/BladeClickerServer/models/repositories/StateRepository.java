package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.repositories;

import org.springframework.data.repository.CrudRepository;

import pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models.State;

public interface StateRepository extends CrudRepository<State,Integer> {
    
}
