package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Game_Home_Activity extends AppCompatActivity {
    private ImageButton btnClickerTemp;
    private TextView scoreView;
    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_home);

        scoreView = (TextView)findViewById(R.id.score_game_home_textview);
        scoreView.setText(Integer.toString(score));
        btnClickerTemp = (ImageButton) findViewById(R.id.button_clicker_home_page);
        btnClickerTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             score+=1;
             scoreView.setText(Integer.toString(score));
            }

        });
    }
}