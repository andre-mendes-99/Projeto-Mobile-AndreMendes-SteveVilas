package pt.iade.andresteve.clicker.games;


import java.util.Random;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import pt.iade.andresteve.clicker.*;

public class GamesRepository {
    /*
    public static final int Rock = 1;
    public static final int Paper = 2;
    public static final int Scissors = 3;
    Random rand = new Random();

    public void Game(int jogada, int score) {
        int jogadaCpu = rand.nextInt(4);
        int reward= 100; //Todo calcular reward
        switch (jogada) {
            case Rock:
                if (jogadaCpu == Rock) {
                    //empate
                    startActivity(new Intent(Rock_Paper_Scissors_Activity.this, Rock_Paper_Scissors_Activity.class));
                }
                else if (jogadaCpu == Paper) {
                    startActivity(new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class));// mas não ganha pontos
                    //perdeu
                }
                else if (jogadaCpu == Scissors) {
                    score+= reward;
                    startActivity(new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class)); // mas ganha pontos
                    //venceu
                }
                break;
            case Paper:
                if(jogadaCpu == Rock){
                    //vitoria
                    score+= reward;
                    startActivity(new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class)); // mas ganha pontos
                }
                else if (jogadaCpu == Paper) {
                    //empate
                    startActivity(new Intent(Rock_Paper_Scissors_Activity.this, Rock_Paper_Scissors_Activity.class));
                } else if (jogadaCpu == Scissors)
                {
                    //perdeu
                    startActivity(new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class));// mas não ganha pontos
                }
                break;
            case Scissors:
                if(jogadaCpu == Rock)
                {
                    //perdeu
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("key", value); //Optional parameters
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    // mas não ganha pontos
                }
                else if (jogadaCpu == Paper) {
                    //vitoria
                    score+= reward;
                    startActivity(new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class)); // mas ganha pontos

                }
                else if (jogadaCpu  == Scissors) {
                    //empate
                    startActivity(new Intent(Rock_Paper_Scissors_Activity.this, Rock_Paper_Scissors_Activity.class));
                }

                break;
        }
    }
*/
}
