package com.example.gautam.booksnbooks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.gautam.booksnbooks.adapters.BookPhotosAdapter;

public class BookDetailActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private FrameLayout backGroundLayout;
    private Bitmap img;
    private RecyclerView recycler_view_book_photos;
    private BookPhotosAdapter re_adapter_book_photo;
    private LinearLayoutManager linearLayoutManager;
    private AppBarLayout appBarLayout;
    private CardView bookImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail_2);
        mToolbar = (Toolbar) findViewById(R.id.article_toolbar_1);
        appBarLayout = (AppBarLayout) findViewById(R.id.smooth_app_bar_layout);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        backGroundLayout = (FrameLayout) findViewById(R.id.back_ground_layout);
        img = BitmapFactory.decodeResource(getResources(), R.drawable.resized_harry);
        createPaletteAsync(img);
        recycler_view_book_photos = (RecyclerView) findViewById(R.id.book_photos_view_1);
        re_adapter_book_photo = new BookPhotosAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recycler_view_book_photos.setLayoutManager(linearLayoutManager);
        recycler_view_book_photos.setAdapter(re_adapter_book_photo);
        bookImageView = (CardView) findViewById(R.id.book_image_view);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float val =1.0f-(verticalOffset/(-523f));
                Log.d("Offset",""+verticalOffset+";"+val);
                bookImageView.setAlpha(val);
            }
        });
    }

    public void createPaletteAsync(Bitmap bitmap) {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette p) {
                // Use generated instance
                Palette.Swatch vibrant = p.getDarkVibrantSwatch();
                if (vibrant != null) {
                    backGroundLayout.setBackgroundColor(vibrant.getRgb());
                }
            }
        });
    }
}
