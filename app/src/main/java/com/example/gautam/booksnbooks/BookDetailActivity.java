package com.example.gautam.booksnbooks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.gautam.booksnbooks.adapters.BookPhotosAdapter;

public class BookDetailActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView recycler_view_book_photos;
    private BookPhotosAdapter re_adapter_book_photo;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        mToolbar = (Toolbar) findViewById(R.id.article_toolbar);
        setSupportActionBar(mToolbar);
        recycler_view_book_photos = (RecyclerView) findViewById(R.id.book_photos_view);
        re_adapter_book_photo = new BookPhotosAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recycler_view_book_photos.setLayoutManager(linearLayoutManager);
        recycler_view_book_photos.setAdapter(re_adapter_book_photo);
    }
}
