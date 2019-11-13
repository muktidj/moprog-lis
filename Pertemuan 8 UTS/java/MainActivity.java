  package com.example.utscrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

  public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editNim, editFirst_Name, editLast_Name, scoreText;
    Button btnAddData, btnViewAll, btnUpdateData, hapusButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editNim = (EditText) findViewById(R.id.nimText);
        editFirst_Name = (EditText) findViewById(R.id.ediTextFirstName);
        editLast_Name = (EditText) findViewById(R.id.last_nameText);
        scoreText = (EditText) findViewById(R.id.scoreText);
        btnAddData = (Button) findViewById(R.id.buttonTambah);
        btnViewAll = (Button) findViewById(R.id.viewButton);
        btnUpdateData = (Button) findViewById(R.id.ubahButton);
        hapusButton = (Button) findViewById(R.id.hapusButton);
        AddData();
        ViewData();
       UpdateData();
       DeleteData();

    }

    public void DeleteData() {
       hapusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(editNim.getText().toString());
                if(deletedRows > 0) {
                    Toast.makeText(MainActivity.this, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data Gagal Dihapus", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void UpdateData() {
        btnUpdateData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editNim.getText().toString(),
                                editFirst_Name.getText().toString(),
                                editLast_Name.getText().toString(),
                               scoreText.getText().toString());
                        if(isUpdate == true) {
                            Toast.makeText(MainActivity.this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Data Gagal Diubah", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted = myDb.insertData(editNim.getText().toString(),
                        editFirst_Name.getText().toString(),
                        editLast_Name.getText().toString(),
                       scoreText.getText().toString());
               if(isInserted == true) {
                   Toast.makeText(MainActivity.this, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(MainActivity.this, "Data Gagal Ditambahkan", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    public void ViewData() {
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
//                            Show Message
                            showMessage("Error","Tidak ditemukan");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()) {
                            buffer.append("ID :" + res.getString(0)+ "\n");
                            buffer.append("First Name :" + res.getString(1)+ "\n");
                            buffer.append("Last Name :" + res.getString(2)+ "\n");
                            buffer.append("Score :" + res.getString(3)+ "\n\n");
                        }
                        //Show All Data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
