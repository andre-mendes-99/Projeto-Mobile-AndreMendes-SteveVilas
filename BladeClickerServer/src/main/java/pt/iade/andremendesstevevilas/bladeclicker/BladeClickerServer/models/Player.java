package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player")
public class Player {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "player_id") private int id;
    @Column(name = "player_playername") private String playername;
    @Column(name = "player_email") private String email;
    @Column(name = "player_password") private String password;
    @Column(name = "player_score") private double score;

    public Player(){}
    public int getId() { return id; }
    public String getPlayerName(){return playername;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public double getScore(){return score;}
}
