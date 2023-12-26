package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "upgrade_achievment_upgrade")
public class Upgrade_Achievment_Upgrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "upgrade_achievment_upgrade_id") private int id;
    @Column(name = "upgrade_achievment_upgrade_upgrade_id") private int upgrade_id;
    @Column(name = "upgrade_achievment_upgrade_achievment_upgrade_id") private int achievment_upgrade_id;
    
    public Upgrade_Achievment_Upgrade(){}
    public int getId(){return id;}
    public int getUpgradeId(){return upgrade_id;}
    public int getAchievmentUpgradeId(){return achievment_upgrade_id;}
}
