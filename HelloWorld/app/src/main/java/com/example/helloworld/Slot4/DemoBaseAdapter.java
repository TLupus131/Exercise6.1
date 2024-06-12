package com.example.helloworld.Slot4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloworld.R;

import java.util.List;

public class DemoBaseAdapter extends BaseAdapter {

    private Context context;
    private List<Student> studentList;

    public DemoBaseAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.student_listview_item, parent, false);
            holder = new ViewHolder();
            holder.imgAvatar = convertView.findViewById(R.id.itemAvatar);
            holder.tvName = convertView.findViewById(R.id.itemName);
            holder.tvAge = convertView.findViewById(R.id.itemAge);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Student student = studentList.get(position);
        holder.imgAvatar.setImageResource(student.getAvatar());
        holder.tvName.setText(student.getName());
        holder.tvAge.setText(student.getAge());
        return convertView;
    }

    static class ViewHolder {
        ImageView imgAvatar;

        TextView tvName, tvAge;
    }
}
