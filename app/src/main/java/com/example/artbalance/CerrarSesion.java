package com.example.artbalance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CerrarSesion extends AppCompatActivity {

    private ImageView publi1;
    private DatabaseReference DaTabase;
    private ProgressDialog mProgressDialog;
    private DatabaseReference Database;
    private FirebaseDatabase FirebaseDatabase;
    private StorageReference storageReference;



    Button IniciarSesion;
    Button Registrarse;
    TextView ArtBalance;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerrar_sesion);

        ArtBalance = (TextView) findViewById(R.id.ArtBalance);

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

        storageReference=FirebaseStorage.getInstance().getReference().child("Proyecto/arte1.jpg");
        ArrayList<Publicacion> publicaciones = new ArrayList<>();
        db.collection("Publicaciones")

                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Publicacion p = document.toObject(Publicacion.class);
                                publicaciones.add(p);

                                Log.d("TAG", document.getId() + " => " + document.getData());

                            }
                            ListView lista=findViewById (R.id.Listaimg);
                            PublicacionesAdapter ubis= new PublicacionesAdapter( CerrarSesion.this,publicaciones);
                            lista.setAdapter (ubis);
                        }

                        else {

                            Log.w("TAG", "Error getting documents.", task.getException());

                        }

                    }
                });


    }

    private void gologin() {
        Intent i = new Intent(this, Login.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

}