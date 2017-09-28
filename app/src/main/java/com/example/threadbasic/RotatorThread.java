package com.example.threadbasic;

import android.os.Handler;
import android.os.Message;

/**
 * Created by 정인섭 on 2017-09-28.
 */

public class RotatorThread extends Thread {
    Handler handler;
    boolean RUNNING = true;

    public RotatorThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {

        while(RUNNING){

            handler.sendEmptyMessage(MainActivity.ACTION_SET);
//            Message message = new Message();
//            message.what = MainActivity.ACTION_SET;
//            message.arg1 = i;
//            handler.sendMessage(message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // run 이외의 함수는 sub thread에서 실행되지 않는다.
    public void setStop(){
        RUNNING = false;
    }
}
