package com.example.harulg_hell.bap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.harulg_hell.bap.util.userDTO;

public class LoadActivity extends Activity {

    public static userDTO session;
    private boolean isSuccess = false;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LoadActivity.this, LoginActivity.class);
                Intent ii = new Intent(LoadActivity.this, MainActivity.class);
                if(!isSuccess) startActivity(i);
                else startActivity(ii);
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        }, 3000); // 3초 후에 hd Handler 실행

    }
 }
