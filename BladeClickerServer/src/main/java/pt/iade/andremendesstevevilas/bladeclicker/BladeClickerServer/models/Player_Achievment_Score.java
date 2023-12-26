package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_achievment_score")
public class Player_Achievment_Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_achievment_score_id") private int id;
    @Column(name = "player_achievment_score_player_id")private int player_id;
    @Column(name = "player_achievment_score_achievment_score_id")private int achievment_id;

    public Player_Achievment_Score(){}
    public int getId(){return id;}
    public int getPlayerId(){return player_id;}
    public int getAchievmentId(){return achievment_id;}

}
