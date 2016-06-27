package com.example.rotem.memory.Levels;

import android.widget.ImageButton;
import android.widget.TextView;
import com.example.rotem.memory.R;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rotem on 10/05/2016.
 */
public class MediumLevel extends EasyLevel
{
    ImageButton i9,i10,i11,i12;

    public MediumLevel(ImageButton Back_btn, ImageButton i1, ImageButton i2, ImageButton i3, ImageButton i4, ImageButton i5, ImageButton i6, ImageButton i7, ImageButton i8, ImageButton i9, ImageButton i10, ImageButton i11, ImageButton i12, ArrayList<Integer> images, ArrayList<Integer> flag_list, ArrayList<ImageButton> list, ArrayList<Integer> random_images, String phone_number, TextView set_min_steps, String level) {
        super(Back_btn, i1, i2, i3, i4, i5, i6,i7,i8, images, flag_list, list, random_images,phone_number,set_min_steps,level);
        this.i9=i9;
        this.i10=i10;
        this.i11=i11;
        this.i12=i12;
        this.cards_num = 12;
    }


    public ArrayList<Integer> set_random_images() {
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
        options.add(8, R.drawable.card_5);
        options.add(9, R.drawable.card_5);
        options.add(10, R.drawable.card_6);
        options.add(11, R.drawable.card_6);

        for (int i = 0; i < 12; i++)
        {
            random_value = rand.nextInt(12 - i);
            random_images.add(i, options.get(random_value));
            options.remove(random_value);
        }
        return random_images;
    }

    public int get_card_number(int card)
    {
        if ( card==R.drawable.card_1)
            return 1;
        else if(card==R.drawable.card_2)
            return 2;
        else if(card==R.drawable.card_3)
            return 3;
        else if (card==R.drawable.card_4)
            return 4;
        else if (card==R.drawable.card_5)
            return 5;
        else if (card==R.drawable.card_6)
            return 6;
        else return 0;
    }

}

