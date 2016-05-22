package com.example.mohit.gesturecontrol;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv,x1t,x2t,y1t,y2t;
    float x1 = 0,x2 = 0,y1 = 0,y2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        x1t = (TextView) findViewById(R.id.textView2);
        y1t = (TextView) findViewById(R.id.textView3);
        x2t = (TextView) findViewById(R.id.textView4);
        y2t = (TextView) findViewById(R.id.textView5);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        int action = MotionEventCompat.getActionMasked(event);

        switch (action){
            case MotionEvent.ACTION_UP :
                x2 =  event.getX();
                x2t.setText(String.valueOf(x2));
                y2 = event.getY();
                y2t.setText(String.valueOf(y2));
                getDirection(x1,x2,y1,y2);
                break;
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                x1t.setText(String.valueOf(x1));
                y1 = event.getY();
                y1t.setText(String.valueOf(y1));
                break;
        }



        return true;
    }

    public void getDirection(float x1,float x2, float y1, float y2){
        float dx = x2 - x1;
        float dy = y2 - y1;

        Toast.makeText(getBaseContext(),dx + " " + dy,Toast.LENGTH_SHORT).show();

        if(Math.abs(dx) > Math.abs(dy)){
            if(dx > 0){
                tv.setText("Right");
            }
            else {
                tv.setText("Left");
            }
        }
        else {
            if(dy > 0){
                tv.setText("Down");
            }
            else {
                tv.setText("up");
            }
        }
    }
}
