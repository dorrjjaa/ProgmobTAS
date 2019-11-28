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

import com.example.krs.Admin.Adapter.MahasiswaAdapter;
import com.example.krs.Admin.Model.Mahasiswa;
import com.example.krs.R;

import java.util.ArrayList;

public class RecyclerViewDaftarMahasiswa extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucreate,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu1){
            Intent intent = new Intent(RecyclerViewDaftarMahasiswa.this,CreateMahasiswaActivity.class);
            startActivity(intent);
        }
        return  true;
    }

    private RecyclerView recyclerView;
    private MahasiswaAdapter mhsAdapter;
    private ArrayList<Mahasiswa> mhsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_daftar_mahasiswa);
        this.setTitle("SI KRS - Hai Admin");
        tambahData();

        recyclerView = findViewById(R.id.rvMhs);
        mhsAdapter = new MahasiswaAdapter(mhsList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerViewDaftarMahasiswa.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mhsAdapter);
    }

    private void tambahData(){
        mhsList = new ArrayList<>();
        mhsList.add(new Mahasiswa("72170148","Christian Dorra","christian.dorra@si.ukdw.ac.id","Seturan Raya",R.drawable.diri));
        mhsList.add(new Mahasiswa("72170146","Angkie W","kie@si.ukdw.ac.id","Klitren",R.drawable.diri));
        mhsList.add(new Mahasiswa("72170125","Adrian P","drian@si.ukdw.ac.id","Mergangsan",R.drawable.diri));
        mhsList.add(new Mahasiswa("72170168","Aristyo Agung","agung@si.ukdw.ac.id","Kota Gede",R.drawable.diri));
        mhsList.add(new Mahasiswa("72170172","Putu Abdi","abdi@si.ukdw.ac.id","Jl Solo",R.drawable.diri));
    }
}
