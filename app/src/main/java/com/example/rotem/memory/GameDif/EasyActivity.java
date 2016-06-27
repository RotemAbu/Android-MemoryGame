package com.example.rotem.memory.GameDif;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.rotem.memory.Levels.EasyLevel;
import com.example.rotem.memory.Main.DifficultyActivity;
import com.example.rotem.memory.Main.MainActivity;
import com.example.rotem.memory.Main.MenuActivity;
import com.example.rotem.memory.R;
import java.util.ArrayList;

/**
 * Created by Rotem on 10/05/2016.
 */

public class EasyActivity extends AppCompatActivity
{

    ImageButton Back_btn, i1, i2, i3, i4, i5, i6, i7, i8;
    MainActivity mainActivity = new MainActivity();
    Button NextLevel2;
    TextView winner,set_count_of_steps,setMinSteps;

    ArrayList<Integer> images = new ArrayList<Integer>(); //the card images - what card is showing right now
    ArrayList<Integer> flag_list = new ArrayList<Integer>(); //flag to check if open/close, at first all set to 0(close)
    ArrayList<ImageButton> list = new ArrayList<ImageButton>(); //
    ArrayList<Integer> random_images = new ArrayList<Integer>(); //set random images in cards

    EasyLevel easy_Level = new EasyLevel( Back_btn,i1,i2,i3,i4,i5,i6,i7,i8,images,flag_list,list,random_images,mainActivity.tel,setMinSteps,"1");

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easygame);
        final MenuActivity menuactivity = new MenuActivity();
        init();

        setMinSteps.setText(easy_Level.min_steps);
        easy_Level.set_random_images();

        NextLevel2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(winner.getText() == "Congratulation\nYou won!")
                {
                    NextLevel2.setText("Loading level 2...");
                    Intent nextLevel_2_intent = new Intent(getApplicationContext(), MediumActivity.class);
                    startActivity(nextLevel_2_intent);
                    finish();
                }}
        });

        Back_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent_back = new Intent(getApplicationContext(), DifficultyActivity.class);
                startActivity(intent_back);
                finish();
            }
        });

        list.get(0).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(easy_Level.check_2_cards_open())) {} //if there is no match between two cards
                else
                {
                    easy_Level.play_game(0, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(1).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(easy_Level.check_2_cards_open())){}
                else
                {
                    easy_Level.play_game(1, winner,set_count_of_steps);}
                CheckingMinSteps();
            }});

        list.get(2).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(easy_Level.check_2_cards_open())){}
                else
                {
                    easy_Level.play_game(2, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(3).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(easy_Level.check_2_cards_open())){}
                else
                {
                    easy_Level.play_game(3, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(4).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(easy_Level.check_2_cards_open())){}
                else {
                    easy_Level.play_game(4, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(5).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(easy_Level.check_2_cards_open())){}
                else {
                    easy_Level.play_game(5, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(6).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(easy_Level.check_2_cards_open())){}
                else {
                    easy_Level.play_game(6, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(7).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(easy_Level.check_2_cards_open())){}
                else {
                    easy_Level.play_game(7, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});
    }

    private void init()
    {
        NextLevel2 = (Button)findViewById(R.id.NextLevel2);
        setMinSteps = (TextView)findViewById(R.id.set_min_steps);
        winner = (TextView)findViewById(R.id.Winner);
        set_count_of_steps = (TextView)findViewById(R.id.set_steps_count);
        Back_btn = (ImageButton)findViewById(R.id.back_buttom_3);

        i1 = (ImageButton)findViewById(R.id.card1);
        i2 = (ImageButton)findViewById(R.id.card2);
        i3 = (ImageButton)findViewById(R.id.card3);
        i4 = (ImageButton)findViewById(R.id.card4);
        i5 = (ImageButton)findViewById(R.id.card5);
        i6 = (ImageButton)findViewById(R.id.card6);
        i7 = (ImageButton)findViewById(R.id.card7);
        i8 = (ImageButton)findViewById(R.id.card8);

        list.add(0, i1);
        list.add(1, i2);
        list.add(2, i3);
        list.add(3, i4);
        list.add(4, i5);
        list.add(5, i6);
        list.add(6, i7);
        list.add(7, i8);

        flag_list.add(0, 0);
        flag_list.add(1, 0);
        flag_list.add(2, 0);
        flag_list.add(3, 0);
        flag_list.add(4, 0);
        flag_list.add(5, 0);
        flag_list.add(6, 0);
        flag_list.add(7, 0);

        images.add(0, 0);
        images.add(1, 0);
        images.add(2, 0);
        images.add(3, 0);
        images.add(4, 0);
        images.add(5, 0);
        images.add(6, 0);
        images.add(7, 0);
    }

    public void CheckingMinSteps()
    {
        if ((winner.getText() == "Congratulation\nYou won!"))
        {
            NextLevel2.setTextColor(Color.argb(255, 0, 0, 0));
            NextLevel2.setBackgroundResource(R.drawable.btn);
            if ((easy_Level.count_of_steps < easy_Level.min_step)||( easy_Level.min_step==0))
                setMinSteps.setText(easy_Level.count_of_steps + "");

        }}
}



