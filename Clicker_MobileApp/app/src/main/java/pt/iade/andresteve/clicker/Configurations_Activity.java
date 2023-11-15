package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Configurations_Activity extends AppCompatActivity {

    private ImageButton btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations);
        btnGoBack = (ImageButton) findViewById(R.id.go_back_configuration_button);

        //Botão para voltar atrás:
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Configurations_Activity.this, Game_Home_Activity.class));
            }
        });
    }
}