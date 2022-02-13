package com.example.blooddonor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHandler extends SQLiteOpenHelper{

    public DbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create="CREATE TABLE RegisteredDonors ( MobileNum TEXT, DistrictName TEXT, Username TEXT PRIMARY KEY,Password TEXT)";
        String create_2 = "CREATE TABLE HospitalsRegisterd(Username TEXT PRIMARY KEY, MobileNum TEXT, DistrictName TEXT, bloodGrp TEXT, hospitalName TEXT)";
        db.execSQL(create);
        db.execSQL(create_2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String drop=String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop,new String[]{"RegisteredDonors"});
        onCreate(db);

        String drop_2=String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop_2,new String[]{"HospitalsRegistered"});
        onCreate(db);
    }
    public void RegisterDonor(Donor dnr)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("MobileNum",dnr.getMobileNum());
        values.put("DistrictName",dnr.getDistrictName());
        values.put("Username",dnr.getUserName());
        values.put("Password",dnr.getPassword());
        long k=db.insert("RegisteredDonors",null,values);
        Log.d("mytag",Long.toString(k));
        db.close();
    }

    // Adding the Donate Blood registered user here
    public void HospitalsRegistered(String Mobilenum, String Username, String BloodGrp, String HospitalName)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("MobileNum", Mobilenum);
        values.put("Username",Username);
        values.put("BloodGrp", BloodGrp);
        values.put("Hospitals", HospitalName);
        long k=db.insert("HospitalsRegistered",null,values);
        Log.d("mytag",Long.toString(k));
        db.close();
    }

    public int GetDonor(String Username)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("RegisteredDonors",new String[]{"MobileNum","DistrictName","Username","Password"},"Username=?",new String[]{Username},null,null,null);

        if(cursor!=null && cursor.moveToFirst())
        {
            Log.d("mytag",cursor.getString(0));
            Log.d("mytag",cursor.getString(1));
            Log.d("mytag",cursor.getString(2));
            Log.d("mytag",cursor.getString(3));
            db.close();
            return 0;
        }
        else {
            Log.d("mytag", "Some Error Occured");
            db.close();
            return 1;
        }
    }

    public int GetDonor_2(String Username)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor_2=db.query("HospitalsRegistered",new String[]{"MobileNum","BloodGrp","Username","HospitalName"},"Username=?",new String[]{Username},null,null,null);

        if(cursor_2!=null && cursor_2.moveToFirst())
        {
            Log.d("mytag",cursor_2.getString(0));
            Log.d("mytag",cursor_2.getString(1));
            Log.d("mytag",cursor_2.getString(2));
            Log.d("mytag",cursor_2.getString(3));
            db.close();
            return 0;
        }
        else {
            Log.d("mytag", "Some Error Occured");
            db.close();
            return 1;
        }
    }

    public String GetPassword(String Username)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("RegisteredDonors",new String[]{"MobileNum","DistrictName","Username","Password"},"Username=?",new String[]{Username},null,null,null);
        if(cursor!=null && cursor.moveToFirst())
        {
            return cursor.getString(3);

        }
        else
        {
            Log.d("mytag", "Some Error Occured");
            return "";
        }

    }
}
