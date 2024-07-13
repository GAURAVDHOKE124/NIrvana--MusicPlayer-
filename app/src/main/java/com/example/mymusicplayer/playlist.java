package com.example.mymusicplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class playlist extends AppCompatActivity {

    private Button classical;
    private Button  hiphop;
    private Button kpop;
    private Button love;
    private Button chill;
    private Button sleep;
    private Button travelling;
    private Button instrumental;
    public static final String SHARED_PREFS = "sharedPrefs";


    private Button out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.playlist);
        classical =findViewById(R.id.classical);
        hiphop = findViewById(R.id.hiphop);
        kpop = findViewById(R.id.kpop);
        love = findViewById(R.id.love);
        chill = findViewById(R.id.chill);
        sleep = findViewById(R.id.sleep);
        out = findViewById(R.id.out);
        travelling = findViewById(R.id.travelling);
        instrumental = findViewById(R.id.instrumental);

        classical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(playlist.this, class_playlist.class);
                startActivity(intent);
            }
        });


        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name","");
                editor.apply();
                Intent intent = new Intent(playlist.this,MainActivity.class);
                startActivity(intent);
            }
        });
        classical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(playlist.this, class_playlist.class);
                startActivity(intent);
            }
        });
        hiphop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(playlist.this, hip_playlist.class);
                startActivity(intent);
            }
        });
        kpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(playlist.this, kpop_playlist.class);
                startActivity(intent);
            }
        });
        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(playlist.this, love_playlist.class);
                startActivity(intent);
            }
        });
        chill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(playlist.this, chill_playlist.class);
                startActivity(intent);
            }
        });
        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(playlist.this, sleep_playlist.class);
                startActivity(intent);
            }
        });
        travelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(playlist.this, tra_playlist.class);
                startActivity(intent);
            }
        });
        instrumental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(playlist.this, inst_playlist.class);
                startActivity(intent);
            }
        });
    }
}
