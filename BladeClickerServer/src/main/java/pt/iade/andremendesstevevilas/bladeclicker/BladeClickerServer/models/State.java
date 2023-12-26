package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="state")
public class State {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "state_id") private int id;
    @Column(name = "state_name") private String state_name;
    public State(){}
    public int getId(){return id;}
    public String getStateName(){return state_name;}
    
}
