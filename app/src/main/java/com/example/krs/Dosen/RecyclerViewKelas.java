package com.example.krs.Dosen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krs.Dosen.Adapter.KelasAdapter;
import com.example.krs.Dosen.Model.Kelas;
import com.example.krs.R;

import java.util.ArrayList;

public class RecyclerViewKelas extends AppCompatActivity {

    private RecyclerView recyclerView;
    private KelasAdapter kelasAdapter;
    private ArrayList<Kelas> kelasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_kelas);

        this.setTitle("SI KRS - Hai Mahasiswa");

        tambahData();

        recyclerView = findViewById(R.id.rvKelas);
        kelasAdapter = new KelasAdapter(kelasList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerViewKelas.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(kelasAdapter);
    }

    public void tambahData(){
        kelasList = new ArrayList<>();
        kelasList.add(new Kelas("SI001","Dasar-Dasar Pemograman","3","Senin","Katon Wijana","50"));
        kelasList.add(new Kelas("SI002","Prakt-DDP","3","Senin","Katon Wijana","50"));
        kelasList.add(new Kelas("SI003","Matrikulasi","3","Selasa","Jong Jek Siang","55"));
        kelasList.add(new Kelas("SI004","Konsep SI","3","Rabu","Umi Proboyekti","45"));
    }
}
