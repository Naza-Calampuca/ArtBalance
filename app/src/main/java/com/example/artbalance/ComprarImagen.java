package com.example.artbalance;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;

public class ComprarImagen extends AppCompatActivity {

    CardForm cardForm ;
    Button buy;
    Button atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar_imagen);

        cardForm = findViewById(R.id.card_form);
        buy = findViewById(R.id.btnBuy);
        atras = findViewById(R.id.Atras);

        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .cardholderName(CardForm.FIELD_REQUIRED)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("SMS es requerido en este telefono")
                .actionLabel("Comprar")
                .setup(ComprarImagen.this);
        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        buy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (cardForm.isValid()) {

                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(ComprarImagen.this);
                    alertBuilder.setTitle("Confirmar la compra");
                    alertBuilder.setMessage("Numero de tarjeta: " + cardForm.getCardNumber() + "\n" +
                            "Fecha de expiracion de tarjeta " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                            "CVV: " + cardForm.getCvv() + "\n" +
                            "Codigo postal: " + cardForm.getPostalCode() + "\n" +
                            "Numero de telefono: " + cardForm.getMobileNumber());

                    alertBuilder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.dismiss();
                            Toast.makeText(ComprarImagen.this, "Gracias por su compra", Toast.LENGTH_LONG).show();
                        }
                    });

                    alertBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();
                }

                else {

                    Toast.makeText(ComprarImagen.this, "Porfavor complete el formulario", Toast.LENGTH_LONG).show();
                }
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent l = new Intent(ComprarImagen.this, MainActivity.class);
                startActivity(l);
            }
        });
    }
}