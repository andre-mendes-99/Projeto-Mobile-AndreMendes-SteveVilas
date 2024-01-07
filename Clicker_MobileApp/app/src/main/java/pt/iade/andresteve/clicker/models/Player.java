package pt.iade.andresteve.clicker.models;

import java.io.Serializable;

public class Player implements Serializable {
    private int Id;
    private String Playername;
    private String Email;
    private String Password;
    private double Score;
    private int Taps;
    private int upgrade1Level;
    private int upgrade1Cost;

    private int upgrade2Level;
    private int upgrade2Cost;

    private int upgrade3Level;
    private int upgrade3Cost;

    public Player(){}

    public Player(String playername, String email, String password, double score, int taps, int upgrade1level,int upgrade1cost ,int upgrade2level,int upgrade2cost, int upgrade3level, int upgrade3cost) {
        Playername = playername;
        Email = email;
        Password = password;
        Score = score;
        Taps = taps;
        upgrade1Level = upgrade1level;
        upgrade2Level = upgrade2level;
        upgrade3Level = upgrade3level;
        upgrade1Cost = upgrade1cost;
        upgrade2Cost = upgrade2cost;
        upgrade3Cost = upgrade3cost;
    }

    public int getId() { return Id; }
    public String getPlayerName(){return Playername;}
    public String getEmail(){return Email;}
    public String getPassword(){return Password;}
    public double getScore(){return Score;}
    public int getTaps(){return Taps;}
    public int getUpgrade1Level(){return upgrade1Level;}
    public int getUpgrade1Cost(){return upgrade1Cost;}
    public int getUpgrade2Level(){return upgrade2Level;}
    public int getUpgrade2Cost(){return upgrade2Cost;}
    public int getUpgrade3Level(){return upgrade3Level;}
    public int getUpgrade3Cost(){return upgrade3Cost;}


    public void setId(int id) {this.Id = id; }
    public void setPlayerName(String pname){this.Playername=pname;}
    public void setEmail(String pmail){this.Email=pmail;}
    public void setPassword(String ppass){ this.Password=ppass;}
    public void setScore(double pscor){this.Score=pscor;}
    public void setTaps(int ptaps){this.Taps=ptaps;}
    public void setUpgrade1Level(int level){this.upgrade1Level=level;}
    public void setUpgrade2Level(int level){this.upgrade2Level=level;}
    public void setUpgrade3Level(int level){this.upgrade3Level=level;}
    public void setUpgrade1Cost(int cost){this.upgrade1Cost=cost;}
    public void setUpgrade2Cost(int cost){this.upgrade2Cost=cost;}
    public void setUpgrade3Cost(int cost){this.upgrade3Cost=cost;}

}
