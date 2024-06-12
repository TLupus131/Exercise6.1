package com.example.helloworld.Slot10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.helloworld.R;
import com.example.helloworld.Slot9.Product;

import java.util.List;

public class CartAdapter extends ArrayAdapter<Product> {
    private Context mContext;

    public CartAdapter(Context context, List<Product> products) {
        super(context, 0, products);
        mContext = context;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.cart_item, parent, false);
        }
        Product currentProduct = getItem(position);
        TextView productName = listItem.findViewById(R.id.cartItem_tvProductName);
        productName.setText(currentProduct.getStyleId());
        TextView productQuantity = listItem.findViewById(R.id.cartItem_tvProductQuantity);
        productQuantity.setText("Quantity: " + 1);
        return listItem;
    }
}
