package com.example.artbalance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class SuirPublicacion extends AppCompatActivity {

    Button ElegirImagen;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suir_publicacion);


        //VIEWS

        ElegirImagen = (Button) findViewById(R.id.SeleccionarImagen);

        //handle button click
        ElegirImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check runtime permission

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_DENIED) {

                        //permission not granted, request it.
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        //show popup for runtime permission
                        requestPermissions(permissions, PERMISSION_CODE);

                    } else {

                        //permission already granted
                        pickImageFromGallery();

                    }

                } else {

                    //system os is less than marshmellow
                    pickImageFromGallery();
                }


            }


        });
    }

    private void pickImageFromGallery() {

//intent to pick image
        Intent intent = new Intent (Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);

    }


    //handle result of runtime permission

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case PERMISSION_CODE:
            if(grantResults.length > 0 && grantResults[0] ==

            PackageManager.PERMISSION_GRANTED){

                //Permission was granted

                pickImageFromGallery();
            }
            else {

                //permission weas denied

                Toast.makeText(this, "Permission denied...!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}


    //handle result of picked image

    /*

    @Override
    protected void onActivityResult (int requestCode,int resultCode,Intent data) {

        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {

            //set image to image view

            mImageView.setImageURI(data.getData());


        }


    }

    */
