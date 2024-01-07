package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.logging.Level;
import java.util.logging.Logger;

import pt.iade.andresteve.clicker.models.Player;
import pt.iade.andresteve.clicker.retrofit.PlayerApi;
import pt.iade.andresteve.clicker.retrofit.Retrofitservice;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register_Activity extends AppCompatActivity {
    private ImageButton btnGoBack;
    private Button btnRegister;
    private EditText textUsername;
    private EditText textPassword;
    private EditText textConfirmPass;
    private EditText textEmail;

    public boolean checkPass(View view){
        textPassword =(EditText)findViewById(R.id.password_register_textbox);
        textConfirmPass = (EditText)findViewById(R.id.password_confirmation_register_textbox);
        if(!textConfirmPass.getText().toString().equals(textPassword.getText().toString()))
        {
            return false;
        }
        return true;
    }

    public boolean TextBoxesFilled(View view)
    {
        textUsername = (EditText)findViewById(R.id.username_register_textbox);
        textPassword =(EditText)findViewById(R.id.password_register_textbox);
        textConfirmPass = (EditText)findViewById(R.id.password_confirmation_register_textbox);
        textEmail =(EditText)findViewById(R.id.email_register_textbox);
        if(textPassword.getText().toString().equals("") || textUsername.getText().toString().equals("") || textConfirmPass.getText().toString().equals("") || textEmail.getText().toString().equals(""))
        {
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Retrofitservice retrofitservice = new Retrofitservice();

        PlayerApi playerApi = retrofitservice.getRetrofit().create(PlayerApi.class);

        textUsername = (EditText)findViewById(R.id.username_register_textbox);
        textPassword =(EditText)findViewById(R.id.password_register_textbox);
        textConfirmPass = (EditText)findViewById(R.id.password_confirmation_register_textbox);
        textEmail =(EditText)findViewById(R.id.email_register_textbox);


        btnGoBack = (ImageButton)findViewById(R.id.go_back_regiter_button);
        btnRegister = (Button)findViewById(R.id.submit_regist_button);


        //botão para voltar para trás:
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(Register_Activity.this, MainActivity.class));
            }

        });



        //botão de registo:
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextBoxesFilled(view))
                {
                    //test
                    Toast.makeText(getApplicationContext(), "Preencha as informações que faltam!", Toast.LENGTH_LONG).show();
                }
                else if(!checkPass(view))
                {
                    Toast.makeText(getApplicationContext(), "A password inserida não é igual à do campo Password!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    String username = textUsername.getText().toString();
                    String usermail = textEmail.getText().toString();
                    String userpass = textPassword.getText().toString();

                    Player newplayer = new Player(username, usermail,userpass,0,0);

                    playerApi.addPLayer(newplayer)
                            .enqueue(new Callback<Player>() {
                                @Override
                                public void onResponse(Call<Player> call, Response<Player> response) {
                                    Toast.makeText(getApplicationContext(), "Jogador registado com sucesso!", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(Register_Activity.this, MainActivity.class));
                                }

                                @Override
                                public void onFailure(Call<Player> call, Throwable t) {
                                    Toast.makeText(getApplicationContext(), "Falha ao registar jogador!", Toast.LENGTH_LONG).show();
                                    Logger.getLogger(Register_Activity.class.getName()).log(Level.SEVERE, "Ocorreu erro!");
                                }
                            });
                }
            }

        });
    }
}