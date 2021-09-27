package com.john.mrclean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class History2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);

        getSupportActionBar().hide();

    }
    public void button2(View v) {
        Intent next_to_sendEmail = new Intent(this, Send_Email.class);
        startActivity(next_to_sendEmail);
    }
    public void logo2(View v) {
        Intent next_to_logo2 = new Intent(this, Home.class);
        startActivity(next_to_logo2);
    }
}