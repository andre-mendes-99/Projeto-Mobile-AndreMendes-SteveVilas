package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import pt.iade.andresteve.clicker.models.Player;
import pt.iade.andresteve.clicker.retrofit.PlayerApi;
import pt.iade.andresteve.clicker.retrofit.Retrofitservice;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private Button btnRegister;
    private Button btnLogin;
    private Button btnGuest;
    private EditText textUsername;
    private EditText textPassword;


    public boolean LoginIsValid(List<Player> playerlist)
    {
        boolean isValid = false;
        for (Player player:playerlist)
        {
            if(player.getEmail() == textUsername.getText().toString() && player.getPassword() == textPassword.getText().toString())
            {
                isValid= true;
                break;
            }
        }
        return isValid;
    }
    public boolean CheckEntrys(View view)
    {
         textUsername = (EditText)findViewById(R.id.username_login_text);
         textPassword =(EditText)findViewById(R.id.password_login_text);
         if(textPassword.getText().toString().equals("") || textUsername.getText().toString().equals(""))
         {
             return false;
         }
         return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofitservice retrofitservice = new Retrofitservice();
        PlayerApi playerApi = retrofitservice.getRetrofit().create(PlayerApi.class);

        btnRegister = (Button)findViewById(R.id.main_register_button);
        btnLogin = (Button)findViewById(R.id.main_submit_login);
        btnGuest = (Button)findViewById(R.id.main_guest_button);

        //botão para acessar com conta guest
        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Game_Home_Activity.class);
                //myIntent.putExtra("score", gameInfo.score); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });

        //botão para ir para ir para a página de registo:
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    startActivity(new Intent(MainActivity.this, Register_Activity.class));

            }

        });

        //botão para fazer login:
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!CheckEntrys(view))
                {
                    //test
                    Toast.makeText(getApplicationContext(), "Preencha as informações que faltam!", Toast.LENGTH_LONG).show();
                }
                else
                {
                  playerApi.getPlayers().enqueue(new Callback<List<Player>>() {
                      @Override
                      public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                          if (!response.body().isEmpty() || response.body()!=null)
                          {
                              if(LoginIsValid(response.body()))
                              {
                                  Toast.makeText(getApplicationContext(), "Login efectuado com sucesso!", Toast.LENGTH_LONG).show();
                                  startActivity(new Intent(MainActivity.this, Game_Home_Activity.class));
                              }
                              else
                              {
                                  Toast.makeText(getApplicationContext(), "Login efectuado com sucesso!", Toast.LENGTH_LONG).show();
                              }
                          }
                      }

                      @Override
                      public void onFailure(Call<List<Player>> call, Throwable t) {
                          Toast.makeText(getApplicationContext(), "Erro no login!", Toast.LENGTH_LONG).show();
                      }
                  });
                }
            }

        });
    }
}