package com.example.helloworld.Slot6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.helloworld.Slot5.SqliteHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbHelper;
    private Context context;

    public static final String TABLE_NAME = "Product";

    public ProductDao(Context context) {
        this.context = context;
        dbHelper = new SQLiteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public List<Product> getAllProduct(){
        List<Product> productList = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            Product p = new Product();
            p.setProductId(c.getString(0));
            p.setProductName(c.getString(1));
            p.setQuantity(Integer.parseInt(c.getString(2)));
            productList.add(p);
            c.moveToNext();
        }
        c.close();
        return productList;
    }

    public List<String> getAllProductToString(){
        List<String> productList = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            Product p = new Product();
            p.setProductId(c.getString(0));
            p.setProductName(c.getString(1));
            p.setQuantity(Integer.parseInt(c.getString(2)));
            String string = p.getProductId() + " - " + p.getProductName() + " - " + p.getQuantity();
            productList.add(string);
            c.moveToNext();
        }
        c.close();
        return productList;
    }

    public int insertProduct(Product p){
        ContentValues values = new ContentValues();
        values.put("ProductId", p.getProductId());
        values.put("ProductName", p.getProductName());
        values.put("Quantity", String.valueOf(p.getQuantity()));
        if (db.insert(TABLE_NAME, null, values) <= 0){
            return -1;
        } else {
            return 1;
        }
    }

    public int updateProduct(Product p){
        ContentValues values = new ContentValues();
        values.put("ProductId", p.getProductId());
        values.put("ProductName", p.getProductName());
        values.put("Quantity", String.valueOf(p.getQuantity()));
        if (db.update(TABLE_NAME, values, "ProductId = ?", new String[]{p.getProductId()}) <= 0){
            return -1;
        } else {
            return 1;
        }
    }

    public int deleteProduct(String productId){
        if (db.delete(TABLE_NAME, "ProductId = ?", new String[]{productId}) <= 0){
            return -1;
        } else {
            return 1;
        }
    }
}
