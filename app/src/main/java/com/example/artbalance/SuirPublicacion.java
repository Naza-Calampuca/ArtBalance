package com.example.artbalance;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

public class SuirPublicacion extends AppCompatActivity {


    Uri imageUri;
    String myUrl="";
StorageTask uploadTask;
StorageReference storageReference;


ImageView close, image_added;
TextView post;
EditText description;
    Button VentanaSubirArchivos;

    /*
    Button ElegirImagen;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suir_publicacion);

//boton atras
        VentanaSubirArchivos = (Button) findViewById(R.id.Atras);

        VentanaSubirArchivos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent z = new Intent(SuirPublicacion.this, MainActivity.class);
                startActivity(z);

            }
        });


        close= findViewById(R.id.close);
        image_added= findViewById(R.id.image_added);
        post= findViewById(R.id.post);
        description= findViewById(R.id.description);


        storageReference = FirebaseStorage.getInstance().getReference("posts");

        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void  onClick(View view){

            startActivity(new Intent(PostActivity.this, MainActivity.class));
            finish();

            }

        });
post.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        uploadImage();

    }
});

CropImage.activity()
.setAspectRatio(l,l)
.start(PostActivity.this);


/*
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
*/

    }


    private String getFileExtension (Uri uri){

        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(contentResolver.getType(uri));
    }

private void uploadImage(){

    ProgressDialog progressDialog = new ProgressDialog(this);
    progressDialog.setMessage("Posting");
    progressDialog.show();

    if (imageUri != null){

        StorageReference filerefrence = storageReference.child(System.currentTimeMillis()
                + "."+getFileExtension(imageUri));


            uploadTask = filerefrence
    }


}


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE ❝❝ resultCode ==RESULT_OK){
        CropImage.ActivityResult result = CropImage.getActivityResult(data);
        imageUri = result.getUri();

        image_added.setImageURI(imageUri);
        } else{
                Toast.makeText(this,"Something gone wrong!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PostActivity.this , MainActivity.class ));
                finish();
        }
    }
}


