package com.example.cardexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import net.glxn.qrgen.android.QRCode;

public class DownloadBusinessCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_business_card);

        Bitmap myBitmap = QRCode.from("https://myhealth.wisetechsolution.in/visitingCardDownload.php").bitmap();
        ImageView myImage = (ImageView) findViewById(R.id.downloadImageView);
        myImage.setImageBitmap(myBitmap);
    }
}