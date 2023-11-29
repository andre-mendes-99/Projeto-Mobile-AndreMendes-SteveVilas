package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import pt.iade.andresteve.clicker.games.GameInfo;

public class activity_shop extends AppCompatActivity {
    private ImageButton btnGoBack;
    private ImageButton btnConfig;
    private Button btnAchievments;
    private Button btnStats;
    private TextView scoreView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        //get score
        GameInfo gameInfo = new GameInfo();
        Intent intent = getIntent();
        gameInfo.score = intent.getDoubleExtra("score", 0);
        scoreView = (TextView)findViewById(R.id.textView_score_points_shop);
        scoreView.setText(Double.toString(gameInfo.score));

        btnGoBack = (ImageButton) findViewById(R.id.button_go_back_shop);
        btnStats = (Button) findViewById(R.id.button_stats_shop);
        btnAchievments = (Button) findViewById(R.id.button_achievements_shop);
        btnConfig = (ImageButton) findViewById(R.id.button_settings_shop);

        //botão de configurações
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(activity_shop.this, Configurations_Activity.class);
                myIntent.putExtra("score", gameInfo.score); //Optional parameters
                activity_shop.this.startActivity(myIntent);
            }
        });

        //Botão para voltar atrás:
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open previous page with score
                Intent myIntent = new Intent(activity_shop.this, Game_Home_Activity.class);
                myIntent.putExtra("score", gameInfo.score); //Optional parameters
                activity_shop.this.startActivity(myIntent);
            }
        });

        btnAchievments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(activity_shop.this, activity_achievements.class);
                myIntent.putExtra("score", gameInfo.score); //Optional parameters
                activity_shop.this.startActivity(myIntent);
            }
        });

        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(activity_shop.this, activity_stats.class);
                myIntent.putExtra("score", gameInfo.score); //Optional parameters
                activity_shop.this.startActivity(myIntent);
            }
        });
    }
}