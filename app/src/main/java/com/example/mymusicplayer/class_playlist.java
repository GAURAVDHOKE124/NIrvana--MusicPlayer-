package com.example.mymusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class class_playlist extends AppCompatActivity {

    ListView listView;
    String[] playlist = {"Man Mandira - Shankar Mahadevan", "Radhadhar Madhu Milind - Rahul Deshpande"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_playlist);

        listView = findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.list_item, R.id.text_view_item, playlist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSong = playlist[position];
                Intent intent;

                if (selectedSong.equals("Man Mandira - Shankar Mahadevan")) {
                    intent = new Intent(class_playlist.this, classclass1.class);
                } else if (selectedSong.equals("Radhadhar Madhu Milind - Rahul Deshpande")) {
                    intent = new Intent(class_playlist.this, classclass2.class);
                } else {
                    intent = new Intent(class_playlist.this, classclass1.class);
                }

                intent.putExtra("SONG_NAME", selectedSong);
                startActivity(intent);
            }
        });
    }
}
