package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_state")
public class Player_State {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "player_state_id") private int id;
    @Column(name = "player_state_player_id") private int player_id;
    @Column(name = "player_state_state_id") private int state_id;
    @Column(name = "player_state_date") private LocalDateTime date;

    public Player_State(){}
    public int getId(){return id;}
    public int getPlayerId(){return player_id;}
    public int getStateId(){return state_id;}
    public LocalDateTime getDate(){return date;}

}
