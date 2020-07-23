package com.example.evaluacion_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.evaluacion_parcial.Interfaces.itf_paises;
import com.example.evaluacion_parcial.Modelos.Pais;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Implementación de retrofit para obtener los datos de los países
        Retrofit rf = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        itf_paises itf_Paises = rf.create(itf_paises.class);
        Call<List<Pais>> call = itf_Paises.getPaises();
        call.enqueue(new Callback<List<Pais>>() {
            @Override
            public void onResponse(Call<List<Pais>> call, Response<List<Pais>> response)
            {
                //Codigo de respuesta a la petición realizada
                String cod_respuesta = "Código "+response.code();
                //Definiendo donde se guardaran los valores obtenidos
                String valores ="";
                List<Pais> lista_paises = response.body();
                //Almacenando en la lista de tipo Bancos cada uno alojado en el JSON
                for(Pais pais: lista_paises){
                    valores+=pais.getName()+"\n";
                }
            }

            @Override
            public void onFailure(Call<List<Pais>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error, ",Toast.LENGTH_LONG).show();;
            }
        });
    }
}