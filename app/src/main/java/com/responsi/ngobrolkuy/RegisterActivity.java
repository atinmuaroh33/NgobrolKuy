package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private EditText etreuser, etreemail, etrepass, etrekonpass;
    private CardView cvbtnregis;
    private TextView tvbtnsudah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etreuser= findViewById(R.id.reusername);
        etreemail= findViewById(R.id.email);
        etrepass= findViewById(R.id.repassword);
        etrekonpass= findViewById(R.id.rekonpassword);
        cvbtnregis= findViewById(R.id.buttonregister);
        tvbtnsudah= findViewById(R.id.buttonsudah);

        cvbtnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etreusername=etreuser.getText().toString();
                String etreemaill=etreemail.getText().toString();
                String etrepassword=etrepass.getText().toString();
                String etrekonpassword=etrekonpass.getText().toString();

                Intent pindah=new Intent(RegisterActivity.this, HomeActivity.class);

                pindah.putExtra("reuname",etreusername);
                pindah.putExtra("reemail",etreemaill);
                pindah.putExtra("repass",etrepassword);
                pindah.putExtra("rekonpass",etrekonpassword);

                startActivity(pindah);
            }
        });
    }
}