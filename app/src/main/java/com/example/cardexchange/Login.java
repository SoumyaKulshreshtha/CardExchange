package com.example.cardexchange;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class Login extends AppCompatActivity {

    //creating constant keys for shared prefrences.
    public static final String SHARED_PREFS = "shared_prefs";
    //key for storing email.
    public static final String EMAIL_KEY = "email_key";
    //key for storing password.
    public static final String PASSWORD_KEY = "password_key";
    //variable for shared prefrences.
    SharedPreferences sharedpreferences;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        EditText loginEmail, loginPassword;

        TextView SignUp = findViewById(R.id.signUp);
        Button Login = findViewById(R.id.loginButton);
        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);

        String URL = "https://cardexchange.wisetechsolution.in/login.php";


        //getting the data which is stored in shared prefrences.
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        //in shared prefs inside het string method we are passing key value as EMAIL_KEY and default value is
        //set to null if not present.
        email = sharedpreferences.getString(EMAIL_KEY, null);
        password = sharedpreferences.getString(PASSWORD_KEY, null);


        SignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
                finish();
            }
            //Toast.makeText(getApplicationContext(),mail+" "+password,Toast.LENGTH_LONG).show();

        });

        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                email = loginEmail.getText().toString().trim();
                password = loginPassword.getText().toString().trim();
                if (!email.equals("") && !password.equals("")) {

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    //below two lines will put values for email and password in shared prefrences.
                    editor.putString(EMAIL_KEY, loginEmail.getText().toString().trim());
                    editor.putString(PASSWORD_KEY, loginPassword.getText().toString().trim());
                    //to save our data with key and value.
                    editor.apply();

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("res", response);
                            if (response.equals("success")) {
                                Intent intent = new Intent(Login.this, Dashboard.class);
                                startActivity(intent);
                                finish();
                            } else if (response.equals("failure")) {
                                Toast.makeText(Login.this, "Invalid Login Id/Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Login.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("email", email);
                            data.put("password", password);
                            return data;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                } else {
                    Toast.makeText(Login.this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

