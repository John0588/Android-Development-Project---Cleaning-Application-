package com.john.mrclean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        signOut = findViewById(R.id.home_LogOut);

        getSupportActionBar().hide();
    }
    public void home_logout(View v) {
        Intent next_to_signIn = new Intent(this, Main.class);
        startActivity(next_to_signIn);
    }
    public void home_booking(View v) {
        Intent next_to_booking = new Intent(this, Booking.class);
        startActivity(next_to_booking);
    }

    public void home_notifications(View v) {
        Intent next_to_notifications = new Intent(this, Notification.class);
        startActivity(next_to_notifications);
    }
    public void home_history(View v) {
        Intent next_to_history = new Intent(this, History.class);
        startActivity(next_to_history);
    }
    public void home_services(View v) {
        Intent next_to_services = new Intent(this, Services.class);
        startActivity(next_to_services);
    }
}