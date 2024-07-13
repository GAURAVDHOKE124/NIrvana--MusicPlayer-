package com.example.mymusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class hip_playlist extends AppCompatActivity {

    ListView listView;
    String[] playlist = {"One Love - Shubh","Ganstas's paradise - Coolio, L.V.",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hip_playlist);

        listView = findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.list_item, R.id.text_view_item, playlist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSong = playlist[position];
                Intent intent;

                if (selectedSong.equals("One Love - Shubh")) {
                    intent = new Intent(hip_playlist.this, hipclass1.class);
                } else if (selectedSong.equals("Ganstas's paradise - Coolio, L.V.")) {
                    intent = new Intent(hip_playlist.this, hipclass2.class);
                } else {
                    intent = new Intent(hip_playlist.this, hipclass1.class);
                }

                startActivity(intent);
            }
        });
    }
}
