package com.example.rotem.memory.Levels;

import android.os.Handler;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.rotem.memory.R;
import com.example.rotem.memory.Server.GetPostReq;
import com.example.rotem.memory.Server.SendPosReq;
import com.example.rotem.memory.Server.UpdatePostReq;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rotem on 10/05/2016.
 */
public class EasyLevel
{
    public String min_steps;
    int index_min_steps;
    public int min_step;
    String phone_number,level;
    int cards_num;
    public int count_of_steps;
    TextView set_count_of_steps, set_minsteps;
    ImageButton Back_btn, i1, i2, i3, i4, i5, i6 , i7 , i8;

    ArrayList<Integer> images = new ArrayList<Integer>(); //the card images
    ArrayList<Integer> flag_list = new ArrayList<Integer>();
    ArrayList<ImageButton> list = new ArrayList<ImageButton>();
    ArrayList<Integer> random_images = new ArrayList<Integer>();

    public EasyLevel(ImageButton Back_btn, ImageButton i1, ImageButton i2, ImageButton i3, ImageButton i4, ImageButton i5, ImageButton i6,ImageButton i7,ImageButton i8, ArrayList<Integer> images, ArrayList<Integer> flag_list, ArrayList<ImageButton> list, ArrayList<Integer> random_images,String tel,TextView set_min_steps,String level) {
        this.Back_btn = Back_btn;
        this.count_of_steps=0;
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
        this.i5 = i5;
        this.i6 = i6;
        this.i7 = i7;
        this.i8 = i8;

        this.images = images;
        this.flag_list = flag_list;
        this.list = list;
        this.random_images = random_images;
        this.cards_num = 8;
        this.phone_number = tel;
        this.level = level;
        GetPostReq gpr = new GetPostReq("ID="+phone_number+"&Level="+level);
        Thread t = new Thread(gpr);
        t.start();
        try
        {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.min_steps = gpr.minSteps;
        index_min_steps = min_steps.indexOf("steps");
        min_steps = min_steps.substring(index_min_steps + 8, index_min_steps + 11);
        min_steps = min_steps.replaceAll("[^0-9]", ""); //clear all chars, left only numbers
        if(min_steps == "") min_steps = "0";
        min_step = Integer.parseInt(min_steps);
        this.set_minsteps = set_min_steps;
    }

    public void choose_2_cards()
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < cards_num; i++)
                {
                    if (flag_list.get(i) != 1) //the card is close (question mark)
                    {
                        list.get(i).setImageResource(R.drawable.que); //close card - not a match
                        images.set(i, 0); //no image photo in array
                    }
                }
            }
        }, 400);
    }

    public void check_for_winner(TextView winner,int cards_num)
    {
        int count = 0; //num of open cards
        for (int i = 0; i < cards_num; i++)
        {
            if (flag_list.get(i) == 1) //the card is open
            {
                count++;
            }
        }
        if (count == cards_num) //all cards are open
        {
            winner.setText("Congratulation\nYou won!");
            if (min_step == 0) //this phone doesn't exist in db
            {
                SendPosReq spr = new SendPosReq("ID="+phone_number+"&minSteps="+count_of_steps+"&Level="+level);
                Thread t = new Thread(spr);
                t.start();
            }
            else if (count_of_steps < min_step) //this phone id exist on db but the score is lower, update the score
            {
                UpdatePostReq upr = new UpdatePostReq("ID="+phone_number+"&minSteps="+count_of_steps+"&Level="+level);
                Thread t = new Thread(upr);
                t.start();
            }
       }}


    public ArrayList<Integer> set_random_images()
    {
        Random rand = new Random();
        int random_value;
        ArrayList<Integer> options = new ArrayList<Integer>();

        options.add(0, R.drawable.card_1);
        options.add(1, R.drawable.card_1);
        options.add(2, R.drawable.card_2);
        options.add(3, R.drawable.card_2);
        options.add(4, R.drawable.card_3);
        options.add(5, R.drawable.card_3);
        options.add(6, R.drawable.card_4);
        options.add(7, R.drawable.card_4);

        for (int i = 0; i < 8; i++)
        {
            random_value = rand.nextInt(8 - i);
            random_images.add(i, options.get(random_value));
            options.remove(random_value);
        }
        return random_images;
    }


    public void play_game(int position,TextView winner,TextView set_count_of_steps)
    {
        int count = 0;
        if (images.get(position) == 0) //there is no image photo yet
        {
            list.get(position).setImageResource(random_images.get(position)); //set random image photo
            images.set(position, get_card_number(random_images.get(position)));
        }
        for (int i = 0; i < cards_num; i++)
        {
            if ((images.get(i) != 0) && (flag_list.get(i) == 0)) count++; //not match
        }
        if (count == 2)
        {
            count_of_steps++;
            for (int i = 0; i < cards_num; i++)
            {
                if ((i != position) && (images.get(position) == images.get(i)) && (images.get(i) != 0) && (images.get(position) != 0)) //found a match
                {
                    flag_list.set(i, 1); //set open card - the card stay open
                    flag_list.set(position, 1);
                }
            }
            set_count_of_steps.setText(""+count_of_steps);
            choose_2_cards();
            check_for_winner(winner,cards_num);
        }
    }

    public int get_card_number(int card)
    {
        if (card == R.drawable.card_1)
            return 1;
        else if (card == R.drawable.card_2)
            return 2;
        else if (card == R.drawable.card_3)
            return 3;
        else if (card == R.drawable.card_4)
            return 4;
        else return 0; //the card is question mark
    }


    public boolean check_2_cards_open()
    {
        int count = 0;
        for (int i=0; i < cards_num; i++)
        {
            if( (images.get(i) != 0) && (flag_list.get(i) == 0)) count++;
        }
        if (count == 2)
            return false;
        else
            return true;
    }

}

