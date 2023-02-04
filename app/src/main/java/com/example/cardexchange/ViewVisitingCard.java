package com.example.cardexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class ViewVisitingCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_visiting_card);

        WebView webV = findViewById(R.id.CardView);
        webV.getSettings().setJavaScriptEnabled(true);
        webV.loadUrl("https://myhealth.wisetechsolution.in/UserDocs/Visiting_Card.jpeg");

    }
}