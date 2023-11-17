package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import java.util.Random;

import pt.iade.andresteve.clicker.games.GameInfo;


public class Rock_Paper_Scissors_Activity extends AppCompatActivity {


    //button
    private ImageButton rockButton;
    private ImageButton paperButton;
    private ImageButton scissorButton;

    public static final int Rock = 1;
    public static final int Paper = 2;
    public static final int Scissors = 3;
    Random rand = new Random();

    public void Game(int jogada, int score) {
        GameInfo gameInfo = new GameInfo();
        int jogadaCpu = rand.nextInt(4);
        int reward= 100; //Todo calcular reward
        switch (jogada) {
            case Rock:
                if (jogadaCpu == Rock) {
                    //empate
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Rock_Paper_Scissors_Activity.class);
                    myIntent.putExtra("key", gameInfo.score); //Optional parameters
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);                }
                else if (jogadaCpu == Paper) {
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("key", gameInfo.score); //Optional parameters
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);                    //perdeu
                }
                else if (jogadaCpu == Scissors) {
                    score+= reward;
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("key", gameInfo.score); //Optional parameters
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    //venceu
                }
                break;
            case Paper:
                if(jogadaCpu == Rock){
                    //vitoria
                    score+= reward;
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("key", gameInfo.score); //Optional parameters
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                }
                else if (jogadaCpu == Paper) {
                    //empate
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Rock_Paper_Scissors_Activity.class);
                    myIntent.putExtra("key", gameInfo.score); //Optional parameters
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                } else if (jogadaCpu == Scissors)
                {
                    //perdeu
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("key", gameInfo.score); //Optional parameters
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);                }
                break;
            case Scissors:
                if(jogadaCpu == Rock)
                {
                    //perdeu
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("key", gameInfo.score); //Optional parameters
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    // mas não ganha pontos
                }
                else if (jogadaCpu == Paper) {
                    //vitoria
                    score+= reward;
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("key", gameInfo.score); //Optional parameters
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                }
                else if (jogadaCpu  == Scissors) {
                    //empate
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Rock_Paper_Scissors_Activity.class);
                    myIntent.putExtra("key", gameInfo.score); //Optional parameters
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);                }

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameInfo gameInfo = new GameInfo();
        setContentView(R.layout.activity_rock_paper_scissors);
        Intent intent = getIntent();
        gameInfo.score = intent.getDoubleExtra("key", 0);
    }
}