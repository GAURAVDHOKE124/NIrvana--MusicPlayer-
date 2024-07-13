package com.example.mymusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class chill_playlist extends AppCompatActivity {

    ListView listView;
    String[] playlist = {"Together - Funky Fella", "Gold - Rooftop Shenanigans"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chill_playlist);

        listView = findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.list_item, R.id.text_view_item, playlist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSong = playlist[position];
                Intent intent;

                if (selectedSong.equals("Together - Funky Fella")) {
                    intent = new Intent(chill_playlist.this, chillclass1.class);
                } else if (selectedSong.equals("Gold - Rooftop Shenanigans")) {
                    intent = new Intent(chill_playlist.this, chillclass2.class);
                } else {
                    intent = new Intent(chill_playlist.this, chillclass1.class);
                }

                intent.putExtra("SONG_NAME", selectedSong);
                startActivity(intent);
            }
        });
    }
}
