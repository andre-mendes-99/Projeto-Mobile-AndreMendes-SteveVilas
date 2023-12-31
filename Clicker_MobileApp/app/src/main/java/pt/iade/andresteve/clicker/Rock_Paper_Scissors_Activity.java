package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import java.util.Random;

import pt.iade.andresteve.clicker.games.GameInfo;
import pt.iade.andresteve.clicker.models.Player;


public class Rock_Paper_Scissors_Activity extends AppCompatActivity {


    //button
    private ImageButton rockButton;
    private ImageButton paperButton;
    private ImageButton scissorButton;

    public static final int Rock = 1;
    public static final int Paper = 2;
    public static final int Scissors = 3;

    Random rand = new Random();

    public void Game(int jogada,  Player player) {
        int jogadaCpu = rand.nextInt(4);

        AlertDialog.Builder alert = new AlertDialog.Builder(Rock_Paper_Scissors_Activity.this);
        int reward= (player.getUpgrade3Level())* 5; //Todo calcular reward

        switch (jogada) {
            case Rock:
                if (jogadaCpu == Rock) {
                    //empate
                    alert.setMessage("Your adversary played Rock!");
                    alert.setTitle("Draw!!");
                    alert.setCancelable(false);

                    alert.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
                        Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Rock_Paper_Scissors_Activity.class);
                        myIntent.putExtra("player", player);
                        Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    });

                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }
                else if (jogadaCpu == Paper) {
                    //perdeu
                    alert.setMessage("Your adversary played Paper!");
                    alert.setTitle("Lost!!");
                    alert.setCancelable(false);

                    alert.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {

                        Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                        myIntent.putExtra("player", player);
                        Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    });

                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }
                else if (jogadaCpu == Scissors) {
                    //vitoria
                    alert.setMessage("Your adversary played Scissors!");
                    alert.setTitle("Victory!!");
                    alert.setCancelable(false);

                    alert.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
                        double newscore = player.getScore()+reward;
                        player.setScore(newscore);
                        Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                        myIntent.putExtra("player", player);
                        Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    });

                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }
                break;

            case Paper:
                if(jogadaCpu == Rock){
                    //vitoria
                    alert.setMessage("Your adversary played Rock!");
                    alert.setTitle("Victory!!");
                    alert.setCancelable(false);

                    alert.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
                        double newscore = player.getScore()+reward;
                        player.setScore(newscore);
                        Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                        myIntent.putExtra("player", player);
                        Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    });

                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }
                else if (jogadaCpu == Paper) {
                    //empate
                    alert.setMessage("Yor adversary played Paper!");
                    alert.setTitle("Draw!!");
                    alert.setCancelable(false);

                    alert.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
                        Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Rock_Paper_Scissors_Activity.class);
                        myIntent.putExtra("player", player);
                        Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    });

                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();

                } else if (jogadaCpu == Scissors)
                {
                    //perdeu
                    alert.setMessage("Your adversary played Scissors!");
                    alert.setTitle("Lost!!");
                    alert.setCancelable(false);

                    alert.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {

                        Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                        myIntent.putExtra("player", player);
                        Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    });

                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }
                break;
            case Scissors:
                if(jogadaCpu == Rock)
                {
                    //perdeu
                    alert.setMessage("Your adversary played Rock!");
                    alert.setTitle("Lost!!");
                    alert.setCancelable(false);

                    alert.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {

                        Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                        myIntent.putExtra("player", player);
                        Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    });

                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }
                else if (jogadaCpu == Paper) {
                    //vitoria
                    alert.setMessage("Your adversary played Paper!");
                    alert.setTitle("Victory!!");
                    alert.setCancelable(false);

                    alert.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
                        double newscore = player.getScore()+reward;
                        player.setScore(newscore);
                        Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                        myIntent.putExtra("player", player);
                        Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    });

                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }
                else if (jogadaCpu  == Scissors) {
                    //empate
                    alert.setMessage("Your adversary played Scissors!");
                    alert.setTitle("Draw!");
                    alert.setCancelable(false);

                    alert.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
                        Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Rock_Paper_Scissors_Activity.class);
                        myIntent.putExtra("player", player);
                        Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                    });

                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }

                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        Intent intent = getIntent();
        Player player = (Player) intent.getSerializableExtra("player");

        //buttons
        rockButton= (ImageButton) findViewById(R.id.rock_button_rock_paper_scissors);
        paperButton = (ImageButton) findViewById(R.id.paper_button_rock_paper_scissors);
        scissorButton = (ImageButton) findViewById(R.id.scissors_button_rock_paper_scissors);


        //player carrega no botão de papel:
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Rock_Paper_Scissors_Activity.this);
                int reward= (player.getUpgrade3Level())* 5; //Todo calcular reward
               // Game(Paper, player);
                alert.setMessage("O seu adversário jogou Pedra!");
                alert.setTitle("Victória!!");
                alert.setCancelable(false);

                alert.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
                    double newscore = player.getScore()+reward;
                    player.setScore(newscore);
                    Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
                    myIntent.putExtra("player", player);
                    Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
                });

                AlertDialog alertDialog = alert.create();
                alertDialog.show();
            }
        });

        //player carrega no botão de pedra:
 rockButton.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
        // Game(Rock, player);
         AlertDialog.Builder alert = new AlertDialog.Builder(Rock_Paper_Scissors_Activity.this);
         int reward= (player.getUpgrade3Level())* 5;
         alert.setMessage("O seu adversário jogou Papel!");
         alert.setTitle("Derrota!!");
         alert.setCancelable(false);

         alert.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {

             Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Game_Home_Activity.class);
             myIntent.putExtra("player", player);
             Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
         });

         AlertDialog alertDialog = alert.create();
         alertDialog.show();

     }
 });
        //player carrega no botão de tesoura:
    scissorButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Game(Scissors, player);
            AlertDialog.Builder alert = new AlertDialog.Builder(Rock_Paper_Scissors_Activity.this);
            int reward= (player.getUpgrade3Level())* 5; //Todo calcular reward
            alert.setMessage("O seu adversário jogou Tesoura!");
            alert.setTitle("Empate!");
            alert.setCancelable(false);

            alert.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
                Intent myIntent = new Intent(Rock_Paper_Scissors_Activity.this, Rock_Paper_Scissors_Activity.class);
                myIntent.putExtra("player", player);
                Rock_Paper_Scissors_Activity.this.startActivity(myIntent);
            });

            AlertDialog alertDialog = alert.create();
            alertDialog.show();
        }
    });
    }
}