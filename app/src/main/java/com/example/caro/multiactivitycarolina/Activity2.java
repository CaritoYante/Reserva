package com.example.caro.multiactivitycarolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {

    private TextView apeMat, apePat, nombre, rControl, fNacimiento, correo, contra, nombreCompleto;
    private String txtApeMat, txtApePat, txtNombre, txtRControl, txtFNacimiento, txtCorreo, txtContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        apeMat = (TextView) findViewById(R.id.apeMat);
        apePat = (TextView) findViewById(R.id.apePat);
        nombre = (TextView) findViewById(R.id.nombre);
        rControl = (TextView) findViewById(R.id.rControl);
        fNacimiento = (TextView) findViewById(R.id.fNacimiento);
        correo = (TextView) findViewById(R.id.correo);
        contra = (TextView) findViewById(R.id.contra);
        nombreCompleto = (TextView) findViewById(R.id.nombreCompleto);

        RecibeDatos();
    }

    public void RecibeDatos(){
        Bundle extras = getIntent().getExtras();
        txtApeMat = extras.getString("apeMat");
        txtApePat = extras.getString("apePat");
        txtNombre = extras.getString("nombre");
        txtRControl = extras.getString("rControl");
        txtFNacimiento = extras.getString("fechaN");
        txtCorreo = extras.getString("correo");
        txtContra = extras.getString("contraseña");

        MandaDatos();
    }

    public void MandaDatos(){
        apeMat.setText(txtApeMat);
        apePat.setText(txtApePat);
        nombre.setText(txtNombre);
        rControl.setText(txtRControl);
        fNacimiento.setText(txtFNacimiento);
        correo.setText(txtCorreo);
        contra.setText(txtContra);
        nombreCompleto.setText(txtNombre + " " + txtApePat);
    }
}
