package com.example.notesapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class NotesListAdapter extends ArrayAdapter<Data> {

    private List<Data> list;
    int resource;
    public NotesListAdapter(@NonNull Context context, int resource, @NonNull List<Data> list) {
        super(context, resource, list);
        this.list = list;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Data item = list.get(position);

        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        }

        TextView title = convertView.findViewById(R.id.view_title);
        TextView content = convertView.findViewById(R.id.view_content);

        title.setText(item.title);
        content.setText(item.content);

        return convertView;
    }
}
