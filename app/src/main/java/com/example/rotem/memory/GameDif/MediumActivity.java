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
import com.example.rotem.memory.Levels.MediumLevel;
import com.example.rotem.memory.Main.DifficultyActivity;
import com.example.rotem.memory.Main.MainActivity;
import com.example.rotem.memory.Main.MenuActivity;
import com.example.rotem.memory.R;
import java.util.ArrayList;

/**
 * Created by Rotem on 10/05/2016.
 */
public class MediumActivity extends AppCompatActivity
{
    MainActivity mainActivity = new MainActivity();
    Button NextLevel3;
    TextView winner,set_count_of_steps,setMinSteps ;
    ImageButton Back_btn, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12;

    ArrayList<Integer> images = new ArrayList<Integer>();
    ArrayList<Integer> flag_list = new ArrayList<Integer>();
    ArrayList<ImageButton> list = new ArrayList<ImageButton>();
    ArrayList<Integer> random_images = new ArrayList<Integer>();

    MediumLevel medium_level = new MediumLevel( Back_btn,  i1,  i2,  i3,  i4,  i5,  i6, i7, i8, i9, i10, i11, i12, images, flag_list, list,  random_images,mainActivity.tel,setMinSteps,"2");

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediumgame);
        final MenuActivity menuactivity = new MenuActivity();
        init();

        setMinSteps.setText(medium_level.min_steps);
        medium_level.set_random_images();
        NextLevel3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (winner.getText() == "Congratulation\nYou won!")
                {
                    NextLevel3.setText("Loading level 3...");
                    Intent nextLevel_3_intent = new Intent(getApplicationContext(), HardActivity.class);
                    startActivity(nextLevel_3_intent);
                    finish();
                }
            }
        });

        Back_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent_back = new Intent(getApplicationContext(), DifficultyActivity.class);
                startActivity(intent_back);
                finish();
            }
        });

        list.get(0).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (!(medium_level.check_2_cards_open())) {}
                else {
                    medium_level.play_game(0,winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(1).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(medium_level.check_2_cards_open())) {}
                else
                {
                    medium_level.play_game(1,winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(2).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(medium_level.check_2_cards_open())) {}
                else
                {
                    medium_level.play_game(2, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(3).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(medium_level.check_2_cards_open())) {}
                else
                {
                    medium_level.play_game(3, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(4).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(medium_level.check_2_cards_open())) {}
                else
                {
                    medium_level.play_game(4, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(5).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(medium_level.check_2_cards_open())) {}
                else
                {
                    medium_level.play_game(5, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(6).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(medium_level.check_2_cards_open())) {}
                else
                {
                    medium_level.play_game(6, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(7).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(medium_level.check_2_cards_open())) {}
                else
                {
                    medium_level.play_game(7, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(8).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(medium_level.check_2_cards_open())) {}
                else
                {
                    medium_level.play_game(8, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(9).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(medium_level.check_2_cards_open())) {}
                else
                {
                    medium_level.play_game(9, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(10).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(medium_level.check_2_cards_open())) {}
                else
                {
                    medium_level.play_game(10, winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});

        list.get(11).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!(medium_level.check_2_cards_open())) {}
                else
                {
                    medium_level.play_game(11,winner,set_count_of_steps);
                }
                CheckingMinSteps();
            }});
    }

    private void init()
    {
        NextLevel3 = (Button)findViewById(R.id.NextLevel3);
        setMinSteps = (TextView)findViewById(R.id.set_min_steps);
        set_count_of_steps = (TextView)findViewById(R.id.set_steps_count);
        winner = (TextView)findViewById(R.id.Winner);
        Back_btn = (ImageButton)findViewById(R.id.back_buttom_3);

        i1 = (ImageButton)findViewById(R.id.card1);
        i2 = (ImageButton)findViewById(R.id.card2);
        i3 = (ImageButton)findViewById(R.id.card3);
        i4 = (ImageButton)findViewById(R.id.card4);
        i5 = (ImageButton)findViewById(R.id.card5);
        i6 = (ImageButton)findViewById(R.id.card6);
        i7 = (ImageButton)findViewById(R.id.card7);
        i8 = (ImageButton)findViewById(R.id.card8);
        i9 = (ImageButton)findViewById(R.id.card9);
        i10 = (ImageButton)findViewById(R.id.card10);
        i11 = (ImageButton)findViewById(R.id.card11);
        i12 = (ImageButton)findViewById(R.id.card12);

        list.add(0,i1);
        list.add(1, i2);
        list.add(2, i3);
        list.add(3, i4);
        list.add(4, i5);
        list.add(5, i6);
        list.add(6, i7);
        list.add(7, i8);
        list.add(8, i9);
        list.add(9, i10);
        list.add(10, i11);
        list.add(11, i12);

        flag_list.add(0, 0);
        flag_list.add(1, 0);
        flag_list.add(2, 0);
        flag_list.add(3, 0);
        flag_list.add(4, 0);
        flag_list.add(5, 0);
        flag_list.add(6, 0);
        flag_list.add(7, 0);
        flag_list.add(8, 0);
        flag_list.add(9, 0);
        flag_list.add(10, 0);
        flag_list.add(11, 0);

        images.add(0, 0);
        images.add(1, 0);
        images.add(2, 0);
        images.add(3, 0);
        images.add(4, 0);
        images.add(5, 0);
        images.add(6, 0);
        images.add(7, 0);
        images.add(8, 0);
        images.add(9, 0);
        images.add(10, 0);
        images.add(11, 0);
    }

    public void CheckingMinSteps()
    {
        if ((winner.getText() == "Congratulation\nYou won!"))
        {
            NextLevel3.setTextColor(Color.argb(255, 0, 0, 0));
            NextLevel3.setBackgroundResource(R.drawable.btn);
            if ((medium_level.count_of_steps < medium_level.min_step) || (medium_level.min_step == 0))
                setMinSteps.setText(medium_level.count_of_steps + "");
        }
    }
}
