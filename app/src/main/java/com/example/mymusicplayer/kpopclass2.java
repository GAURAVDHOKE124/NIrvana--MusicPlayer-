package com.example.mymusicplayer;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class kpopclass2 extends AppCompatActivity {



    private Button button, btnPause, btnRewind;
    private SeekBar seekBar;
    private TextView tvTime;
    private Button backbutton;
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    private Runnable updateSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kpopclass2);

        button = findViewById(R.id.button);
        btnPause = findViewById(R.id.btnPause);
        btnRewind = findViewById(R.id.btnRewind);
        backbutton = findViewById(R.id.backbutton);
        seekBar = findViewById(R.id.seekBar);
        tvTime = findViewById(R.id.tvTime);

        mediaPlayer = MediaPlayer.create(this, R.raw.anime2); // Add your audio file to res/raw
        seekBar.setMax(mediaPlayer.getDuration());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                handler.post(updateSeekBar);
            }
        });
        backbutton.setOnClickListener(v -> {
            Intent back = new Intent(kpopclass2.this,kpop_playlist.class);
            startActivity(back);
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                handler.removeCallbacks(updateSeekBar);
            }
        });

        btnRewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(0);
                seekBar.setProgress(0);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
                updateTimeText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        updateSeekBar = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                updateTimeText();
                handler.postDelayed(this, 1000);
            }
        };
    }

    private void updateTimeText() {
        int currentPosition = mediaPlayer.getCurrentPosition();
        int minutes = (currentPosition / 1000) / 60;
        int seconds = (currentPosition / 1000) % 60;
        tvTime.setText(String.format("%02d:%02d", minutes, seconds));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        handler.removeCallbacks(updateSeekBar);

    }
}