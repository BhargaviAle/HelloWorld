package com.example.saankhya.helloworldapp;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private EditText UserName;
    private EditText NewPassword;
    private EditText ReEnteredPassword;
    private Button CreatAccount;
    private EditText Email;
    private EditText MblNum;
    private TextView RegStatus;
    static int CreateDB = 0;

    String text = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        UserName = (EditText) findViewById(R.id.etRegName);
        NewPassword = (EditText) findViewById(R.id.etNewPwd);
        ReEnteredPassword = (EditText) findViewById(R.id.etReEnterPwd);
        Email = (EditText) findViewById(R.id.etEmail);
        MblNum = (EditText) findViewById(R.id.etPhoneNum);
        CreatAccount = (Button) findViewById(R.id.etCreateAcnt);
        RegStatus = (TextView) findViewById(R.id.etRegStatus);

        CreatAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDeatails();
            }
        });
    }
    private void checkDeatails()
    {
        String Uname = UserName.getText().toString();
        String Upwd = NewPassword.getText().toString();
        String ReEnterPwd = ReEnteredPassword.getText().toString();
        String email = Email.getText().toString();
        String PhoneNum = MblNum.getText().toString();

        if((Uname.isEmpty()) && (Upwd.isEmpty()) && (ReEnterPwd.isEmpty()) && (email.isEmpty()) && (PhoneNum.isEmpty())){
//            RegStatus.setText("Please enter correct details\n");
            Toast.makeText(RegisterActivity.this,"please enter correct details\n", Toast.LENGTH_SHORT).show();
        }
        else{
//            boolean ret = Pattern.matches("[a-zA-Z]+", Uname);
            if(!Pattern.matches("[a-zA-Z]+", Uname))
            {
                Toast.makeText(RegisterActivity.this, "Name should contain only alphabets", Toast.LENGTH_SHORT).show();
                return;
            }
            if(!Pattern.matches("[0-9]+", PhoneNum)) {
                Toast.makeText(RegisterActivity.this, "please enter valid mobile number", Toast.LENGTH_SHORT).show();
                return;
            }
            if(PhoneNum.length() != 10) {
                Toast.makeText(RegisterActivity.this, "please enter valid mobile number", Toast.LENGTH_SHORT).show();
                return;
            }
            if(!Pattern.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+", email))
            {
                Toast.makeText(RegisterActivity.this, "Enter valid mailId", Toast.LENGTH_SHORT).show();
                return;
            }

            if(Upwd.equals(ReEnterPwd)) {
                Intent regStatus = new Intent(RegisterActivity.this, RegisterStatus.class);
                startActivity(regStatus);

                DataBaseHelper db = new DataBaseHelper(this);


                //inserting contacts
                db.addContact(new Contact(1, "bhargavi", "1234", "alebhargavi7@gmail.com", "1234567890"));
                db.addContact(new Contact(2,"sai", "2345", "alesai@gmail.com", "2345678901"));
                db.addContact(new Contact(3, "srikanth", "3456", "alesri@g,ail.com", "3456789012"));
                Toast.makeText(RegisterActivity.this,"Successfully Registered", Toast.LENGTH_SHORT).show();
                //reading and diplaying all contacts
                List<Contact> contacts = db.getAllContacts();

                for(Contact c : contacts){
                    String log = "ID: " + c.getId() + " Name: " + c.getName() + " Password: " + c.getPassword()
                            + " MailID: " + c.getEmailId() + " PhoneNum: " + c.getMblNumber();

                    text = text + log;
                    System.out.println(text);
                }
                db.close();
            }
            else {
                Toast.makeText(RegisterActivity.this,"Please enter correct password\n", Toast.LENGTH_SHORT).show();
//                RegStatus.setText("Please enter correct password\n");
            }
        }
    }



}
