package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import pt.iade.andresteve.clicker.games.GameInfo;

public class activity_stats extends AppCompatActivity {
    private ImageButton btnGoBack;
    private Button btnAchievments;
    private Button btnShop;
    private ImageButton btnConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        //get score
        GameInfo gameInfo = new GameInfo();
        Intent intent = getIntent();
        gameInfo.score = intent.getDoubleExtra("score", 0);

        btnGoBack = (ImageButton) findViewById(R.id.button_go_back_stats);
        btnAchievments =(Button) findViewById(R.id.button_achievements_stats);
        btnShop =  (Button) findViewById(R.id.button_shop_stats);
        btnConfig = (ImageButton) findViewById(R.id.button_settings_stats);


        //botão de configurações
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(activity_stats.this, Configurations_Activity.class);
                myIntent.putExtra("score", gameInfo.score); //Optional parameters
                activity_stats.this.startActivity(myIntent);
            }
        });

        //Botão para voltar atrás:
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open previous page with score
                Intent myIntent = new Intent(activity_stats.this, Game_Home_Activity.class);
                myIntent.putExtra("score", gameInfo.score); //Optional parameters
                activity_stats.this.startActivity(myIntent);
            }
        });

        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(activity_stats.this, activity_shop.class);
                myIntent.putExtra("score", gameInfo.score); //Optional parameters
                activity_stats.this.startActivity(myIntent);
            }
        });

        btnAchievments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(activity_stats.this, activity_achievements.class);
                myIntent.putExtra("score", gameInfo.score); //Optional parameters
                activity_stats.this.startActivity(myIntent);
            }
        });
    }
}