package com.example.krs.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krs.Admin.Adapter.KrsAdapter;
import com.example.krs.Admin.Model.Krs;
import com.example.krs.R;

import java.util.ArrayList;

public class RecyclerViewKrs extends AppCompatActivity {

    private RecyclerView recyclerView;
    private KrsAdapter krsAdapter;
    private ArrayList<Krs> krsArrayList;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucreate,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu1){
            Intent intent = new Intent(RecyclerViewKrs.this, CreateKrsActivity.class);
            startActivity(intent);
        }
        return  true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_krs);
        this.setTitle("SI KRS - Hai Admin");

        tambahData();

        recyclerView = findViewById(R.id.rvKrs);
        krsAdapter = new KrsAdapter(krsArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerViewKrs.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(krsAdapter);

    }

    public void tambahData(){
        krsArrayList = new ArrayList<>();
        krsArrayList.add(new Krs("SI4323","MANPROY","Senin","3","3","Lussy Emawati","60"));
        krsArrayList.add(new Krs("SI3343","KEAMANAN TI","Senin","3","2","Willy Sudiarto","50"));
        krsArrayList.add(new Krs("SI3353","MRTI","Rabu","3","4","Dika","60"));
        krsArrayList.add(new Krs("SI3313","MLTI","Kamis","3","2","Wimmie Handi","60"));
        krsArrayList.add(new Krs("SI3333","PROGMOB","Jumat","3","4","I Kadek Dendy","23"));
    }
}
