package com.example.krs.Admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.krs.Admin.Adapter.DosenAdapter;
import com.example.krs.Admin.Model.Dosen;
import com.example.krs.DataDosenService;
import com.example.krs.DefaultResult;
import com.example.krs.MainActivity;
import com.example.krs.R;
import com.example.krs.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecyclerViewDaftarDosen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DosenAdapter dosenAdapter;
    private ArrayList<Dosen> dosenList;
    ProgressDialog progressDialog;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucreate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu1) {
            Intent intent = new Intent(RecyclerViewDaftarDosen.this, CreateDosenActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_daftar_dosen);
        this.setTitle("SI KRS - Hai Admin");
        //tambahData();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        DataDosenService service = RetrofitClient.getRetrofitInstance().create(DataDosenService.class);
        Call<ArrayList<Dosen>> call = service.getDosenAll("72170148");
        call.enqueue(new Callback<ArrayList<Dosen>>() {
            @Override
            public void onResponse(Call<ArrayList<Dosen>> call, Response<ArrayList<Dosen>> response) {
                progressDialog.dismiss();

                recyclerView = findViewById(R.id.rvDosen);
                dosenAdapter = new DosenAdapter(response.body());

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerViewDaftarDosen.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(dosenAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Dosen>> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(RecyclerViewDaftarDosen.this, "Coba Lagi", Toast.LENGTH_SHORT);

            }
        });
    }

        private void insertDosen() {
            DataDosenService service = RetrofitClient.getRetrofitInstance().create(DataDosenService.class);
            Call<DefaultResult> call1 = service.insertDosen("Dorra", "72170148", "Seturan", "christian@si.ukdw.ac.id",
                    "S1", "dorra.jpg", "72170148");
            call1.enqueue(new Callback<DefaultResult>() {
                @Override
                public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                    System.out.println(response.body().getStatus());
                }

                @Override
                public void onFailure(Call<DefaultResult> call, Throwable t) {
                    System.out.println("message :" + t.getMessage());
                    Toast.makeText(RecyclerViewDaftarDosen.this,
                            "Something went wrong...Please try Later!", Toast.LENGTH_SHORT).show();
                }
            });






   /* private void tambahData(){s
        dosenList = new ArrayList<>();
        dosenList.add(new Dosen("123","Jong Jek Siang", "Proffesor","jjs@staff.ukdw.ac.id","YOGYAKARTA",R.drawable.logoku));
        dosenList.add(new Dosen("234","Yetli Oslan", "Proffesor","Yetli@staff.ukdw.ac.id","YOGYAKARTA",R.drawable.logoku));
        dosenList.add(new Dosen("345","Lussy", "Proffesor","Lussy@staff.ukdw.ac.id","YOGYAKARTA",R.drawable.logoku));
    } */

    }
}
