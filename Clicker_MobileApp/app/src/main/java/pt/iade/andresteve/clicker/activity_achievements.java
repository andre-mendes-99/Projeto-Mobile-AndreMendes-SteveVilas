package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import pt.iade.andresteve.clicker.games.GameInfo;

public class activity_achievements extends AppCompatActivity {
    private ImageButton btnGoBack;
    private ImageButton btnConfig;
    private Button btnShop;
    private Button btnStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        //get score
        GameInfo gameInfo = new GameInfo();
        Intent intent = getIntent();
        gameInfo.score = intent.getDoubleExtra("score", 0);

        btnGoBack = (ImageButton) findViewById(R.id.button_go_back_achievements_button);
        btnStats = (Button) findViewById(R.id.button_stats_achievements);
        btnShop =(Button) findViewById(R.id.button_shop_achievements);
        btnConfig = (ImageButton) findViewById(R.id.button_settings_achievements);

        //botão de configurações
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(activity_achievements.this, Configurations_Activity.class);
                myIntent.putExtra("score", gameInfo.score); //Optional parameters
                activity_achievements.this.startActivity(myIntent);
            }
        });

        //Botão para voltar atrás:
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open previous page with score
                Intent myIntent = new Intent(activity_achievements.this, Game_Home_Activity.class);
                myIntent.putExtra("score", gameInfo.score); //Optional parameters
                activity_achievements.this.startActivity(myIntent);
            }
        });

        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open previous page with score
                Intent myIntent = new Intent(activity_achievements.this, activity_stats.class);
                myIntent.putExtra("score", gameInfo.score); //Optional parameters
                activity_achievements.this.startActivity(myIntent);
            }
        });

        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open previous page with score
                Intent myIntent = new Intent(activity_achievements.this, activity_shop.class);
                myIntent.putExtra("score", gameInfo.score); //Optional parameters
                activity_achievements.this.startActivity(myIntent);
            }
        });
    }
}