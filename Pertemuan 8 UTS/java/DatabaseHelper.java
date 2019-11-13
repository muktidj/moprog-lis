package com.example.utscrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mahasiswa.db";
    public static final String TABLE_NAME = "mahasiswa_table";
    public static final String COL_1 = "NIM";
    public static final String COL_2 = "FIRST_NAME";
    public static final String COL_3 = "LAST_NAME";
    public static final String COL_4 = "SCORE";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table " + TABLE_NAME + " (NIM INTEGER PRIMARY KEY, FIRST_NAME TEXT, LAST_NAME TEXT, SCORE INTEGER ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String nim, String first_name, String last_name, String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, nim);
        contentValues.put(COL_2, first_name);
        contentValues.put(COL_3, last_name);
        contentValues.put(COL_4, score);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String nim, String first_name, String last_name, String score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, nim);
        contentValues.put(COL_2, first_name);
        contentValues.put(COL_3, last_name);
        contentValues.put(COL_4, score);
        db.update(TABLE_NAME, contentValues, "NIM = ?", new String[] {nim} );
        return true;
    }

    public Integer deleteData (String nim) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "NIM = ?", new String[] {nim});
    }

}
