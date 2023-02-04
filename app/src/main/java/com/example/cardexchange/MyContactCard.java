package com.example.cardexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.scheme.VCard;

public class MyContactCard extends AppCompatActivity {

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
        setContentView(R.layout.home);

        //initializing our shared prefrences.
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        //getting data from shared prefs and storing it in our string variable.
        email = sharedpreferences.getString(EMAIL_KEY, null);
        //intializing our textview and button.

        ImageView imageView= (ImageView)findViewById(R.id.imageView);
        TextView getVisitingCard = findViewById(R.id.visitingCard);
        TextView Welcome = findViewById(R.id.welcome);
        final DownloadManager[] manager = new DownloadManager[1];


        //Welcome.setText("Welcome "+email);
        if(email.equals("") || email.equals(null)){
            startActivity(new Intent(MyContactCard.this, GenerateContactCard.class));
            finish();
        }
        else{
            VCard vCard=new VCard();
            vCard.setName("Soumya Kulshreshtha");
            vCard.setCompany("Freelancer");
            vCard.setEmail("soumyakulshreshtha259@gmail.com");
            vCard.setPhoneNumber("+91 9630397705");
            vCard.setTitle("Developer");
            vCard.setWebsite("https://wisetechsolution.in/");
            imageView.setImageBitmap(QRCode.from(vCard.generateString()).bitmap());

        }

        //get intent data
        Intent genQR = getIntent();


        getVisitingCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {

                startActivity(new Intent(MyContactCard.this, DownloadBusinessCard.class));
                finish();
            }

        });

    }
}