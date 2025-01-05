package com.example.notesapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashSet;
import java.util.Set;

public class HomeActivity extends AppCompatActivity {

    TextInputEditText title,content;
    ImageButton bt_back,bt_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        title = findViewById(R.id.edit_text_title);
        content = findViewById(R.id.edit_text_content);

        bt_back = findViewById(R.id.bt_back);
        bt_submit = findViewById(R.id.bt_submit);

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("DBnotes",Context.MODE_PRIVATE);

       bt_back.setOnClickListener(v -> {
           finish();
       });

       bt_submit.setOnClickListener(v -> {

           String StrTitle = title.getText().toString();
           String StrContent = content.getText().toString();

           SharedPreferences.Editor editor = preferences.edit();

           editor.putString("title",StrTitle);
           editor.putString("content",StrContent);
           editor.apply();
           editor.commit();

           startActivity(new Intent(getApplicationContext(),MainActivity.class));
       });




    }
}
