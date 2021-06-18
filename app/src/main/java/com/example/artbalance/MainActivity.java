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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText edtBuscar;

    Button VentanaSubirArchivos;

 private ImageView publi1;
private DatabaseReference DaTabase;
private StorageReference storageReference;
private ProgressDialog mProgressDialog;
private DatabaseReference Database;
private FirebaseStorage FirebasezStorage;
private FirebaseDatabase FirebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VentanaSubirArchivos=(Button)findViewById(R.id.VentanaSubirArchivos);

        VentanaSubirArchivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( MainActivity.this, SuirPublicacion.class);
                startActivity(i);


            }
        });

        edtBuscar = findViewById(R.id.editTextBuscar);
     publi1=(ImageView)findViewById(R.id.publi1);
storageReference=FirebaseStorage.getInstance().getReference().child("Proyecto/arte1.jpg");
try{
    final File localFile=File.createTempFile("arte1","jpg");
storageReference.getFile(localFile)
        .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                Toast.makeText(MainActivity.this,"Error Occurred", Toast.LENGTH_SHORT).show();
                Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                ((ImageView)findViewById(R.id.publi1)).setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener(){
    @Override
    public void onFailure(@NonNull Exception e) {

    }
});

}
catch (IOException e){
    e.printStackTrace();
}
        storageReference=FirebaseStorage.getInstance().getReference().child("Proyecto/arte2.jpg");
        try{
            final File localFile=File.createTempFile("arte2","jpg");
            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                            Toast.makeText(MainActivity.this,"Error Occurred", Toast.LENGTH_SHORT).show();
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            ((ImageView)findViewById(R.id.publi2)).setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener(){
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }
        catch (IOException e){
            e.printStackTrace();
        }
        storageReference=FirebaseStorage.getInstance().getReference().child("Proyecto/arte3.jpg");
        try{
            final File localFile=File.createTempFile("arte3","jpg");
            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                            Toast.makeText(MainActivity.this,"Error Occurred", Toast.LENGTH_SHORT).show();
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            ((ImageView)findViewById(R.id.publi3)).setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener(){
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }
        catch (IOException e){
            e.printStackTrace();
        }
        storageReference=FirebaseStorage.getInstance().getReference().child("Proyecto/arte4.jpg");
        try{
            final File localFile=File.createTempFile("arte4","jpg");
            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                            Toast.makeText(MainActivity.this,"Error Occurred", Toast.LENGTH_SHORT).show();
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            ((ImageView)findViewById(R.id.publi4)).setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener(){
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }
        catch (IOException e){
            e.printStackTrace();
        }
        storageReference=FirebaseStorage.getInstance().getReference().child("Proyecto/arte5.jpg");
        try{
            final File localFile=File.createTempFile("arte5","jpg");
            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                            Toast.makeText(MainActivity.this,"Error Occurred", Toast.LENGTH_SHORT).show();
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            ((ImageView)findViewById(R.id.publi5)).setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener(){
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }
        catch (IOException e){
            e.printStackTrace();
        }
        storageReference=FirebaseStorage.getInstance().getReference().child("Proyecto/arte6.jpg");
        try{
            final File localFile=File.createTempFile("arte6","jpg");
            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                            Toast.makeText(MainActivity.this,"Error Occurred", Toast.LENGTH_SHORT).show();
                            Bitmap bitmap= BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            ((ImageView)findViewById(R.id.publi6)).setImageBitmap(bitmap);
                        }
                    }).addOnFailureListener(new OnFailureListener(){
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }
        catch (IOException e){
            e.printStackTrace();
        }

     }
    }

