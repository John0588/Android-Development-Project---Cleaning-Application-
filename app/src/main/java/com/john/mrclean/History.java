package com.john.mrclean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        getSupportActionBar().hide();
    }
    public void button(View v) {
        Intent next_to_history2 = new Intent(this, History2.class);
        startActivity(next_to_history2);
    }
    public void logo(View v) {
        Intent next_to_logo = new Intent(this, Home.class);
        startActivity(next_to_logo);
    }
}