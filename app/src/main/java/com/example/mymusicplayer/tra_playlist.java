package com.example.mymusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class tra_playlist extends AppCompatActivity {

    ListView listView;
    String[] playlist = {"Sooraj Ki Baahon Mein - Dominique Cerejo", "Phir Se Ud Chala - Mohit Chauhan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tra_playlist);

        listView = findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.list_item, R.id.text_view_item, playlist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSong = playlist[position];
                Intent intent;

                if (selectedSong.equals("Sooraj Ki Baahon Mein - Dominique Cerejo")) {
                    intent = new Intent(tra_playlist.this, traclass1.class);
                } else if (selectedSong.equals("Phir Se Ud Chala - Mohit Chauhan")) {
                    intent = new Intent(tra_playlist.this, traclass2.class);
                } else {
                    intent = new Intent(tra_playlist.this, traclass1.class);
                }

                intent.putExtra("SONG_NAME", selectedSong);
                startActivity(intent);
            }
        });
    }
}
