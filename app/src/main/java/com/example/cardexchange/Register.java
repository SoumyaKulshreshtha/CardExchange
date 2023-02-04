package com.example.cardexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);


        TextView Login = findViewById(R.id.signIn);
        EditText RName = findViewById(R.id.regName);
        EditText REmail = findViewById(R.id.regEmail);
        EditText RMobile = findViewById(R.id.regMobile);
        EditText RPassword = findViewById(R.id.regPassword);
        Button RButton = findViewById(R.id.registerButton);

        String URL = "https://cardexchange.wisetechsolution.in/register.php";


        RButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rName = RName.getText().toString().trim();
                String rMobile = RMobile.getText().toString().trim();
                String rEmail = REmail.getText().toString().trim();
                String rPassword = RPassword.getText().toString().trim();
                //Toast.makeText(getApplicationContext(), rName+" "+rMobile+" "+rEmail+" "+rPassword, Toast.LENGTH_LONG).show();
                if(!rName.equals("") && !rEmail.equals("") && !rPassword.equals("") && !rMobile.equals("")){
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("success")) {
                                //redirect to login / dashboard
                                startActivity(new Intent(Register.this, MyContactCard.class));
                                finish();
                                //tvStatus.setText("Successfully registered.");
                                //btnRegister.setClickable(false);
                            } else if (response.equals("failure")) {
                                //tvStatus.setText("Something went wrong!");
                                Toast.makeText(getApplicationContext(), "Sorry! There is a problem registering right now. Please try later.", Toast.LENGTH_LONG).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("name", rName);
                            data.put("email", rEmail);
                            data.put("password", rPassword);
                            data.put("contact",rMobile);
                            return data;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                }
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Register.this, Login.class));
                finish();
            }

        });

    }
}