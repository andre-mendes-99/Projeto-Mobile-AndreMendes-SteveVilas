package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import pt.iade.andresteve.clicker.games.GameInfo;

public class Configurations_Activity extends AppCompatActivity {

    private ImageButton btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations);

        //get score
        GameInfo gameInfo = new GameInfo();
        Intent intent = getIntent();
        gameInfo.score = intent.getDoubleExtra("score", 0);

        btnGoBack = (ImageButton) findViewById(R.id.go_back_configuration_button);

        //Botão para voltar atrás:
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open previous page with score
                Intent myIntent = new Intent(Configurations_Activity.this, Game_Home_Activity.class);
                myIntent.putExtra("score", gameInfo.score); //Optional parameters
                Configurations_Activity.this.startActivity(myIntent);
            }
        });
    }
}