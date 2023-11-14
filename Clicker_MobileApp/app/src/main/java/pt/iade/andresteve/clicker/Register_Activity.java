package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Register_Activity extends AppCompatActivity {
    private ImageButton btnGoBack;
    private Button btnRegister;
    private EditText textUsername;
    private EditText textPassword;
    private EditText textConfirmPass;
    private EditText textEmail;
    public boolean TextBoxesFilled(View view)
    {
        textUsername = (EditText)findViewById(R.id.username_login_text);
        textPassword =(EditText)findViewById(R.id.password_login_text);
        textConfirmPass = (EditText)findViewById(R.id.username_login_text);
        textEmail =(EditText)findViewById(R.id.password_login_text);
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

        btnGoBack = (ImageButton)findViewById(R.id.go_back_regiter_button);
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(Register_Activity.this, MainActivity.class));
            }

        });


        btnRegister = (Button)findViewById(R.id.submit_regist_button);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextBoxesFilled(view))
                {
                    //test
                    Toast.makeText(getApplicationContext(), "Preencha as informações que faltam!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    startActivity(new Intent(Register_Activity.this, MainActivity.class));
                }
            }

        });
    }
}