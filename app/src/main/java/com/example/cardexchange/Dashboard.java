package com.example.cardexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ImageView contactQR,myProfile,myCards,downloadQR;
        TextView welcomeDashboard;

        contactQR = findViewById(R.id.contactQR);
        myProfile = findViewById(R.id.myProfile);
        myCards = findViewById(R.id.myCards);
        downloadQR = findViewById(R.id.downloadQR);
        welcomeDashboard = findViewById(R.id.WelcomeText);

        welcomeDashboard.setText("Welcome!");

        contactQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, MyContactCard.class));
//                finish();
            }
        });

        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Register.class));
//                finish();
            }
        });

        myCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, BusinessCards.class));
//                finish();
            }
        });

        downloadQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, DownloadBusinessCard.class));
//                finish();
            }
        });


    }
}