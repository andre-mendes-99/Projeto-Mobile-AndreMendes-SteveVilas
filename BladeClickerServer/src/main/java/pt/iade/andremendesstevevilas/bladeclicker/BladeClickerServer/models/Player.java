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
    @Column(name = "player_id") private int Id;
    @Column(name = "player_playername") private String Playername;
    @Column(name = "player_email") private String Email;
    @Column(name = "player_password") private String Password;
    @Column(name = "player_score") private double Score;
    @Column(name = "player_taps") private int Taps;

    public Player(){}
    public int getId() { return Id; }
    public String getPlayerName(){return Playername;}
    public String getEmail(){return Email;}
    public String getPassword(){return Password;}
    public double getScore(){return Score;}
    public int getTaps(){return Taps;}
}
