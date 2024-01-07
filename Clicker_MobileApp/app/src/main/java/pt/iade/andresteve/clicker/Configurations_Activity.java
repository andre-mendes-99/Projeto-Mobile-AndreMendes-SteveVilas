package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import pt.iade.andresteve.clicker.games.GameInfo;
import pt.iade.andresteve.clicker.models.Player;

public class Configurations_Activity extends AppCompatActivity {

    private ImageButton btnGoBack;
    private TextView usernameTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations);

        //get score
        Intent intent = getIntent();
        Player player = (Player) intent.getSerializableExtra("player");

        btnGoBack = (ImageButton) findViewById(R.id.go_back_configuration_button);
        usernameTextview = (TextView) findViewById(R.id.username_name_configuration_label);

        usernameTextview.setText(player.getPlayerName());

        //Botão para voltar atrás:
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open previous page with score
                Intent myIntent = new Intent(Configurations_Activity.this, Game_Home_Activity.class);
                myIntent.putExtra("player", player); //Optional parameters
                Configurations_Activity.this.startActivity(myIntent);
            }
        });
    }
}