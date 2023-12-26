package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reward")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reward_id") private int id;
    @Column(name = "reward_points") private double points;
    @Column(name = "reward_mini_game_id") private int mini_game_id;
    @Column(name = "reward_upgrade_id") private int upgrade_id;

    public Reward(){}
    public int getId(){return id;}
    public double getPoints(){return points;}
    public int getMinigameId(){return mini_game_id;}
    public int getUpgradeId(){return upgrade_id;}
}
