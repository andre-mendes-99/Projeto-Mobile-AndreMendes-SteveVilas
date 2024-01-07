package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.TextView;

import pt.iade.andresteve.clicker.games.GameInfo;
import pt.iade.andresteve.clicker.models.Player;

public class Game_Home_Activity extends AppCompatActivity {
    private ImageButton btnClickerTemp;
    private Button btnShop;
    private Button btnAchievments;
    private Button btnStats;
    private ImageButton btnConfig;
    private ImageButton btnMiniGame;
    private TextView scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_home);
        Intent intent = getIntent();
        GameInfo gamepoints = new GameInfo();

        Player player = (Player) intent.getSerializableExtra("player");
        gamepoints.score = player.getScore();
        //Score View:
        scoreView = (TextView)findViewById(R.id.score_game_home_textview);
        scoreView.setText(Double.toString(gamepoints.score));

        //Buttons:
        btnMiniGame= (ImageButton) findViewById(R.id.btn_minigame_game_home);
        btnConfig = (ImageButton) findViewById(R.id.button_settings_game_home);
        btnClickerTemp = (ImageButton) findViewById(R.id.button_clicker_home_page);
        btnShop = (Button)findViewById(R.id.button_shop_game_home);
        btnAchievments = (Button)findViewById(R.id.button_achievements_home);
        btnStats = (Button)findViewById(R.id.button_stats_game_home);

        //botão do clicker:
        btnClickerTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //definir pontuação através de nivel de melhoria

                player.setTaps(player.getTaps() * (player.getUpgrade2Level()/2)+1);
                gamepoints.score += player.getScore() * (player.getTaps()/2) * (player.getUpgrade1Level()/2)+1;
                player.setScore(gamepoints.score);


                scoreView.setText(Double.toString(player.getScore()));
            }

        });

        //botão de configurações
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                Intent myIntent = new Intent(Game_Home_Activity.this, Configurations_Activity.class);
                myIntent.putExtra("player", player); //Optional parameters
                Game_Home_Activity.this.startActivity(myIntent);
            }
        });

        //botão minigame:
        btnMiniGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Game_Home_Activity.this, Rock_Paper_Scissors_Activity.class);
                myIntent.putExtra("player", player); //Optional parameters
                Game_Home_Activity.this.startActivity(myIntent);
            }
        });

        //botão para loja:
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Game_Home_Activity.this, activity_shop.class);
                myIntent.putExtra("player", player); //Optional parameters
                Game_Home_Activity.this.startActivity(myIntent);
            }
        });

        //botão para achievments:
        btnAchievments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Game_Home_Activity.this, activity_achievements.class);
                myIntent.putExtra("player", player); //Optional parameters
                Game_Home_Activity.this.startActivity(myIntent);

            }
        });

        //botão para Stats:
        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Game_Home_Activity.this, activity_stats.class);
                myIntent.putExtra("player", player); //Optional parameters
                Game_Home_Activity.this.startActivity(myIntent);            }
        });
    }
}