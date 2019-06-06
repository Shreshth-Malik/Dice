package com.example.dice;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Page1.OnPage1InteractionListener {

    Button start;
    Button exit;
    public void animation(View view){

        ImageView dice=findViewById(R.id.dice);
        dice.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        dice.animate().translationYBy(1000f).rotation(3600f).setDuration(2000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView dice=findViewById(R.id.dice);
        dice.setY(-1000f);
        dice.animate().translationYBy(1000f).rotation(3600f).setDuration(2000);
        start=findViewById(R.id.start);
        exit=findViewById(R.id.exit);
        start.setVisibility(View.INVISIBLE);
        exit.setVisibility(View.INVISIBLE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                dice.setImageResource(R.drawable.dice_new1);

            }
        }, 2250);
        start.postDelayed(new Runnable() {
            @Override
            public void run() {

                    start.setVisibility(View.VISIBLE);
                    Animation anim=AnimationUtils.loadAnimation(getBaseContext(),R.anim.bounce);
                    MyBounceInterpolator interpolator=new MyBounceInterpolator(0.2,10);
                    anim.setInterpolator(interpolator);
                    start.startAnimation(anim);

            }
        }, 1000 * 2);
        exit.postDelayed(new Runnable() {
            @Override
            public void run() {

                exit.setVisibility(View.VISIBLE);
                Animation anim1=AnimationUtils.loadAnimation(getBaseContext(),R.anim.bounce);
                MyBounceInterpolator interpolator1=new MyBounceInterpolator(0.2,10);
                anim1.setInterpolator(interpolator1);
                exit.startAnimation(anim1);

            }
        }, 1000 * 2);

        /*Animation anim=AnimationUtils.loadAnimation(this,R.anim.bounce);
        MyBounceInterpolator interpolator=new MyBounceInterpolator(0.2,20);
        anim.setInterpolator(interpolator);
        start.startAnimation(anim);

        Animation anim1=AnimationUtils.loadAnimation(this,R.anim.bounce);
        MyBounceInterpolator interpolator1=new MyBounceInterpolator(0.2,20);
        anim1.setInterpolator(interpolator1);
        exit.startAnimation(anim1);*/

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //didTapStartbtn();
                swapfragment();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });



    }
    /*public void didTapStartbtn()
    {

        Animation anim=AnimationUtils.loadAnimation(this,R.anim.bounce);

        MyBounceInterpolator interpolator=new MyBounceInterpolator(0.2,20);
        anim.setInterpolator(interpolator);

        start.startAnimation(anim);
    }

    public void didTapStoptbtn()
    {

        Animation anim1=AnimationUtils.loadAnimation(this,R.anim.bounce);

        MyBounceInterpolator interpolator=new MyBounceInterpolator(0.2,20);
        anim1.setInterpolator(interpolator);

        exit.startAnimation(anim1);
    }*/

    @Override
    public void onPage1Interaction(Uri uri) {

    }
    public void swapfragment()
    {
        start.clearAnimation();
        exit.clearAnimation();
        start.setVisibility(View.INVISIBLE);
        exit.setVisibility(View.INVISIBLE);
        FragmentManager manager=getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.container);
        if(fragment==null)
        {
            fragment=new Page1();
            manager.beginTransaction().add(R.id.container,fragment).commit();
        }
    }
}
