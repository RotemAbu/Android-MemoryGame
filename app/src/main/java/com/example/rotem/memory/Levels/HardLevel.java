package com.example.rotem.memory.Levels;

import android.widget.ImageButton;
import android.widget.TextView;
import com.example.rotem.memory.R;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Rotem on 10/05/2016.
 */
public class HardLevel extends MediumLevel
{

    ImageButton i13, i14, i15, i16, i17, i18, i19, i20;

    public HardLevel(ImageButton Back_btn, ImageButton i1, ImageButton i2, ImageButton i3, ImageButton i4, ImageButton i5, ImageButton i6, ImageButton i7, ImageButton i8, ImageButton i9, ImageButton i10, ImageButton i11, ImageButton i12, ImageButton i13, ImageButton i14, ImageButton i15, ImageButton i16, ImageButton i17, ImageButton i18, ImageButton i19, ImageButton i20, ArrayList<Integer> images, ArrayList<Integer> flag_list, ArrayList<ImageButton> list, ArrayList<Integer> random_images, String phone_number, TextView set_min_steps, String level) {
        super(Back_btn, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, images, flag_list, list, random_images,phone_number,set_min_steps,level);
        this.i13=i13;
        this.i14=i14;
        this.i15=i15;
        this.i16=i16;
        this.i17=i17;
        this.i18=i18;
        this.i19=i19;
        this.i20=i20;

        this.cards_num = 20;
    }

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
        options.add(8, R.drawable.card_5);
        options.add(9, R.drawable.card_5);
        options.add(10, R.drawable.card_6);
        options.add(11, R.drawable.card_6);
        options.add(12, R.drawable.card_7);
        options.add(13, R.drawable.card_7);
        options.add(14, R.drawable.card_8);
        options.add(15, R.drawable.card_8);
        options.add(16, R.drawable.card_9);
        options.add(17, R.drawable.card_9);
        options.add(18, R.drawable.card_10);
        options.add(19, R.drawable.card_10);

        for (int i = 0; i < 20; i++)
        {
            random_value = rand.nextInt(20 - i);
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
        else if(card==R.drawable.card_7)
            return 7;
        else if(card==R.drawable.card_8)
            return 8;
        else if (card==R.drawable.card_9)
            return 9;
        else if (card==R.drawable.card_10)
            return 10;
        else return 0;
    }
}
