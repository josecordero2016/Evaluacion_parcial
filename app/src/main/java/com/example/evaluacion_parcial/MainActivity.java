package com.example.evaluacion_parcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.evaluacion_parcial.Adaptadores.adt_paises;
import com.example.evaluacion_parcial.Interfaces.itf_paises;
import com.example.evaluacion_parcial.Modelos.Pais;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements adt_paises.OnNoteListener {

    RecyclerView rclListado;
    List<Pais> paises_arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rclListado = (RecyclerView)findViewById(R.id.rclListado);
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
                try{
                //Codigo de respuesta a la petición realizada
                String cod_respuesta = "Código " + response.code();
                //Definiendo donde se guardaran los valores obtenidos
                String valores = "";
                //Creando array con datos de cada país
                paises_arr = response.body();
                //Configuración del recyclerview
                LinearLayoutManager linear = new LinearLayoutManager(getApplicationContext());
                linear.setOrientation(LinearLayoutManager.VERTICAL);
                rclListado.setLayoutManager(linear);
                adt_paises adaptador = new adt_paises(paises_arr);
                rclListado.setAdapter(adaptador);}
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<List<Pais>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error, ",Toast.LENGTH_LONG).show();;
            }
        });
    }

    @Override
    public void onNoteClick(int position) {
        paises_arr.get(position);
        Toast.makeText(getApplicationContext(), paises_arr.get(position).getName(),Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,Detalles.class);
        startActivity(intent);
    }
}