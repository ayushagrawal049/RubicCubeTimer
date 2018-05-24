package com.gmail.ayushagrawal049.rubic_cubetimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    TextView text1,text2;

    private static final String FORMAT = "%02d:%02d:%02d";
    private MediaPlayer mp;
    int seconds , minutes;

    TextView timer ;

    Button start,reset;
    long MillisecondTime, StartTime, TimeBuff,UpdateTime = 0L,ms ;
    Handler handler;
    int Seconds, Minutes, MilliSeconds;
    View o;
    int a=2;
    int l=1;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.ti);
        text2 = findViewById(R.id.i);
        mp = MediaPlayer.create(this, R.raw.beep);
        View view;



    }
    public void start(View view) {
        if (a==3){
            l=2;

        }
        if (a==1) {

            TimeBuff += MillisecondTime;

            handler.removeCallbacks(runnable);
        }

        if (a==2) {

            new CountDownTimer(15000, 10) {

                public void onTick(long millisUntilFinished) {
                    long e, d, c, p, b, q, w, z;
                    b = millisUntilFinished % 10;

                    c = (millisUntilFinished - b) % 100;

                    e = millisUntilFinished % 100;
                    d = (millisUntilFinished - e) % 1000;

                    q = millisUntilFinished / 1000;
                    w = q % 10;
                    z = millisUntilFinished / 10000;
                    a=3;



                    text1.setText("" + z + w + ":" + d / 100 + c / 10);
                    String alarm= text1.getText().toString();
                    String s1="03:00";

                    if (l==2) {
                        cancel();

                        display(o);
                    }
                    if (alarm.equals(s1
                    )){mp.start();

                    }

                }

                public void onFinish() {



                    display(o);
                }

            }.start();
        }

    }
    private void display(View view) {a=1;
        timer = (TextView) findViewById(R.id.ti);
        text2.setText("SOLVE TIME");
        handler = new Handler();


        StartTime = SystemClock.uptimeMillis();
        handler.postDelayed(runnable, 0);
    }





    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.uptimeMillis() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (UpdateTime % 1000);
            ms=MilliSeconds/10;

            timer.setText("" + String.format("%02d",minutes) + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%02d", ms));

            handler.postDelayed(this, 0);
        }

    };

}








