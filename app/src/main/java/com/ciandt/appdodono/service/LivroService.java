package com.ciandt.appdodono.service;


import com.ciandt.appdodono.model.LivrosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LivroService {

    @GET("volumes")
    Call<LivrosResponse> getLivrosPorTermo(@Query("q") String termo);
}
