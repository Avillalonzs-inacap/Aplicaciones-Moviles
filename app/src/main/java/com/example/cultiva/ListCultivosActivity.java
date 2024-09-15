package com.example.cultiva;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ListCultivosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cultivos);

        ArrayList<Cultivo> cultivos = (ArrayList<Cultivo>) getIntent().getSerializableExtra("cultivos");

        RecyclerView recyclerView = findViewById(R.id.recycler_view_cultivos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CultivoAdapter adapter = new CultivoAdapter(cultivos);
        recyclerView.setAdapter(adapter);
    }
}
