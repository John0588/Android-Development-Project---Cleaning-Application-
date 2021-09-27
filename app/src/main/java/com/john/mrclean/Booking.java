package com.john.mrclean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class Booking extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView mySearchView;
    ListView myList;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    private final String[] stateList = {"TORONTO", "BRAMPTON", "MISSISSAUGA", "SCARBOROUGH", "NIAGARA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        mySearchView = findViewById(R.id.bookingFindCity);
        myList = findViewById(R.id.scrollView);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stateList);
        myList.setAdapter(adapter);
        myList.setTextFilterEnabled(true);

        mySearchView.setIconifiedByDefault(false);
        mySearchView.setOnQueryTextListener(this);


        mySearchView.setQueryHint("State Name");

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stateList = myList.getAdapter().getItem(position).toString();

                Intent toronto = new Intent(Booking.this, Toronto.class);
                toronto.putExtra("selectedList", stateList);
                startActivity(toronto);
            }
        });
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        android.widget.Filter filter = adapter.getFilter();
        if (TextUtils.isEmpty(newText)) {
            filter.filter("");
        } else {
            filter.filter(newText);
        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulist1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

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

            case R.id.send_email:
                Intent email = new Intent(this, Send_Email.class);
                startActivity(email);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
