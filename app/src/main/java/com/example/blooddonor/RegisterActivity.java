package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button submit;
    private EditText Username,Password,MobileNo,District;
    private DbHandler handler=new DbHandler(this,"dnrdb",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        submit=findViewById((R.id.button3));
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MobileNo = findViewById(R.id.editTextPhone);
                Username = findViewById(R.id.editTextTextPersonName2);
                District = findViewById(R.id.editTextTextPostalAddress);
                Password = findViewById(R.id.editTextTextPassword2);
                int flag = 0;
                if (MobileNo.getText().toString().equals("")) {
                    flag = 1;
                    Toast.makeText(RegisterActivity.this, "ENTER MOBILE NUMBER", Toast.LENGTH_SHORT).show();
                }
                if (Username.getText().toString().equals("") && flag == 0) {
                    flag = 1;
                    Toast.makeText(RegisterActivity.this, "ENTER DISTRICT NAME", Toast.LENGTH_SHORT).show();
                }
                if (Username.getText().toString().equals("") && flag == 0) {
                    flag = 1;
                    Toast.makeText(RegisterActivity.this, "ENTER USERNAME", Toast.LENGTH_SHORT).show();
                }
                if (Password.getText().toString().equals("") && flag == 0) {
                    flag = 1;
                    Toast.makeText(RegisterActivity.this, "SET PASSWORD", Toast.LENGTH_SHORT).show();
                }
                if(Password.getText().toString().length()<6 && flag==0)
                {
                    flag=1;
                    Toast.makeText(RegisterActivity.this, "Minimum Password Length is 6", Toast.LENGTH_SHORT).show();
                }
                if(handler.GetDonor(Username.getText().toString())==0 && flag==0)
                {
                    flag=1;
                    Toast.makeText(RegisterActivity.this, "Username Already Exist", Toast.LENGTH_SHORT).show();
                }


                if (flag == 0) {
                    handler.RegisterDonor(new Donor(MobileNo.getText().toString(), District.getText().toString(), Username.getText().toString(), Password.getText().toString()));
                    handler.GetDonor(Username.getText().toString());
                    OpenMainActivity(view);
                }
            }
        });

    }
    public void OpenMainActivity(View view)
    {
        Intent intent=new Intent(this, first_page.class);
        startActivity(intent);
    }
}