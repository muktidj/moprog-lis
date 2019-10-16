package com.example.kelaspaklis4ifelse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;


    public class IfActivity extends AppCompatActivity {
        TextView niluts,niluas,niltgs,nilabs,nilakhir,grade;
        Button btnhitung,btnkeluar;
        HitungNilaiAkhir hitungNilaiAkhir = new HitungNilaiAkhir();
        CariGrade cariGrade= new CariGrade();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_if);
            btnkeluar = (Button) findViewById(R.id.btnkeluarif);
            niluts = (TextView) findViewById(R.id.TxtUts);
            niluas = (TextView) findViewById(R.id.txtUas);
            nilabs = (TextView) findViewById(R.id.txtAbsensi);
            niltgs = (TextView) findViewById(R.id.txtTugas);
            grade = (TextView) findViewById(R.id.txtGrade);
            nilakhir =(TextView)
                    findViewById(R.id.txtHasilAkhir);
            btnhitung = (Button) findViewById(R.id.btnhitung);
            btnhitung.setOnClickListener(new
                                                 View.OnClickListener() {
                                                     public void onClick(View view) {
                                                         String snilabs = nilabs.getText().toString();
                                                         String sniltugas = niltgs.getText().toString();
                                                         String sniluts = niluts.getText().toString();
                                                         String sniluas = niluas.getText().toString();
                                                         double dabs = Double.parseDouble(snilabs);
                                                         double dtgs = Double.parseDouble(sniltugas);
                                                         double duts = Double.parseDouble(sniluts);
                                                         double duas = Double.parseDouble(sniluas);
                                                         Double total = hitungNilaiAkhir.hitungnilaiakhir(dabs, dtgs,duts,duas);
                                                     String x= String.valueOf(total);
nilakhir.setText("Nilai Akhir : " + x);
 grade.setText("Grade :" +
         cariGrade.carigrade(total));
                                                 }
        });
 btnkeluar.setOnClickListener(new
         View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
    }
}
