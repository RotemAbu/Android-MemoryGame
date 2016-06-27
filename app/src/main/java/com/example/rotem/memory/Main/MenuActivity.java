package com.example.rotem.memory.Main;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.rotem.memory.GameDif.EasyActivity;
import com.example.rotem.memory.GameDif.HardActivity;
import com.example.rotem.memory.GameDif.MediumActivity;
import com.example.rotem.memory.R;

/**
 * Created by Rotem on 10/05/2016.
 */
public class MenuActivity extends AppCompatActivity
{
    Button Play_btn, Difficulty_btn ,Exit_btn;
    Animation menu_anim2;
    ImageView animation3;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();

        menu_anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.menu_anim2);
        animation3 = (ImageView) findViewById(R.id.animation3);
        animation3.startAnimation(menu_anim2);

        Exit_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) //exit button
            {
                exit_game();
            }
        });

        Play_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) //play button
            {

                DifficultyActivity diff_activity = new DifficultyActivity();
                if (diff_activity.getLevel() == 2)
                {
                    Play_btn.setText("Level 2\n Loading..."); //change button text
                    Intent intent_diff = new Intent(getApplicationContext(), MediumActivity.class);
                    startActivity(intent_diff);
                    finish();
                }
                else if (diff_activity.getLevel() == 3)
                {
                    Play_btn.setText("Level 3\n Loading...");
                    Intent intent_diff = new Intent(getApplicationContext(), HardActivity.class);
                    startActivity(intent_diff);
                    finish();
                }
                else
                {
                    Play_btn.setText("Level 1\n Loading...");
                    Intent intent_diff = new Intent(getApplicationContext(), EasyActivity.class);
                    startActivity(intent_diff);
                    finish();
                }
            }
        });

        Difficulty_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) //difficulty button
            {
                Intent intent_diff = new Intent(getApplicationContext(), DifficultyActivity.class);
                startActivity(intent_diff);
                finish();
            }
        });
    }

    private void init()
    {
        Play_btn = (Button)findViewById(R.id.Play_btn);
        Difficulty_btn = (Button)findViewById(R.id.Difficulty_btn);
        Exit_btn = (Button)findViewById(R.id.Exit_btn);
    }

    public void exit_game()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        });

        builder.setNegativeButton("no", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });

        builder.setCancelable(false); //must choose yes or no
        builder.show();
    }

}


