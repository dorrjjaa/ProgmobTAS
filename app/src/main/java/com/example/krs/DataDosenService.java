package com.example.krs;

import com.example.krs.Admin.Model.Dosen;
import com.example.krs.Admin.Model.Dosen;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DataDosenService {
    @GET("/api/progmob/dosen/{nim_progmob}")
    Call<ArrayList<Dosen>> getDosenAll(@Path("nim_progmob") String nim_progmob);
}
