package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class UrgentNeed extends AppCompatActivity {

    // Fill this string arr with details of user
    ListView listView;
    private DbHandler handler = new DbHandler(this, "dhrb", null, 1);
    private ImageButton post;
    private String Username,Password,MobileNo,District;

    String[] arr = {"User details", "User details", "User details", "User details", "User details", "User details", "User details", "User details", "User details", "User details" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_need);

        listView = findViewById(R.id.list);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        listView.setAdapter(ad);
    }

    public void PostAnnouncementPage(View view) {
        Toast.makeText(this, "Urgent appeal for blood", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Announce.class);
        startActivity(intent);
    }
}