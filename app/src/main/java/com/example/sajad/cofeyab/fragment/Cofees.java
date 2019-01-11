package com.example.sajad.cofeyab.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sajad.cofeyab.R;
import com.example.sajad.cofeyab.adapter.RecyclerAdapter;
import com.example.sajad.cofeyab.model.Cofe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajad on 8/21/2018.
 */
public class Cofees extends Fragment {

    private RecyclerView recyclerView;
    private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private List<Cofe> mCofes;
    private RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cofees, container, false);

        recyclerView = view.findViewById(R.id.recycler);
        mCofes = new ArrayList<>();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject jsonObjectRequest = null;
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                jsonObjectRequest = response.getJSONObject(i);
                                String name = jsonObjectRequest.getString("name");
                                String location = jsonObjectRequest.getString("categorie");
                                String telephone = jsonObjectRequest.getString("Rating");
                                String address = jsonObjectRequest.getString("studio");
                                String image_url = jsonObjectRequest.getString("img");

                                Cofe cofe = new Cofe(name, location, address, image_url, telephone);
                                mCofes.add(cofe);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        adapter = new RecyclerAdapter(mCofes, getContext());
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                        recyclerView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonArrayRequest);

        return view;
    }
}
