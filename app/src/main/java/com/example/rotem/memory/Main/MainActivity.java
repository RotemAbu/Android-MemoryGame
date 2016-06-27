package com.example.rotem.memory.Main;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.example.rotem.memory.R;

public class MainActivity extends ActionBarActivity {

    public TelephonyManager phone_number;
    public static String tel;
    Animation menu_anim , menu_anim2;
    ImageView animation1 , animation2;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        phone_number = (TelephonyManager) getSystemService(getApplicationContext().TELEPHONY_SERVICE);

        menu_anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.menu_anim);
        animation1 = (ImageView) findViewById(R.id.animation1);
        animation1.startAnimation(menu_anim);

        menu_anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.menu_anim2);
        animation2 = (ImageView) findViewById(R.id.animation2);
        animation2.startAnimation(menu_anim2);


        animation1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) //on click go to next activity - menu
            {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}

