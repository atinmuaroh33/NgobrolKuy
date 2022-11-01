package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText cvuser, cvpass;
    private CardView btnlogin;
    private TextView btnlupa, btnregis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cvuser=findViewById(R.id.username);
        cvpass=findViewById(R.id.password);
        btnlogin=findViewById(R.id.buttonlogin);
        btnlupa=findViewById(R.id.lupa);
        btnregis=findViewById(R.id.register);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suser = cvuser.getText().toString();
                String spass = cvpass.getText().toString();

                Intent intent = new Intent(LoginActivity.this, SplashActivity.class);

                intent.putExtra("username",suser);
                intent.putExtra("password",spass);

                startActivity(intent);
            }
        });

        btnlupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SplashActivity.class);
                startActivity(intent);
            }
        });

        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}