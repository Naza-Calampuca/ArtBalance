package com.example.artbalance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.StorageReference;

public class PublicacionAntesComprar extends AppCompatActivity {

    private StorageReference storageReference;

    Button Comprar;

    Button VentanaSubirArchivos;

    Button CerrarSesion;

    ImageButton BotonPerfil;

    TextView ArtBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicacion_antes_comprar);

        ArtBalance = (TextView) findViewById(R.id.textView2);

        BotonPerfil = (ImageButton) findViewById(R.id.BotonPerfil);

        VentanaSubirArchivos = (Button) findViewById(R.id.VentanaSubirArchivos);

        CerrarSesion = (Button) findViewById(R.id.BotonCerrarSesion);

        Comprar = (Button) findViewById(R.id.Comprar);


//Direccion de botones

        Comprar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent l = new Intent(PublicacionAntesComprar.this, ComprarImagen.class);
                startActivity(l);
            }
        });

        ArtBalance.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent l = new Intent(PublicacionAntesComprar.this, MainActivity.class);
                startActivity(l);
            }
        });

        VentanaSubirArchivos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(PublicacionAntesComprar.this, SuirPublicacion.class);
                startActivity(i);
            }
        });

        BotonPerfil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent a = new Intent(PublicacionAntesComprar.this, PerfilUsuario.class);
                startActivity(a);
            }
        });

        CerrarSesion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Toast.makeText(PublicacionAntesComprar.this, "Sesion Cerrada", Toast.LENGTH_SHORT).show();
                gologin();
                Intent e = new Intent(PublicacionAntesComprar.this, CerrarSesion.class);
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