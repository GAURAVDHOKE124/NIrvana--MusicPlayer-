package com.example.mymusicplayer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    UserDatabaseManager dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbhelper =  new UserDatabaseManager(this);
        dbhelper.open();
        EditText e1 = findViewById(R.id.username);
        EditText e2 = findViewById(R.id.name);
        EditText e3 = findViewById(R.id.email);
        EditText e4 = findViewById(R.id.password);
        EditText e5 = findViewById(R.id.cpassword);
        RadioGroup rg = findViewById(R.id.rg);
        Button b1 = findViewById(R.id.register);
        TextView t1 = findViewById(R.id.t1);

        CheckBox ch = findViewById(R.id.ch);

        b1.setOnClickListener(v->{
            String s1 = e1.getText().toString();
            String s2 = e2.getText().toString();
            String s3 = e3.getText().toString();
            String s4 = e4.getText().toString();
            String s5 = e5.getText().toString();

            RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
            String s6 = rb.getText().toString();


            if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty()){
                if(ch.isChecked()) {
                    Toast.makeText(this, "Fill all details !!!", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                if(s4.equals(s5)){
                    if(ch.isChecked()) {
                        dbhelper.insertUser(s1,s2, s3, s4, s6);
                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(this,"Please Agree all terms and Conditions !!!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(this,"Password and Confirm password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        t1.setOnClickListener(v->{
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
        });

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        dbhelper.close();
    }

}