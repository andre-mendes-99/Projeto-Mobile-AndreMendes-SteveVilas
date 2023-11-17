package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    public void Game(int jogada,  GameInfo gameInfo) {
        int jogadaCpu = rand.nextInt(4);
        int reward= 100; //Todo calcular reward
        switch (jogada) {
            case Rock:
                if (jogadaCpu == Rock) {
                    //empate
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Rock_Paper_Scissors_Activity.class);
                    myIntent.putExtra("score", gameInfo.score);
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);                }
                else if (jogadaCpu == Paper) {
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("score", gameInfo.score);
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    //perdeu
                }
                else if (jogadaCpu == Scissors) {
                    gameInfo.score+= reward;
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("score", gameInfo.score);
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    //venceu
                }
                break;
            case Paper:
                if(jogadaCpu == Rock){
                    //vitoria
                    gameInfo.score+= reward;
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("score", gameInfo.score);
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                }
                else if (jogadaCpu == Paper) {
                    //empate
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Rock_Paper_Scissors_Activity.class);
                    myIntent.putExtra("score", gameInfo.score);
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                } else if (jogadaCpu == Scissors)
                {
                    //perdeu
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("score", gameInfo.score);
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                }
                break;
            case Scissors:
                if(jogadaCpu == Rock)
                {
                    //perdeu
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("score", gameInfo.score);
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    // mas não ganha pontos
                }
                else if (jogadaCpu == Paper) {
                    //vitoria
                    gameInfo.score+= reward;
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("score", gameInfo.score);
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                }
                else if (jogadaCpu  == Scissors) {
                    //empate
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Rock_Paper_Scissors_Activity.class);
                    myIntent.putExtra("score", gameInfo.score);
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                }

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameInfo gameInfo = new GameInfo();
        setContentView(R.layout.activity_rock_paper_scissors);
        Intent intent = getIntent();
        gameInfo.score = intent.getDoubleExtra("score", 0);
        //buttons
        rockButton= (ImageButton) findViewById(R.id.rock_button_rock_paper_scissors);
        paperButton = (ImageButton) findViewById(R.id.paper_button_rock_paper_scissors);
        scissorButton = (ImageButton) findViewById(R.id.scissors_button_rock_paper_scissors);


        //player carrega no botão de papel:
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Game(Paper, gameInfo);
            }
        });

        //player carrega no botão de pedra:
 rockButton.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         Game(Rock, gameInfo);
     }
 });
        //player carrega no botão de tesoura:
    scissorButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Game(Scissors, gameInfo);
        }
    });
    }
}