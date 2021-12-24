package com.example.listviewconcardviewsitem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.text.Editable;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
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
        lstEvalua.setItemAnimator(new DefaultItemAnimator());

        listaEva = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);

        stringRequest();
    }
    public void btnEvaluados(View view){
        Intent intent = new Intent(MainActivity.this,Main_elements_evaluados.class);
        TextView txtCedula = (TextView)findViewById(R.id.text_Cedula);
        Bundle datos = new Bundle();
        datos.putString("cedula", txtCedula.getText().toString());
        Log.d("DATOS", txtCedula.getText().toString());
        intent.putExtras(datos);

        startActivity(intent);

    }


    public void stringRequest(){

        String urlEvaluador ="https://www.uealecpeterson.net/ws/listadoevaluadores.php";

        StringRequest request = new StringRequest(Request.Method.GET,
                urlEvaluador,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            JSONArray jsonArray=  object.getJSONArray("listaaevaluador");

                            listaEva = Usuario.JsonObjectsBuild(jsonArray);
                            Adapter adapter = new Adapter(getApplicationContext(),listaEva);
                            int resId = R.anim.layout_animation_down_to_up;
                            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(),
                                    resId);
                            lstEvalua.setLayoutAnimation(animation);

                            lstEvalua.setAdapter(adapter);


                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
//                    public void onErrorResponse(VolleyError error) {
//
//                    }
                    public void onErrorResponse(final VolleyError error) {
                        if(error.networkResponse == null
                                && error instanceof NoConnectionError
                                && error.getMessage().contains("javax.net.ssl.SSLHandshakeException"))
                        {
                            // Se ha producido un error con el certificado SSL y la conexión ha sido
                            // rechazada
                        }
                    }
                }
        );
        requestQueue.add(request);
    }
}