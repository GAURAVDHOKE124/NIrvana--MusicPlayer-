package com.example.mymusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class sleep_playlist extends AppCompatActivity {

    ListView listView;
    String[] playlist = {"Imagination - Nova Issue","Serene Reflections - Eternalistic"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep_playlist);

        listView = findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.list_item, R.id.text_view_item, playlist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSong = playlist[position];
                Intent intent;

                if (selectedSong.equals("Imagination - Nova Issue")) {
                    intent = new Intent(sleep_playlist.this, sleepclass1.class);
                } else if (selectedSong.equals("Serene Reflections - Eternalistic")) {
                    intent = new Intent(sleep_playlist.this, sleepclass2.class);
                } else {
                    intent = new Intent(sleep_playlist.this, sleepclass1.class);
                }

                intent.putExtra("SONG_NAME", selectedSong);
                startActivity(intent);
            }
        });
    }
}
