package pt.iade.andresteve.clicker.models;

public class Player {
    private int Id;
    private String Playername;
    private String Email;
    private String Password;
    private double Score;
    private int Taps;

    public Player(){}

    public Player(String playername, String email, String password, double score, int taps) {
        Playername = playername;
        Email = email;
        Password = password;
        Score = score;
        Taps = taps;
    }

    public int getId() { return Id; }
    public String getPlayerName(){return Playername;}
    public String getEmail(){return Email;}
    public String getPassword(){return Password;}
    public double getScore(){return Score;}
    public int getTaps(){return Taps;}

    public void setId(int id) {this.Id = id; }
    public void setPlayerName(String pname){this.Playername=pname;}
    public void setEmail(String pmail){this.Email=pmail;}
    public void setPassword(String ppass){ this.Password=ppass;}
    public void setScore(double pscor){this.Score=pscor;}
    public void setTaps(int ptaps){this.Taps=ptaps;}

}
