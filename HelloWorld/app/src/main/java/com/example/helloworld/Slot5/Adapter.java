package com.example.helloworld.Slot5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloworld.R;

import java.util.List;

public class Adapter extends BaseAdapter {
    private List<Product> list;
    private Context context;

    public Adapter(List<Product> list, Context context) {
        this.list = list;
        this.context = context;
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
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.slot5_item_view, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.itemView_img);
            holder.tvId = convertView.findViewById(R.id.itemView_textId);
            holder.tvName = convertView.findViewById(R.id.itemView_textName);
            holder.tvPrice = convertView.findViewById(R.id.itemView_textPrice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Product product = list.get(position);
        if(product != null){
            holder.imageView.setImageResource(R.drawable.android);
            holder.tvId.setText(product.getId());
            holder.tvName.setText(product.getName());
            holder.tvPrice.setText(String.valueOf(product.getPrice()));
        }
        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView tvId, tvName, tvPrice;
    }
}
