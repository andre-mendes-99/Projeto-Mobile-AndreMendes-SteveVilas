package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "achievment_upgrade")
public class Achievment_Upgrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievment_upgrade_id") private int id;
    @Column(name = "achievment_upgrade_title") private String title;
    @Column(name = "achievment_upgrade_description") private String description;

    public Achievment_Upgrade(){}
    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getDescription(){return description;}
}
