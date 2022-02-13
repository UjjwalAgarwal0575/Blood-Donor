// Donate Blood Page

package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BloodDonor extends AppCompatActivity {

    private EditText BloodGrp;
    private EditText HospitalName;
    private EditText MobileNum;
    private EditText Username;
    private Button button;
    private DbHandler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_donor);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Username = findViewById(R.id.editTextTextPersonName);
                HospitalName = findViewById(R.id.editTextTextPersonName3);
                BloodGrp = findViewById(R.id.editTextTextPersonName4);
                MobileNum = findViewById(R.id.editTextNumber);

                handler = new DbHandler(BloodDonor.this, "dhrdb", null, 1);
                handler.HospitalsRegistered(MobileNum.getText().toString(), Username.getText().toString(), BloodGrp.getText().toString(), HospitalName.getText().toString());
                int flag = handler.GetDonor_2(Username.getText().toString());
                if (flag == 0){
                    Log.d("mytag", "overloaded");
                }
                else{
                    Log.d("erorr", "Not overloaded");
                }
            }
        });

    }



}