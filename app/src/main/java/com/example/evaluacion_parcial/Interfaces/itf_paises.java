package com.example.evaluacion_parcial.Interfaces;

import com.example.evaluacion_parcial.Modelos.Pais;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface itf_paises {
    @GET("rest/v2/all")
    Call<List<Pais>> getPaises();
}
