package com.example.helloworld.Slot6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.helloworld.Slot5.SqliteHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_TABLE_PRODUCT = "CREATE TABLE Product (\n" +
            "    ProductId text PRIMARY KEY,\n" +
            "    ProductName text,\n" +
            "    Quantity int\n" +
            ")";

    public SQLiteHelper(Context context) {
        super(context, "ProductManager", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Product;");
    }
}
