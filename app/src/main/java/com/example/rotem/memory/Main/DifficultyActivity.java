package com.example.rotem.memory.Main;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.rotem.memory.GameDif.EasyActivity;
import com.example.rotem.memory.GameDif.HardActivity;
import com.example.rotem.memory.GameDif.MediumActivity;
import com.example.rotem.memory.R;

/**
 * Created by Rotem on 10/05/2016.
 */

public class DifficultyActivity extends AppCompatActivity
{
    ImageButton Back_btn;
    static public Button Easy_btn, Mediun_btn, Hard_btn;
    static public int level;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        init();

        Easy_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                level = 1; //easy
                Easy_btn.setText("Loading....");
                Mediun_btn.setText("Medium\n14 cards");
                Hard_btn.setText("Hard\n20 cards"); //change text on buttons
                Intent intent_easy = new Intent(getApplicationContext(), EasyActivity.class);
                startActivity(intent_easy);
                finish();
            }
        });

        Mediun_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                level = 2;
                Mediun_btn.setText("Loading....");
                Easy_btn.setText("Easy\n8 cards");
                Hard_btn.setText("Hard\n24 cards");
                Intent intent_medium = new Intent(getApplicationContext(), MediumActivity.class);
                startActivity(intent_medium);
                finish();
            }
        });

        Hard_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                level = 3;
                Hard_btn.setText("Loading....");
                Easy_btn.setText("Easy\n8 card)");
                Mediun_btn.setText("Medium\n14 cards");
                Intent intent_hard = new Intent(getApplicationContext(), HardActivity.class);
                startActivity(intent_hard);
                finish();
            }
        });

        Back_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) //back to menu
            {
                Intent intent_back = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent_back);
                finish();
            }
        });
    }

    private void init()
    {
        Back_btn = (ImageButton)findViewById(R.id.back_btn);
        Easy_btn = (Button)findViewById(R.id.Easy_btn);
        Mediun_btn = (Button)findViewById(R.id.Mediun_btn);
        Hard_btn = (Button)findViewById(R.id.Hard_btn);
    }

    public int getLevel()
    {
        return level;
    }
}
