package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.TextView;

public class Game_Home_Activity extends AppCompatActivity {
    private ImageButton btnClickerTemp;
    private Button btnShop;
    private Button btnAchievments;
    private Button btnStats;
    private ImageButton btnConfig;
    private ImageButton btnMiniGame;
    private TextView scoreView;
    private int score = 0; //temporário deopois começa com o valor da base de dados
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_home);

        //Score View:
        scoreView = (TextView)findViewById(R.id.score_game_home_textview);
        scoreView.setText(Integer.toString(score));

        //Buttons:
        btnMiniGame= (ImageButton) findViewById(R.id.btn_minigame_game_home);
        btnConfig = (ImageButton) findViewById(R.id.button_settings_game_home);
        btnClickerTemp = (ImageButton) findViewById(R.id.button_clicker_home_page);
        btnShop = (Button)findViewById(R.id.button_shop_game_home);
        btnAchievments = (Button)findViewById(R.id.button_achievements_game_home);
        btnStats = (Button)findViewById(R.id.button_stats_game_home);

        //botão do clicker:
        btnClickerTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             score+=1;
             scoreView.setText(Integer.toString(score));
            }

        });

        //botão de configurações:
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override 
            public void onClick(View view) {
                startActivity(new Intent(Game_Home_Activity.this, Configurations_Activity.class));
            }
        });

        //botão minigame:
        btnMiniGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Game_Home_Activity.this, Rock_Paper_Scissors_Activity.class));
            }
        });

        //botão para loja:
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Game_Home_Activity.this, activity_shop.class));
            }
        });

        //botão para achievments:
        btnAchievments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Game_Home_Activity.this, activity_achievements.class));

            }
        });

        //botão para Stats:
        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Game_Home_Activity.this, activity_stats.class));
            }
        });
    }
}