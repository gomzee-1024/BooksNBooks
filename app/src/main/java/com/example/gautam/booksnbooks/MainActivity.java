package com.example.gautam.booksnbooks;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.gautam.booksnbooks.adapters.BooksHorizontalAdapter;
import com.example.gautam.booksnbooks.models.Book;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION.SDK_INT;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private CoordinatorLayout mCoordinator;
    private RecyclerView recyclerView1,recyclerView2;
    private LinearLayoutManager linearLayoutManager,linearLayoutManager1;
    private BooksHorizontalAdapter rViewAdapter;
    private List<Book> bookList = new ArrayList<>();
    private CardView search_bar_card;
    private Button bag_button;
    //private ActionMenuView amvMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(SDK_INT>=21){
            getWindow().setSharedElementExitTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition_1));
           // getWindow().setSharedElementReenterTransition(null);
        }
        search_bar_card = (CardView) findViewById(R.id.search_view);
        mCoordinator = (CoordinatorLayout) findViewById(R.id.root_coordinator);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        bag_button = (Button) findViewById(R.id.bag_button);
       // amvMenu = (ActionMenuView) mToolbar.findViewById(R.id.amvMenu);
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
        search_bar_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SDK_INT>=21) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, v, v.getTransitionName());
                    Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                    startActivity(intent,options.toBundle());

                }
                else{
                    Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                    startActivity(intent);
                }
            }
        });

        bag_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BagActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_main,amvMenu.getMenu());
        return true;
    }
}
