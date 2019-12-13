package com.example.krs.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.krs.R;

public class CreateDosenActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editNama, editNidn, editAlamat, editEmail, editGelar;
    Button buttonSubmit;

    String textNama, textNIDN, textAlamat, textEmail, textGelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dosen);
        this.setTitle("SI KRS - Hai Admin");

        editNama = findViewById(R.id.editText);
        editNidn = findViewById(R.id.editText2);
        editAlamat = findViewById(R.id.editText6);
        editEmail = findViewById(R.id.editText5);
        editGelar = findViewById(R.id.editText7);
        buttonSubmit = findViewById(R.id.btnSimpanDosen);
        buttonSubmit.setOnClickListener(this);

    }
    public void onClick(View view){
        validasiData();
    }
    public void validasiData(){
        textEmail = editEmail.getText().toString();
        textNama  = editNama.getText().toString();
        textAlamat = editAlamat.getText().toString();
        textGelar = editGelar.getText().toString();
        textNIDN = editNidn.getText().toString();

        if(TextUtils.isEmpty(textNama)){
            editNama.setError("Nama tidak boleh Kosong!");
        }
        if
        (TextUtils.isEmpty(textEmail)){
            editEmail.setError("Email tidak boleh kosong");

        }
        if(TextUtils.isEmpty(textNIDN)) {
            editNidn.setError("NIDN tidak boleh kosong!");
        }
        if(TextUtils.isEmpty(textAlamat)) {
            editAlamat.setError("Silahkan Mengisi Alamat Dosen");
        }
        if(TextUtils.isEmpty(textGelar)) {
            editGelar.setError("NIDN tidak boleh kosong!");
        }



    }
}
