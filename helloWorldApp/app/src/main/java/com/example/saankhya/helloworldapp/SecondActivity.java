package com.example.saankhya.helloworldapp;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView sysInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sysInfo = (TextView)findViewById(R.id.etSysInfo);

        String mblInfo = "";
        mblInfo = mblInfo + "SERIAL: " +Build.SERIAL + "\n";
        mblInfo = mblInfo + "Model: " +Build.MODEL + "\n";
        mblInfo = mblInfo + "ID: " +Build.ID + "\n";
        mblInfo = mblInfo + "Manufacturer: " +Build.MANUFACTURER + "\n";
        mblInfo = mblInfo + "Brand: " +Build.BRAND + "\n";
        mblInfo = mblInfo + "Board: " +Build.BOARD + "\n";
        mblInfo = mblInfo + "Version: " +Build.VERSION.RELEASE + "\n";
        mblInfo = mblInfo + "Device: " +Build.DEVICE + "\n";
        mblInfo = mblInfo + ":" +Build.HARDWARE + "\n";

        Toast.makeText(SecondActivity.this,"successfull Login\n", Toast.LENGTH_SHORT).show();

        sysInfo.setText(mblInfo);

    }
}
