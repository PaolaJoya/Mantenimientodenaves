package com.example.mantenimiendo_de_naves;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class Registro extends AppCompatActivity {

    private EditText nombre1;
    private EditText apellido1;
    private EditText correo1;
    private EditText confcorreo1;
    private EditText contrasena1;
    private EditText confcontrasena1;
    private EditText tipodocumento1;
    private EditText documento1;
    private EditText telefono1;
    private EditText codigo1;
    private ProgressDialog progressDialog;



    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre1=(EditText)findViewById(R.id.nombres);
        apellido1=(EditText)findViewById(R.id.apellidos);
        correo1=(EditText)findViewById(R.id.correo);
        confcorreo1=(EditText)findViewById(R.id.confcorreo);
        contrasena1=(EditText)findViewById(R.id.contraseña);
        confcontrasena1=(EditText)findViewById(R.id.contraseña);
        //tipodocumento1=(EditText)findViewById(R.id.tipodocumento);
        documento1=(EditText)findViewById(R.id.documento);
        telefono1=(EditText)findViewById(R.id.telefono);
        codigo1=(EditText)findViewById(R.id.codigo);



    }

    public void Registrar(View vi){

        String correo2=correo1.getText().toString();
        String correo22=confcorreo1.getText().toString();
        String contrasena2=contrasena1.getText().toString();
        String contrasena22=confcontrasena1.getText().toString();

        if(validar()) {
            if(correo2.equals(correo22)){
                if (contrasena2.equals(contrasena22)) {
                mAuth.createUserWithEmailAndPassword(correo2, contrasena2)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    //Log.d(TAG, "createUserWithEmail:success");

                                    //Log.d(TAG, "Ha registrado sus datos con exito");
                                     FirebaseUser user = mAuth.getCurrentUser();
                                    Intent menuinicio = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(menuinicio);
                                    //updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(getApplicationContext(), "Autenticación fallida", Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }

                            }
                        });

                }
            }
        }else{
            Toast.makeText(this,"Uno o varios de los campos registrados, son erroneos",Toast.LENGTH_SHORT).show();
        }

    }

    public boolean validar(){

        boolean retorno= true;
        String nombre2=nombre1.getText().toString();
        String apellido2=apellido1.getText().toString();
        String correo2=correo1.getText().toString();
        String correo22=confcorreo1.getText().toString();
        String contrasena2=contrasena1.getText().toString();
        String contrasena22=confcontrasena1.getText().toString();
        //String tpodocumento2=tipodocumento1.getText().toString();
        String documento2=documento1.getText().toString();
        String telefono2=telefono1.getText().toString();
        String codigo2=codigo1.getText().toString();



        if (nombre2.isEmpty()) {
            nombre1.setError("Este campo es obligatorio");
            retorno = false;
        }

        if (apellido2.isEmpty()) {
            apellido1.setError("Este campo es obligatorio");
            retorno = false;
        }

        if (correo2.isEmpty()) {
            correo1.setError("Este campo es obligatorio");
            retorno = false;
        }

        if (correo22.isEmpty()) {
            confcorreo1.setError("Este campo es obligatorio");
            retorno = false;
        }

        if (contrasena2.isEmpty()) {
            contrasena1.setError("Este campo es obligatorio");
            retorno = false;
        }

        if (contrasena22.isEmpty()) {
            confcontrasena1.setError("Este campo es obligatorio");
            retorno = false;
        }

        /*if (tpodocumento2=="Tipo de documento") {
            tipodocumento1.setError("Este campo es obligatorio");
            retorno = false;
        }*/

        if (documento2.isEmpty()) {
            documento1.setError("Este campo es obligatorio");
            retorno = false;
        }

        if (telefono2.isEmpty()) {
            telefono1.setError("Este campo es obligatorio");
            retorno = false;
        }

        if (codigo2.isEmpty()) {
            codigo1.setError("Este campo es obligatorio");
            retorno = false;
        }

        return retorno;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }


}