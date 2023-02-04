package com.example.cardexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class GenerateContactCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_contact_card);

        EditText GenName, GenEmail, GenContact, GenCompany, GenWebsite, GenDesignation;
        GenName = findViewById(R.id.cardGenName);
        GenEmail = findViewById(R.id.cardGenEmail);
        GenContact = findViewById(R.id.cardGenMobile);
        GenCompany = findViewById(R.id.cardGenCompany);
        GenWebsite = findViewById(R.id.cardGenWebsite);
        GenDesignation = findViewById(R.id.cardGenTitle);

        String name  = GenName.getText().toString();
        String mail  = GenEmail.getText().toString();
        String contact  = GenContact.getText().toString();
        String company  = GenCompany.getText().toString();
        String website  = GenWebsite.getText().toString();
        String designation  = GenDesignation.getText().toString();

        Intent genQR = new Intent(this, MyContactCard.class);
        genQR.putExtra("GenName", name);
        genQR.putExtra("GenMail", mail);
        genQR.putExtra("GenContact", contact);
        genQR.putExtra("GenCompany", company);
        genQR.putExtra("GenWebsite", website);
        genQR.putExtra("GenDesignation", designation);
    }
}