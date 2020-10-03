package com.example.mantenimiendo_de_naves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView correo;
    private TextView contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void irARegistro (View view){
        Intent registro =new Intent(this, Registro.class);
        startActivity(registro);
    }

    public void irAMenu (View view){
        Intent menu =new Intent(this, Menu.class);
        startActivity(menu);
    }
}