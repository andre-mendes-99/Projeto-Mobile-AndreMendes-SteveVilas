package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button btnregister;
    private EditText textusername;
    private EditText textpassword;
    public boolean CheckEntrys(View view)
    {
         textusername = (EditText)findViewById(R.id.username_login_text);
         textpassword =(EditText)findViewById(R.id.password_login_text);
         if(textpassword.getText().toString().equals("") || textusername.getText().toString().equals(""))
         {
             return false;
         }
         return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnregister = (Button)findViewById(R.id.main_register_button);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!CheckEntrys(view))
                {
                    Toast.makeText(getApplicationContext(), "Preencha as informações que faltam", Toast.LENGTH_LONG).show();
                }
                else
                {
                    startActivity(new Intent(MainActivity.this, Register_Activity.class));
                }
            }

        });
    }
}