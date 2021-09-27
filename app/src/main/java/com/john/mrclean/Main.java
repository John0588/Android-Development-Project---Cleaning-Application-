package com.john.mrclean;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;


public class Main extends AppCompatActivity {

    Button sign_In, sign_Up;
    ImageView logo;
    View night, day;
    Switch switchMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        logo = findViewById(R.id.logo1);
        night = findViewById(R.id.night_bg);
        day = findViewById(R.id.day_bg);
        sign_In = findViewById(R.id.main_signIn);
        sign_Up = findViewById(R.id.main_signUp);
        switchMode = findViewById(R.id.day_night_switch);

    }
    public void sign_in(View v) {
        Intent next_to_signIn = new Intent(this,SignIn.class);
        startActivity(next_to_signIn);
    }
    public void sign_up(View v) {
        Intent next_to_signUp = new Intent(this,SignUp.class);
        startActivity(next_to_signUp);
    }

}