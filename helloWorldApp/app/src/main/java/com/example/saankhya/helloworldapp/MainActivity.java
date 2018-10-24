package com.example.saankhya.helloworldapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login, Register;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);
        Register = (Button) findViewById(R.id.etRegister);

        Info.setText("No of attempts remaining: " + String.valueOf(counter));

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regAct = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(regAct);
            }
        });

    }

    private void validate(String userName, String userPassword) {
//        String uName = "bhargavi", uPwd = "1234";

        DataBaseHelper db = new DataBaseHelper(this);
        List<Contact> contacts = db.getAllContacts();

        for (Contact c : contacts) {
            String log = "ID: " + c.getId() + "Name: " + c.getName() + "Password: " + c.getPassword()
                    + "MailID: " + c.getEmailId() + "PhoneNum: " + c.getMblNumber();

            if ((userName.equals(c.getName()) && (userPassword.equals(c.getPassword())))) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                counter = 5;
                Info.setText("No of attempts remaining:" + (String.valueOf(counter)));
            }
//            if ((userName.equals(uName)) && (userPassword.equals(uPwd))) {
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(intent);
//                counter = 5;
//                Info.setText("No of attempts remaining:" + (String.valueOf(counter)));
//            }
            else {
                counter--;
                Info.setText("Incorrect Username/password\nNo of attempts remaining:" + (String.valueOf(counter)));
                //Info.setText("Incorrect Username/password");
                if (counter == 0) {
                    Login.setEnabled(false);
                    Info.setText("No of attempts remaining:" + (String.valueOf(counter) + "\n" + "No more chance to login"));
                }
            }
        }
    }
}

