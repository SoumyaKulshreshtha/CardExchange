package com.example.cardexchange;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //creating constant keys for shared prefrences.
    public static final String SHARED_PREFS = "shared_prefs";
    //key for storing email.
    public static final String EMAIL_KEY = "email_key";
    //key for storing password.
    public static final String PASSWORD_KEY = "password_key";
    //variable for shared prefrences.
    SharedPreferences sharedpreferences;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing our shared prefrences.
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        //getting data from shared prefs and storing it in our string variable.
        email = sharedpreferences.getString(EMAIL_KEY, null);
        //intializing our textview and button.
//        Toast.makeText(this, email+" Here", Toast.LENGTH_LONG).show();

        getSupportActionBar().hide();
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if(!email.equals("") || !email.equals(null)){
                    startActivity(new Intent(MainActivity.this, Dashboard.class));
                    finish();
                }
                else{
                    startActivity(new Intent(MainActivity.this, Register.class));
                    finish();
                }

            }
        }, secondsDelayed * 1000);
    }
}
