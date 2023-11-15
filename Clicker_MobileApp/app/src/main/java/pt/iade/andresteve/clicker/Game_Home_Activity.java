package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Game_Home_Activity extends AppCompatActivity {
    private ImageButton btnClickerTemp;
    private ImageButton btnConfig;
    private ImageButton btnMinigame;
    private TextView scoreView;
    private int score = 0; //temporário deopois começa com o valor da base de dados
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_home);

        scoreView = (TextView)findViewById(R.id.score_game_home_textview);
        scoreView.setText(Integer.toString(score));

        //Buttons
        btnMinigame= (ImageButton)findViewById(R.id.btn_minigame_game_home);
        btnConfig = (ImageButton) findViewById(R.id.button_settings_game_home);
        btnClickerTemp = (ImageButton) findViewById(R.id.button_clicker_home_page);

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
        btnMinigame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Game_Home_Activity.this, Rock_Paper_Scissors_Activity.class));
            }
        });
    }
}