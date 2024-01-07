package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="achievment_score")
public class Achievment_Score {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "achievment_score_id") private int id;
    @Column(name = "achievment_score_title") private String title;
    @Column(name = "achievment_score_description") private String description;
     
    public Achievment_Score(){}
    public int getId(){return id;}
    public String getTitle(){return title;}
    public String getDescription(){return description;}

}

