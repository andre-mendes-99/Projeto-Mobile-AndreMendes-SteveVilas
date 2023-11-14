package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button btnRegister;
    private Button btnLogin;
    private EditText textUsername;
    private EditText textPassword;
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

        btnRegister = (Button)findViewById(R.id.main_register_button);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!CheckEntrys(view))
                {
                    //test
                    Toast.makeText(getApplicationContext(), "Preencha as informações que faltam!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    startActivity(new Intent(MainActivity.this, Register_Activity.class));
                }
            }

        });

        btnLogin = (Button)findViewById(R.id.main_submit_login);
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
                    startActivity(new Intent(MainActivity.this, Game_Home_Activity.class));
                }
            }

        });
    }
}