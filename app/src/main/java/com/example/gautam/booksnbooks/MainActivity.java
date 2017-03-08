package com.example.gautam.booksnbooks;

import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.gautam.booksnbooks.adapters.BooksHorizontalAdapter;
import com.example.gautam.booksnbooks.models.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private CoordinatorLayout mCoordinator;
    private RecyclerView recyclerView1,recyclerView2;
    private LinearLayoutManager linearLayoutManager,linearLayoutManager1;
    private BooksHorizontalAdapter rViewAdapter;
    private List<Book> bookList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCoordinator = (CoordinatorLayout) findViewById(R.id.root_coordinator);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        recyclerView1 = (RecyclerView) findViewById(R.id.novels_recycler_view);
        recyclerView2 = (RecyclerView) findViewById(R.id.study_books_recycler_view);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        linearLayoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rViewAdapter = new BooksHorizontalAdapter(this,bookList);
        recyclerView1.setLayoutManager(linearLayoutManager);
        recyclerView1.setAdapter(rViewAdapter);
        recyclerView2.setLayoutManager(linearLayoutManager1);
        recyclerView2.setAdapter(rViewAdapter);
    }
}
