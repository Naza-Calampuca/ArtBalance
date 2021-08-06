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

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

import java.util.HashMap;

public class SuirPublicacion extends AppCompatActivity {

    Uri imageUri;
    String myUrl="";
    StorageTask uploadTask;
    StorageReference storageReference;
    ImageView image_added;
    Button post;
    EditText description;
    Button Atras;

    /*
    Button ElegirImagen;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suir_publicacion);

        Atras = (Button) findViewById(R.id.Atras);
        image_added = findViewById(R.id.fotoprueba);
        post = findViewById(R.id.post);
        description = findViewById(R.id.Descripcion);
        ElegirImagen = (Button) findViewById(R.id.SeleccionarImagen);

        storageReference = FirebaseStorage.getInstance().getReference("posts");

        Atras.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent z = new Intent(SuirPublicacion.this, MainActivity.class);
                startActivity(z);

            }
        });

        //TODO LO DE ANTES ESTA BIEN

        post.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                uploadImage();

            }
        });

        CropImage.activity()

                .setAspectRatio(1, 1)
                .start(PostActivity.this);


    }

        //ctrl + o

    @Override
    protected void onActivityResult(int requestCode, int resultCode,@Nuliable Intent data){

        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && requestCode == RESULT_OK){

            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            imageUri = result.getUri();
        }

    }

}

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


            uploadTask = filerefrence.putFile(imageUri);
            uploadTask.continueWithTask(new Continuation() {
                @Override
                public Object then(@NonNull Task task) throws Exception {
                    if (!task.isSuccessful()){

                        throw task.getException();
                    }


                    return filerefrence.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()){

                        Uri downloadUri = task.getResult();
                        myUrl = downloadUri.toString();


                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Posts");

                        String postid = reference.push().getKey();

                        HashMap<String, Object> hashMap = new HashMap<> ();
                        hashMap.put("postid",postid);
                        hashMap.put("postimage",myUrl);
                        hashMap.put("publisher",FirebaseAuth.getInstance().getCurrentUser().getUid());

                        reference.child(postid). setValue(hashMap);

                        progressDialog.dismiss();

                        startActivity(new Intent (PostActivity.this, MainActivity.class ));

                        finish();
        } else {

Toast.makeText(PostActivity.this, "Failed!", Toast.LENGHT_SHORT).show();

                     }
                }
            }).addOnFailureListener(new OnFailureListener()){

                @Override
            public void onFailure(@NonNull Exception e){

                    Toast.makeTest(PostActivity.this, ""+e.getMessage() , Toast.LENGHT_SHORT).show();

        }

        });
    } else{
        Toast.makeText(this, "No Image Selected", Toast.LENGHT_SHORT).show();
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


