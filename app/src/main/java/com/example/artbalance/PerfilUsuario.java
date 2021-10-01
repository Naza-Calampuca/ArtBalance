package com.example.artbalance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class PerfilUsuario extends AppCompatActivity {

    private ImageView publi1;
    private DatabaseReference DaTabase;
    private ProgressDialog mProgressDialog;
    private DatabaseReference Database;
    private com.google.firebase.database.FirebaseDatabase FirebaseDatabase;
    private StorageReference storageReference;

    Button VentanaSubirArchivos;

    Button CerrarSesion;

    ImageButton BotonPerfil;

    TextView ArtBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        ArtBalance = (TextView) findViewById(R.id.textView2);

        BotonPerfil = (ImageButton) findViewById(R.id.BotonPerfil);

        VentanaSubirArchivos = (Button) findViewById(R.id.VentanaSubirArchivos);

        CerrarSesion = (Button) findViewById(R.id.BotonCerrarSesion);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CANADA);
        Date now = new Date();
        String fileName = formatter.format(now);

        storageReference=FirebaseStorage.getInstance().getReference("images/"+fileName);
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
                            PublicacionesAdapter ubis= new PublicacionesAdapter( PerfilUsuario.this,publicaciones);
                            lista.setAdapter (ubis);
                        }

                        else {

                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });


        ArtBalance.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent l = new Intent(PerfilUsuario.this, MainActivity.class);
                startActivity(l);
            }
        });

        VentanaSubirArchivos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(PerfilUsuario.this, SuirPublicacion.class);
                startActivity(i);
            }
        });


        BotonPerfil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent a = new Intent(PerfilUsuario.this, PerfilUsuario.class);
                startActivity(a);
            }
        });

        CerrarSesion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Toast.makeText(PerfilUsuario.this, "Sesion Cerrada", Toast.LENGTH_SHORT).show();
                gologin();
                Intent e = new Intent(PerfilUsuario.this, CerrarSesion.class);
                startActivity(e);
            }
        });
    }

    private void gologin() {

        Intent i = new Intent(this, Login.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}