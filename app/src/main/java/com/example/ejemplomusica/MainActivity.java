//By: Jose Eder Martinez Martinez


package com.example.ejemplomusica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bPlay, bStop, bExit;
    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        bPlay = (Button) findViewById(R.id.button);
        bStop = (Button) findViewById(R.id.button2);
        bExit = (Button) findViewById(R.id.button3);
        bPlay.setEnabled(true);
        bStop.setEnabled(false);
        bExit.setEnabled(true);

        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bPlay.setEnabled(false);
                bStop.setEnabled(true);
                bExit.setEnabled(false);
                mp = MediaPlayer.create(getApplicationContext(),R.raw.crazylittle);
                mp.start();
            }
        });
        bStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bPlay.setEnabled(true);
                bStop.setEnabled(false);
                bExit.setEnabled(true);
                mp.stop();
            }
        });
        bExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Nos vemos pronto",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}