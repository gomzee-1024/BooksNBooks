package com.example.gautam.booksnbooks;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.gautam.booksnbooks.adapters.BooksSearchViewAdapter;

import static android.os.Build.VERSION.SDK_INT;

public class SearchActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText search_edit_text;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private BooksSearchViewAdapter rViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        if(SDK_INT>=21){
            getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition_1));
            //getWindow().setSharedElementReturnTransition(null);
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar_activity_search);
        search_edit_text = (EditText) findViewById(R.id.search_edit_text);
        setSupportActionBar(toolbar);
        search_edit_text.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

        recyclerView = (RecyclerView) findViewById(R.id.search_recycler_view);
        rViewAdapter = new BooksSearchViewAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rViewAdapter);
       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public void onBackPressed() {
        if(SDK_INT>=21){
            toolbar.setTransitionGroup(true);
        }
        super.onBackPressed();
    }
}
