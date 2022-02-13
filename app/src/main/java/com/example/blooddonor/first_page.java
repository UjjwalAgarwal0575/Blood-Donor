package com.example.blooddonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class first_page extends AppCompatActivity {

    private Button SignIn;
    private EditText Username,Password;
    DbHandler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SignIn=findViewById(R.id.button2);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Username=findViewById(R.id.editTextTextPersonName);
                Password=findViewById(R.id.editTextTextPassword);
                handler=new DbHandler(first_page.this,"dnrdb",null,1);
                int flag=0;
                if(Username.getText().toString().equals("")) {
                    flag = 1;
                    Toast.makeText(first_page.this, "ENTER USERNAME", Toast.LENGTH_SHORT).show();
                }
                if(Password.getText().toString().equals(""))
                {
                    flag=1;
                    Toast.makeText(first_page.this, "ENTER PASSWORD", Toast.LENGTH_SHORT).show();
                }

                handler.GetDonor(Username.getText().toString());
                String pass=handler.GetPassword(Username.getText().toString());
//                String pass="";
                if(flag==0) {
                    if (pass.equals(Password.getText().toString()))
                        OpenMenu(view);
                    else
                        Toast.makeText(first_page.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void OpenRegisterActivity(View v)
    {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
    public void OpenMenu(View view)
    {
        Intent intent=new Intent(this,HomePage.class);
        startActivity(intent);
    }

}