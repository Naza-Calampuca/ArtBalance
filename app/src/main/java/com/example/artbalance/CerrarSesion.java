package com.example.artbalance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerrar_sesion);

        storageReference=FirebaseStorage.getInstance().getReference().child("Proyecto/arte1.jpg");

        try{

            final File localFile=File.createTempFile("arte1","jpg");
            storageReference.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {

                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                            Toast.makeText(CerrarSesion.this,"Error Occurred", Toast.LENGTH_SHORT).show();
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

                            Toast.makeText(CerrarSesion.this,"Error Occurred", Toast.LENGTH_SHORT).show();
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

                            Toast.makeText(CerrarSesion.this,"Error Occurred", Toast.LENGTH_SHORT).show();
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

                            Toast.makeText(CerrarSesion.this,"Error Occurred", Toast.LENGTH_SHORT).show();
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

                            Toast.makeText(CerrarSesion.this,"Error Occurred", Toast.LENGTH_SHORT).show();
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

                            Toast.makeText(CerrarSesion.this,"Error Occurred", Toast.LENGTH_SHORT).show();
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