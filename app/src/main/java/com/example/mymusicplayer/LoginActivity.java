package com.example.mymusicplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private UserDatabaseManager dbhelper;
    public static final String SHARED_PREFS = "sharedPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbhelper =  new UserDatabaseManager(this);
        dbhelper.open();

        checkbox();


        TextView t1 = findViewById(R.id.t1);
        Button login = findViewById(R.id.login);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);

        t1.setOnClickListener(v->{
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
        });


        login.setOnClickListener(v->{
            String usernameText = usernameEditText.getText().toString();
            String passwordText = passwordEditText.getText().toString();
            String dbpassword=dbhelper.getPassword(usernameText);
            if(passwordText.equals(dbpassword)){
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name","true");
                editor.apply();

                Toast.makeText(this,"login successfull",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LoginActivity.this, playlist.class);
                startActivity(i);
            }
            else{
                Intent i = new Intent(LoginActivity.this, LoginActivity.class);
                startActivity(i);
                {
                }
            }
        });
    }

    private void checkbox() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String check = sharedPreferences.getString("name","");
        if(check.equals("true")){
            Toast.makeText(this,"login successfull",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(LoginActivity.this, playlist.class);
            startActivity(i);
            finish();
        }

        }

    }

