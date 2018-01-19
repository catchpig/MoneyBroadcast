package com.zhuazhu.voice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zhuazhu.voice.VoicePlay;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VoicePlay.with(this).play("56.23");
        VoicePlay.with(this).playSuccess();
        VoicePlay.with(this).playSuccess();
    }
}
