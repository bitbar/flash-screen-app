package com.bitbar.testdroid.monitor.flash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.Timer;
import java.util.TimerTask;

public class FlashActivity extends Activity {

    private static final Long FLASH_PERIOD = 500L;

    protected LayoutInflater mInflater;

    private boolean flash;

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = mInflater.inflate(com.bitbar.testdroid.monitor.flash.R.layout.flash, null);
        setContentView(view);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        toggleBackgroundColor();
                    }

                });
            }
        }, 0, FLASH_PERIOD);

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void toggleBackgroundColor() {
        if (flash) {
            view.setBackgroundColor(Color.RED);
        } else {
            view.setBackgroundColor(Color.YELLOW);
        }
        flash = !flash;
    }
}
