package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mini_game")
public class Mini_Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mini_game_id") private int id;

    public Mini_Game(){}
    public int getId(){return id;}
}
