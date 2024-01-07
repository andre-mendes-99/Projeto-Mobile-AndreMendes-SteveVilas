package pt.iade.andresteve.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import pt.iade.andresteve.clicker.games.GameInfo;
import pt.iade.andresteve.clicker.models.Player;

public class activity_achievements extends AppCompatActivity {
    private ImageButton btnGoBack;
    private ImageButton btnConfig;
    private Button btnShop;
    private Button btnStats;

    private TextView textviewAch1, textviewAch2, textViewAch3, textViewAch3_descri,textViewAch4, textViewAch4_descri;

    public boolean Achievment1IsAchieved(Player player)
    {
        if(player.getScore() >= 1000)
        {
            return true;
        }
        else
            {
                return false;
            }
    }
    public boolean Achievment2IsAchieved(Player player)
    {
        if (player.getScore() >= 10000)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean Achievment3IsAchieved(Player player)
    {
        if (player.getUpgrade1Level() >1 || player.getUpgrade2Level() >1 || player.getUpgrade3Level()>1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean Achievment4IsAchieved(Player player)
    {
        if (player.getUpgrade1Level() >1 && player.getUpgrade2Level() >1 && player.getUpgrade3Level()>1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        //get score
        Intent intent = getIntent();
        Player player = (Player) intent.getSerializableExtra("player");

        //TextViews
        textviewAch1 = (TextView) findViewById(R.id.achievement_1);
        textviewAch2 = (TextView) findViewById(R.id.achievement_2);
        textViewAch3 = (TextView) findViewById(R.id.achievement_3);
        textViewAch3_descri =(TextView) findViewById(R.id.achievement_3_description);
        textViewAch4= (TextView) findViewById(R.id.achievement_4);
        textViewAch4_descri =(TextView) findViewById(R.id.achievement_4_description);


        btnGoBack = (ImageButton) findViewById(R.id.button_go_back_achievements_button);
        btnStats = (Button) findViewById(R.id.button_stats_achievements);
        btnShop =(Button) findViewById(R.id.button_shop_achievements);
        btnConfig = (ImageButton) findViewById(R.id.button_settings_achievements);

       if(Achievment1IsAchieved(player))
       {
           textviewAch1.setTextColor(Color.parseColor("#FF4CAF50"));
       }
       else
       {
           textviewAch1.setTextColor(Color.parseColor("#FFFF0000"));
       }

       if(Achievment2IsAchieved(player))
       {
           textviewAch2.setTextColor(Color.parseColor("#FF4CAF50"));
       }
       else
       {
           textviewAch2.setTextColor(Color.parseColor("#FFFF0000"));
       }

       if(Achievment3IsAchieved(player))
       {
           textViewAch3.setTextColor(Color.parseColor("#FF4CAF50"));
           textViewAch3_descri.setTextColor(Color.parseColor("#FF4CAF50"));
       }
       else
       {
           textViewAch3.setTextColor(Color.parseColor("#FFFF0000"));
           textViewAch3_descri.setTextColor(Color.parseColor("#FFFF0000"));
       }

        if(Achievment4IsAchieved(player))
        {
            textViewAch4.setTextColor(Color.parseColor("#FF4CAF50"));
            textViewAch4_descri.setTextColor(Color.parseColor("#FF4CAF50"));
        }
        else
        {
            textViewAch4.setTextColor(Color.parseColor("#FFFF0000"));
            textViewAch4_descri.setTextColor(Color.parseColor("#FFFF0000"));
        }


        //botão de configurações
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(activity_achievements.this, Configurations_Activity.class);
                myIntent.putExtra("player", player); //Optional parameters
                activity_achievements.this.startActivity(myIntent);
            }
        });

        //Botão para voltar atrás:
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open previous page with score
                Intent myIntent = new Intent(activity_achievements.this, Game_Home_Activity.class);
                myIntent.putExtra("player", player); //Optional parameters
                activity_achievements.this.startActivity(myIntent);
            }
        });

        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open previous page with score
                Intent myIntent = new Intent(activity_achievements.this, activity_stats.class);
                myIntent.putExtra("player", player); //Optional parameters
                activity_achievements.this.startActivity(myIntent);
            }
        });

        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open previous page with score
                Intent myIntent = new Intent(activity_achievements.this, activity_shop.class);
                myIntent.putExtra("player", player); //Optional parameters
                activity_achievements.this.startActivity(myIntent);
            }
        });
    }
}