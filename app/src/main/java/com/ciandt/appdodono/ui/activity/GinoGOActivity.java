package com.ciandt.appdodono.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.ciandt.appdodono.LivrosAdapter;
import com.ciandt.appdodono.R;
import com.ciandt.appdodono.model.Livro;
import com.ciandt.appdodono.model.LivrosResponse;
import com.ciandt.appdodono.service.LivroService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GinoGOActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gino_go);

        String sHomenagem = getIntent().getStringExtra("sHomenagem");
        final ListView listViewLivro = (ListView) findViewById(R.id.listViewLivros);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LivroService service = retrofit.create(LivroService.class);

        Call<LivrosResponse> call = service.getLivrosPorTermo(sHomenagem);
        call.enqueue(new Callback<LivrosResponse>() {
            @Override
            public void onResponse(Call<LivrosResponse> call, Response<LivrosResponse> response) {
                List<Livro> livros = response.body().getLivros();

                listViewLivro.setAdapter(new LivrosAdapter(livros, GinoGOActivity.this));



            }

            @Override
            public void onFailure(Call<LivrosResponse> call, Throwable t) {

            }
        });


    }




}


