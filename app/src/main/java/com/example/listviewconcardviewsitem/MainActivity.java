package com.example.listviewconcardviewsitem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView lstEvalua;
    private Usuario usuario;
    private ArrayList<Usuario> listaEva;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstEvalua = (RecyclerView) findViewById(R.id.lst_Evaluadores);
        lstEvalua.setHasFixedSize(true);
        lstEvalua.setLayoutManager( new LinearLayoutManager(this));

        listaEva = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);

        stringRequest();
    }


    public void stringRequest(){

        String urlEvaluador ="https://www.uealecpeterson.net/ws/listadoevaluadores.php";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlEvaluador, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("listaaevaluador");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject data = jsonArray.getJSONObject(i);
                                String Nombre =(String) data.get("nombres");
                                String Cargo = (String) data.get("area");
                                String Url = urlEvaluador;

                                usuario = new Usuario(Nombre,Cargo,Url);
                            }
                            listaEva.add(usuario);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}