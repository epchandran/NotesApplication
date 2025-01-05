package com.example.notesapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        ListView listView = findViewById(R.id.listView);
        TextView textView = findViewById(R.id.view);
        FloatingActionButton bt_newNode = findViewById(R.id.bt_newNode);

        textView.setVisibility(View.INVISIBLE);

        bt_newNode.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        });

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("DBnotes",Context.MODE_PRIVATE);

        String StrTitle = preferences.getString("title","");
        String StrContent = preferences.getString("content","");

        Data data = new Data(StrTitle,StrContent);

        List<Data> list = new ArrayList<>();

        list.add(data);

        if (list == null){
            textView.setVisibility(View.VISIBLE);


            return;
        }

        NotesListAdapter adapter = new NotesListAdapter(this,R.layout.list_item,list);
        listView.setAdapter(adapter);
    }
}