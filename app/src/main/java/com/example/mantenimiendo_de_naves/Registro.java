package com.example.mantenimiendo_de_naves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText nombre1;
    private EditText apellido1;
    private EditText correo1;
    private EditText confcorreo1;
    private EditText contraseña1;
    private EditText confcontraseña1;
    private EditText tipodocumento1;
    private EditText documento1;
    private EditText telefono1;
    private EditText codigo1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre1=(EditText)findViewById(R.id.nombres);
        apellido1=(EditText)findViewById(R.id.apellidos);
        correo1=(EditText)findViewById(R.id.correo);
        confcorreo1=(EditText)findViewById(R.id.confcorreo);
        contraseña1=(EditText)findViewById(R.id.contraseña);
        confcontraseña1=(EditText)findViewById(R.id.contraseña);
        //tipodocumento1=(EditText)findViewById(R.id.tipodocumento);
        documento1=(EditText)findViewById(R.id.documento);
        telefono1=(EditText)findViewById(R.id.telefono);
        codigo1=(EditText)findViewById(R.id.codigo);


    }

    public void Registrar(View vi){

        if(validar()){
            Toast.makeText(this,"Ha registrado sus datos con exito",Toast.LENGTH_SHORT).show();

            Intent main= new Intent(this, MainActivity.class);
            startActivity(main);
        }
    }

    public boolean validar(){

        boolean retorno= true;

        String nombre2=nombre1.getText().toString();
        String apellido2=apellido1.getText().toString();
        String correo2=correo1.getText().toString();
        String correo22=confcorreo1.getText().toString();
        String contrasena2=contraseña1.getText().toString();
        String contrasena22=confcontraseña1.getText().toString();
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
            contraseña1.setError("Este campo es obligatorio");
            retorno = false;
        }

        if (contrasena22.isEmpty()) {
            confcontraseña1.setError("Este campo es obligatorio");
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
}