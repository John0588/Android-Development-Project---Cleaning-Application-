package com.john.mrclean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Profile_Cleaners extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__cleaners);

        getSupportActionBar().hide();
    }
    public void send_email(View v) {
        Intent next_to_one = new Intent(this,Send_Email.class);
        startActivity(next_to_one);
    }

    public void call2(View v) {
        Intent call2 = new Intent(Intent.ACTION_DIAL);
        call2.setData(Uri.parse("tel:1 647 527 3943"));
        startActivity(call2);
    }
}