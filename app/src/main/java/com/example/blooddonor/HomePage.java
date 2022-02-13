package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void DonateBloodPage(View view){
        Toast.makeText(this, "Donate Blood", Toast.LENGTH_SHORT).show();
        // Take some data from this page to the specified page
        Intent intent = new Intent(this, BloodDonor.class);
        //    name = findViewById(R.id.);
        startActivity(intent);
    }

    public void SearchForBloodPage(View view){
        Toast.makeText(this, "Search For Blood Donors Near you", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, NeedBlood.class);

        startActivity(intent);
    }

    public void UrgentNeedPage(View view){
        Toast.makeText(this, "Urgent Need", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, UrgentNeed.class);

        startActivity(intent);
    }

}

