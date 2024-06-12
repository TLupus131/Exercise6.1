package com.example.helloworld.Slot9;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloworld.R;
import com.example.helloworld.Slot10.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private List<Product> list;

    public ProductAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.product_item_view, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.itemView_searchImage);
            holder.tvStyleId = convertView.findViewById(R.id.tvStyleId);
            holder.tvBrand = convertView.findViewById(R.id.tvBrand);
            holder.tvPrice = convertView.findViewById(R.id.tvPrice);
            holder.tvInfo = convertView.findViewById(R.id.tvInfo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Product product = list.get(position);
        if (product != null) {
            Picasso.get().load(product.getSearchImage()).into(holder.imageView);
            holder.tvStyleId.setText(product.getStyleId());
            holder.tvBrand.setText(product.getBrand());
            holder.tvPrice.setText(product.getPrice());
            holder.tvInfo.setText(product.getInfo());
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product1 = list.get(position);
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("PRODUCT", product1);
                context.startActivity(intent);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView tvStyleId, tvBrand, tvPrice, tvInfo;
    }
}
