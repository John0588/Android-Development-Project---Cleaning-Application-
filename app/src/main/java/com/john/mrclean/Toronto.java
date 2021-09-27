package com.john.mrclean;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Toronto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toronto);
    }

    public void cleaners1(View v) {
        Intent next_to_one = new Intent(this,Profile_Cleaners.class);
        startActivity(next_to_one);
    }
}