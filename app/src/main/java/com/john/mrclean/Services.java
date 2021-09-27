package com.john.mrclean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class Services extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        getSupportActionBar().hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulist1, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.homeBooking:
                Intent home = new Intent(this, Home.class);
                startActivity(home);
                return true;

            case R.id.homeServices:
                Intent services = new Intent(this, Services.class);
                startActivity(services);
                return true;

            case R.id.homeNotifications:
                Intent notifications = new Intent(this, Notification.class);
                startActivity(notifications);
                return true;

            case R.id.homeHistory:
                Intent history = new Intent(this, History.class);
                startActivity(history);
                return true;

            case R.id.home_LogOut:
                Intent logout = new Intent(this, SignIn.class);
                startActivity(logout);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}