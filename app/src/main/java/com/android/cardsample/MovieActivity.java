package com.android.cardsample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import adapter.CustomAdapter;
import networking.GsonRequestVolley;
import networking.URL;

public class MovieActivity extends AppCompatActivity {

    private RequestQueue queue;
    private ListView listView;
    private CustomAdapter movieAdapter;
    public RecyclerView recList;
    public RecyclerView.Adapter mAdapter;
    private ArrayList<com.android.cardsample.Movies> movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_moviecards);
        queue = Volley.newRequestQueue(this);
        GsonRequestVolley<com.android.cardsample.MovieDetails> gsonReq = new GsonRequestVolley<com.android.cardsample.MovieDetails>(URL.movieJsonUrl, com.android.cardsample.MovieDetails.class, null, new Response.Listener<com.android.cardsample.MovieDetails>() {
            @Override
            public void onResponse(com.android.cardsample.MovieDetails movieDetails) {
                movies = movieDetails.getMovies();
                recList = (RecyclerView) findViewById(R.id.cardListMovies);
                recList.setHasFixedSize(true);
                LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                recList.setLayoutManager(llm);
                mAdapter = new CustomAdapter(movies);
                recList.setAdapter(null);
                recList.setAdapter(mAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(gsonReq);
    }
}
