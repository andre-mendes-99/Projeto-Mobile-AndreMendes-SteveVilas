package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import pt.iade.andresteve.clicker.games.GameInfo;
import pt.iade.andresteve.clicker.models.Player;

public class activity_shop extends AppCompatActivity {
    private ImageButton btnGoBack,btnConfig, btnbuyupg1,btnbuyupg2, btnbuyupg3;

    private Button btnAchievments;
    private Button btnStats;
    private TextView scoreView, upgrade1cost, upgrade1level, upgrade2cost,upgrade2level,upgrade3cost,upgrade3level;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        //get score
        Intent intent = getIntent();
        Player player = (Player) intent.getSerializableExtra("player");

        scoreView = (TextView)findViewById(R.id.textView_score_points_shop);
        scoreView.setText(Double.toString(player.getScore()));
        //Upgrade 1
        upgrade1cost = (TextView) findViewById(R.id.shop_upgrade_price1);
        String cost1 = "Custo: " + Integer.toString((player.getUpgrade1Cost()));
        upgrade1cost.setText(cost1);

        upgrade1level = (TextView) findViewById(R.id.shop_upgrade_level1);
        String level1 = "LVL: " + Integer.toString(player.getUpgrade1Level());
        upgrade1level.setText(level1);

        //Upgrade 2
        upgrade2cost = (TextView) findViewById(R.id.shop_upgrade_price2);
        String cost2 = "Custo: " + Integer.toString(player.getUpgrade2Cost());
        upgrade2cost.setText(cost2);

        upgrade2level = (TextView) findViewById(R.id.shop_upgrade_level2);
        String level2 = "LVL: " + Integer.toString(player.getUpgrade2Level());
        upgrade2level.setText(level2);

        //Upgrade 3
        upgrade3cost = (TextView) findViewById(R.id.shop_upgrade_price3);
        String cost3 = "Custo: " + Integer.toString((player.getUpgrade3Cost()));
        upgrade3cost.setText(cost3);

        upgrade3level = (TextView) findViewById(R.id.shop_upgrade_level3);
        String level3 = "LVL: " + Integer.toString(player.getUpgrade3Level());
        upgrade3level.setText(level3);

        //Buttons
        btnGoBack = (ImageButton) findViewById(R.id.button_go_back_shop);
        btnStats = (Button) findViewById(R.id.button_stats_shop);
        btnAchievments = (Button) findViewById(R.id.button_achievements_shop);
        btnConfig = (ImageButton) findViewById(R.id.button_settings_shop);
        btnbuyupg1 = (ImageButton) findViewById(R.id.button_shop_upgrade_confirm_1);
        btnbuyupg2 = (ImageButton) findViewById(R.id.button_shop_upgrade_confirm_2);
        btnbuyupg3 = (ImageButton) findViewById(R.id.button_shop_upgrade_confirm_3);

        double scoreInicial = player.getScore();
        //botão de compra da melhoria 1
        btnbuyupg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player.getScore() < player.getUpgrade1Cost())
                {
                    Toast.makeText(getApplicationContext(), "Não tem pontos suficientes", Toast.LENGTH_LONG).show();
                }
                else
                {
                    player.setUpgrade1Level(player.getUpgrade1Level()+1);
                    int cost = player.getUpgrade1Level()*player.getUpgrade1Cost()+20;
                    player.setScore(scoreInicial-player.getUpgrade1Cost());
                    player.setUpgrade1Cost(cost);
                    upgrade1cost.setText("Custo: "+Integer.toString(player.getUpgrade1Cost()));
                    upgrade1level.setText("LVL: "+Integer.toString(player.getUpgrade1Level()));

                    scoreView.setText(Double.toString(player.getScore()));
                }
            }
        });

        //botão de compra melhoria 2
        btnbuyupg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.getScore() < player.getUpgrade2Cost())
                {
                    Toast.makeText(getApplicationContext(), "Não tem pontos suficientes", Toast.LENGTH_LONG).show();
                }
                else
                {
                    player.setUpgrade2Level(player.getUpgrade2Level()+1);
                    int cost = player.getUpgrade2Level()*player.getUpgrade2Cost()+20;
                    player.setScore(scoreInicial-player.getUpgrade2Cost());

                    player.setUpgrade2Cost(cost);
                    upgrade2cost.setText("Custo: "+Integer.toString(player.getUpgrade2Cost()));
                    upgrade2level.setText("LVL: "+Integer.toString(player.getUpgrade2Level()));
                    scoreView.setText(Double.toString(player.getScore()));

                }
            }
        });

        //botão de compra melhoria 3
        btnbuyupg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.getScore() < player.getUpgrade3Cost())
                {
                    Toast.makeText(getApplicationContext(), "Não tem pontos suficientes", Toast.LENGTH_LONG).show();
                }
                else
                {
                    player.setUpgrade3Level(player.getUpgrade3Level()+1);
                    int cost = player.getUpgrade3Level()*player.getUpgrade3Cost()+20;
                    player.setScore(scoreInicial-player.getUpgrade3Cost());

                    player.setUpgrade3Cost(cost);
                    upgrade3cost.setText("Custo: "+Integer.toString(player.getUpgrade3Cost()));
                    upgrade3level.setText("LVL: "+Integer.toString(player.getUpgrade3Level()));
                    scoreView.setText(Double.toString(player.getScore()));

                }
            }
        });

        //botão de configurações
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(activity_shop.this, Configurations_Activity.class);
                myIntent.putExtra("player", player); //Optional parameters
                activity_shop.this.startActivity(myIntent);
            }
        });

        //Botão para voltar atrás:
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open previous page with score
                Intent myIntent = new Intent(activity_shop.this, Game_Home_Activity.class);
                myIntent.putExtra("player", player); //Optional parameters
                activity_shop.this.startActivity(myIntent);
            }
        });

        btnAchievments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(activity_shop.this, activity_achievements.class);
                myIntent.putExtra("player", player); //Optional parameters
                activity_shop.this.startActivity(myIntent);
            }
        });

        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(activity_shop.this, activity_stats.class);
                myIntent.putExtra("player", player); //Optional parameters
                activity_shop.this.startActivity(myIntent);
            }
        });
    }
}