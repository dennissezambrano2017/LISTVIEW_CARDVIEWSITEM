package com.example.listviewconcardviewsitem;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main_elements_evaluados extends AppCompatActivity {
    private RecyclerView lstEvalua;
    private ArrayList<UsuarioEvalu> listaEvalu;
    private RequestQueue requestQueue;
    String URL = "https://uealecpeterson.net/ws/listadoaevaluar.php?e=";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluados);

        lstEvalua = (RecyclerView) findViewById(R.id.lst_eva);
        lstEvalua.setHasFixedSize(true);
        lstEvalua.setLayoutManager(new LinearLayoutManager(this));
        lstEvalua.setItemAnimator(new DefaultItemAnimator());

        listaEvalu = new ArrayList<>();

        Bundle bundle=this.getIntent().getExtras();

        String id = bundle.getString("cedula");
        Log.d("DATOS", id);

        requestQueue = Volley.newRequestQueue(this);
        stringRequest(id);


    }
    public void stringRequest(String id){
        StringRequest request = new StringRequest(Request.Method.GET,
            URL + id,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject object = new JSONObject(response);
                        JSONArray JSONlista=  object.getJSONArray("listaaevaluar");

                        listaEvalu = UsuarioEvalu.JsonObjectsBuild(JSONlista);

                        AdpterSecundario adapter = new AdpterSecundario(getApplicationContext(), listaEvalu);

                        int resId = R.anim.layout_animation_down_to_up;
                        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                                resId);
                        lstEvalua.setLayoutAnimation(animation);

                        lstEvalua.setAdapter(adapter);


                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(error.networkResponse == null
                        && error instanceof NoConnectionError
                        && error.getMessage().contains("javax.net.ssl.SSLHandshakeException"));
            }
        });
       requestQueue.add(request);
    }
}
