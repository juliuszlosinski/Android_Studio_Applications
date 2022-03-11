package com.example.lab03_lists_juliusz_losinski;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student>
{
    private Context sContext;
    private List<Student> studentList;

    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        sContext=context;
        studentList=objects;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItem=convertView;
        if(listItem==null)
        {
            listItem= LayoutInflater.from(sContext).inflate(R.layout.list_item,parent, false);
        }

        TextView desc = (TextView) listItem.findViewById(R.id.textView_name);
        desc.setText(studentList.get(position).toString());

        ((ImageView)listItem.findViewById(R.id.avatar)).setImageResource(studentList.get(position).getPhoto());

        return listItem;
    }
}
