package com.example.caro.multiactivitycarolina;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button Bfecha;
    private int dia,mes, año;
    private TextView efecha;

    private EditText nombre, apePat, apeMat, correo, contra, confirmaContra;
    private Switch rControl;

    private String txtImagen, txtNombre, txtApePat, txtApeMat, txtCorreo, txtContra, txtConfirmaContra, ubicacion;
    private Boolean txtRControl;

    private String nuevoNombre, nuevoApeMat, nuevoApePat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        efecha = (TextView) findViewById(R.id.efecha);
        Bfecha = (Button) findViewById(R.id.Bfecha);

        nombre = (EditText) (findViewById(R.id.nombre));
        apePat = (EditText) (findViewById(R.id.apePat));
        apeMat = (EditText) (findViewById(R.id.apeMat));
        correo = (EditText) (findViewById(R.id.correo));
        contra = (EditText) (findViewById(R.id.contra));
        confirmaContra = (EditText) (findViewById(R.id.confirmaContra));
        rControl = (findViewById(R.id.rControl));
    }

    public void creaPersona(View view) {
        //txtImagen = imagen.getText().toString();
        txtNombre = nombre.getText().toString();
        txtApeMat = apeMat.getText().toString();
        txtApePat = apePat.getText().toString();
        txtCorreo = correo.getText().toString();
        txtContra = contra.getText().toString();
        txtConfirmaContra = confirmaContra.getText().toString();
        txtRControl = rControl.isChecked();

        //VALIDACIONES
        //Valida que todos los campos esten llenos
        if (TextUtils.isEmpty(txtNombre) || TextUtils.isEmpty(txtApeMat) || TextUtils.isEmpty(txtApePat) || TextUtils.isEmpty(txtCorreo) || TextUtils.isEmpty(txtContra) || TextUtils.isEmpty(txtConfirmaContra)) {
            Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            if (txtContra.length() >= 6 || txtConfirmaContra.length() >= 6) {
                //Validando Contraseñas iguales
                if (txtContra.equals(txtConfirmaContra)) {
                    Intent intent = new Intent(this, Activity2.class);
                        intent.putExtra("nombre", txtNombre);
                        intent.putExtra("apePat", txtApePat);
                        intent.putExtra("apeMat", txtApeMat);
                        intent.putExtra("rControl", txtRControl.toString());
                        intent.putExtra("fechaN", efecha.getText().toString());
                        intent.putExtra("correo", txtCorreo);
                        intent.putExtra("contraseña", txtContra);
                    finish();
                    startActivity(intent);
                } else {
                    //msj las contraseñas no coinciden
                    Toast.makeText(this, "Las contraseñas no coinciden :(", Toast.LENGTH_SHORT).show();
                    confirmaContra.requestFocus();
                }
            } else {
                //msj la contraseña debe tener al menos 6 caracteres
                Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres :(", Toast.LENGTH_SHORT).show();
                contra.requestFocus();
            }
        }
    }




    //CODIGO PARA PICKER DATE Y TIME
    public void pickerOnClick(View view) {
        if(view == Bfecha){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    String dia;
                    String mes;
                    int tamañoDia = (Integer.toString(dayOfMonth)).length();
                    int tamañoMes = (Integer.toString(monthOfYear+1)).length();

                    if(tamañoDia == 1){
                        dia = "0" + (Integer.toString(dayOfMonth));
                    }else
                        dia = Integer.toString(dayOfMonth);

                    if(tamañoMes == 1){
                        mes = "0" + (Integer.toString(monthOfYear+1));
                    }else
                        mes = Integer.toString(monthOfYear+1);

                    efecha.setText(dia+"/"+mes+"/"+year);
                }
            }
                    ,año, mes, dia);
            datePickerDialog.show();
        }
    }
}

