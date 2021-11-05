


package com.example.artbalance;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.artbalance.Publicacion;
import com.example.artbalance.databinding.ActivityMainBinding;
import com.example.artbalance.databinding.ActivitySuirPublicacionBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SuirPublicacion extends AppCompatActivity {

    ActivitySuirPublicacionBinding binding;
    Uri imageUri;
    StorageReference storageReference;
    ProgressDialog progressDialog;
    Button Atras;
    EditText NombreImg;
    EditText Precio;
    TextView ArtBalance;
    ImageButton BotonPerfil;
    EditText DescripcionImg;
    EditText TagsImg;
    String mail;
   // Uri imageUploaduri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySuirPublicacionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArtBalance = (TextView) findViewById(R.id.textView2);
        Atras = (Button) findViewById(R.id.Atras);
        NombreImg = (EditText) findViewById(R.id.NombreImg);
        Precio = (EditText) findViewById(R.id.Precio);
        BotonPerfil = (ImageButton) findViewById(R.id.BotonPerfil);
        DescripcionImg = (EditText) findViewById(R.id.descripcion_img);
        TagsImg = (EditText) findViewById(R.id.tags);
        mail = getIntent().getStringExtra("mail");

        //La informacion parece estar bien en el login, el problema es que acá la recibe mal y lo deja en null a mail
        // direccion de botones

        BotonPerfil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent a = new Intent(SuirPublicacion.this, PerfilUsuario.class);
                startActivity(a);

            }
        });



        Atras.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(SuirPublicacion.this, MainActivity.class);
                startActivity(i);

            }
        });


        binding.selectImagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectImage();

            }
        });

        binding.uploadimagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                uploadImage();



            }
        });

    }

    //firebase

    private void subirFirestoreDatabase(Uri imageUploaduri) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

// Create a new user with a first and last name
        Map<String, Object> publicacion = new HashMap<>();
        publicacion.put("Descripcion",   NombreImg.getText().toString());
        publicacion.put("Imagen",imageUploaduri.toString() );
        publicacion.put("Precio", Integer.valueOf(Precio.getText().toString()));
        publicacion.put("Informacion",   DescripcionImg.getText().toString());
        publicacion.put("Tags",   TagsImg.getText().toString());
        publicacion.put("Usuario", MainActivity.emailUsuario);
        publicacion.put("Id_Usuario", MainActivity.idUsuario);
        ;


// Add a new document with a generated ID
        db.collection("Publicaciones")
                .add(publicacion)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("naza", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("artbalance", "Error adding document", e);
                    }
                });


    }



    private void uploadImage() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading File....");
        progressDialog.show();


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CANADA);
        Date now = new Date();
        String fileName = formatter.format(now);
        storageReference = FirebaseStorage.getInstance().getReference("images/"+fileName);


        storageReference.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        binding.fotoprueba.setImageURI(null);
                        Toast.makeText(SuirPublicacion.this,"Successfully Uploaded",Toast.LENGTH_SHORT).show();
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();


                        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                subirFirestoreDatabase(uri);

                            }
                        });




                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {


                if (progressDialog.isShowing())
                    progressDialog.dismiss();
                Toast.makeText(SuirPublicacion.this,"Failed to Upload",Toast.LENGTH_SHORT).show();


            }
        });

    }

    private void selectImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && data != null && data.getData() != null){

            imageUri = data.getData();
            binding.fotoprueba.setImageURI(imageUri);


        }
    }

}




