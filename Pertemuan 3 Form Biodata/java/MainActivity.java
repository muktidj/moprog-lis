package com.example.kelaspaklisformbiodata3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.CheckBox ;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nim,nama,alamat;
    RadioGroup kel;
    RadioButton jk;
    Spinner agama;
    CheckBox makan, tidur, belajar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tomboltampil = (Button) findViewById(R.id.btnok);
        nim = (EditText)findViewById(R.id.tNim);
        nama=(EditText)findViewById(R.id.TNama);
        alamat=(EditText)findViewById(R.id.talamat);
        kel=(RadioGroup)findViewById(R.id.radioGroup1);
        agama=(Spinner)findViewById(R.id.spinner);
        makan = (CheckBox) findViewById(R.id.chmakan);
        tidur = (CheckBox) findViewById(R.id.chtidur);
        belajar = (CheckBox) findViewById(R.id.chbelajar);
        tomboltampil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                String hobi="";
                if (makan.isChecked())
                    hobi+=","+makan.getText().toString();
                if (tidur.isChecked())
                    hobi+=","+tidur.getText().toString();

                if (belajar.isChecked())
                    hobi+=","+belajar.getText().toString();
                hobi = hobi.replaceFirst(",","");
                int selectedId = kel.getCheckedRadioButtonId();
                jk=(RadioButton) findViewById(selectedId);
                Toast.makeText(getApplicationContext(),"NIM : "+
                        nim.getText()+"\n"+
                        "NAMA : "+nama.getText()+"\n"+"ALAMAT : "+
                        alamat.getText()+"\n"+
                        "JENIS KELAMIN : "+jk.getText()+"\n"+
                        "TEMPAT LAHIR : "+"\n"+
                        "TANGGAL LAHIR : "+"\n"+
                        "JENIS KELAMIN : "+jk.getText()+"\n"+
                        "AGAMA : "+String.valueOf(agama.getSelectedItem())+
                        "\nHOBI : "+hobi+"\n OK...", Toast.LENGTH_LONG).show();
            }
        });
    }
}