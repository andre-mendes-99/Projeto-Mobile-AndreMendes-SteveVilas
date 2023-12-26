package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "upgrade_to_buy")
public class Upgrade_to_Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "upgrade_id") private int id;
    @Column(name = "upgrade_title") private String title;
    @Column(name = "upgrade_description") private String description;
    @Column(name = "upgrade_level") private int level;

    public Upgrade_to_Buy(){}
    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public int getLevel(){return level;}
    
}
