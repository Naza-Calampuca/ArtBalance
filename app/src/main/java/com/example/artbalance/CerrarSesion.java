package com.example.artbalance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class CerrarSesion extends AppCompatActivity {

    private DatabaseReference DaTabase;
    private StorageReference storageReference;
    private ProgressDialog mProgressDialog;
    private DatabaseReference Database;
    private FirebaseStorage FirebasezStorage;
    private com.google.firebase.database.FirebaseDatabase FirebaseDatabase;


    Button IniciarSesion;
    Button Registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerrar_sesion);

        Registrarse = (Button) findViewById(R.id.btn_registrarse);

        IniciarSesion = (Button) findViewById(R.id.IniciarSesion);

        IniciarSesion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(CerrarSesion.this, Login.class);
                startActivity(i);

            }
        });

        Registrarse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent e = new Intent(CerrarSesion.this, Registrarse.class);
                startActivity(e);

            }
        });



    }
}