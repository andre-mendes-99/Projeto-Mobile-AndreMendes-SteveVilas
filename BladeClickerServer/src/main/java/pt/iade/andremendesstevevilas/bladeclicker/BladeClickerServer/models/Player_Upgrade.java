package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_upgrade")
public class Player_Upgrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_upgrade_id") private int id;
    @Column(name = "player_upgrade_player_id") private int player_id;
    @Column(name = "player_upgrade_upgrade_id") private int upgrade_id;

    public Player_Upgrade(){}
    public int getId(){return id;}
    public int getPlayerId(){return player_id;}
    public int getUpgradeId(){return upgrade_id;}
}
