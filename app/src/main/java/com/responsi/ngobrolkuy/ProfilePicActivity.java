package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class ProfilePicActivity extends AppCompatActivity {
    private ImageView ivprofil;
    private CardView cvbtnlewati;
    private Uri imageUri;

    private static final String TAG = ProfilePicActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);

        ivprofil=findViewById(R.id.profilePic);
        cvbtnlewati=findViewById(R.id.buttonlewati);

        cvbtnlewati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah=new Intent(ProfilePicActivity.this, HomeActivity.class);
                startActivity(pindah);
            }
        });

        ivprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GALLERY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED){
            Toast.makeText(this,"Cancel input image", Toast.LENGTH_SHORT).show();
            return;
        }
        if (requestCode == GALLERY_REQUEST_CODE){
            if (data!=null){
                try {
                    imageUri=data.getData();
                    Bitmap bmp=MediaStore.Images.Media.getBitmap(this.getContentResolver(),imageUri);
                    ivprofil.setImageBitmap(bmp);
                }
                catch (IOException e){
                    Toast.makeText(this, "Can't load Image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}