package com.example.threadbasic;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    Button button;
    RotatorThread rotator;

    public static final int ACTION_SET = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotator.setStop();
            }
        });

        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                //super.handleMessage(msg);

                switch(msg.what){
                    case ACTION_SET :
                        float curRot = seekBar.getRotation();
                        seekBar.setRotation(curRot+6);
                        break;
                }
            }
        };

        rotator = new RotatorThread(handler);

        rotator.start();

        //seekbar를 변경하는 Handler 작성

    }

    public void onStopit(){
        rotator.setStop();
    }
}
