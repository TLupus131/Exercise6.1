package com.example.helloworld.Slot5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private SqliteHelper helper;
    private SQLiteDatabase db;
    private Context context;

    public ProductDao(Context context){
        this.context = context;
        helper = new SqliteHelper(context);
        db = helper.getWritableDatabase();
    }

    public int insertProduct(Product product){
        ContentValues values = new ContentValues();
        values.put("id", product.getId());
        values.put("name", product.getName());
        values.put("price", product.getPrice());

        if (db.insert("Product", null, values) < 0){
            return -1;
        }
        return 1;
    }

    public List<Product> getAll(){
        List<Product> list = new ArrayList<>();
        Cursor c = db.query("Product", null, null, null, null, null,null, null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            Product product = new Product();
            product.setId(c.getString(0));
            product.setName(c.getString(1));
            product.setPrice(c.getDouble(2));
            list.add(product);
            c.moveToNext();
        }
        c.close();
        return list;
    }
}
