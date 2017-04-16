package com.example.gautam.booksnbooks;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;

import com.example.gautam.booksnbooks.adapters.BooksBagViewAdapter;

import static android.os.Build.VERSION.SDK_INT;

public class BagActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BooksBagViewAdapter rviewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private FrameLayout apply_coupon_code,edit_coupon_code,coupon_code_applied;
    private CardView coupon_code_done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.bag_recycler_view);
        rviewAdapter = new BooksBagViewAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rviewAdapter);
        apply_coupon_code = (FrameLayout) findViewById(R.id.apply_coupon_code);
        edit_coupon_code = (FrameLayout) findViewById(R.id.edit_coupon_code);
        coupon_code_applied = (FrameLayout) findViewById(R.id.coupon_code_applied);
        coupon_code_done = (CardView) findViewById(R.id.coupon_code_done);

        apply_coupon_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SDK_INT >= 21) {
                    int cx = edit_coupon_code.getWidth() / 2;
                    int cy = edit_coupon_code.getHeight() / 2;

// get the final radius for the clipping circle
                    float finalRadius = (float) Math.hypot(cx, cy);

// create the animator for this view (the start radius is zero)
                    Animator anim =
                            ViewAnimationUtils.createCircularReveal(edit_coupon_code, cx, cy, 0, finalRadius);
// make the view visible and start the animation
                    v.setVisibility(View.INVISIBLE);
                    edit_coupon_code.setVisibility(View.VISIBLE);
                    anim.start();
                }else{
                    v.setVisibility(View.INVISIBLE);
                    edit_coupon_code.setVisibility(View.VISIBLE);
                }
            }
        });

        coupon_code_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SDK_INT >= 21) {
                    int cx = edit_coupon_code.getWidth() / 2;
                    int cy = edit_coupon_code.getHeight() / 2;

// get the final radius for the clipping circle
                    float initialRadius = (float) Math.hypot(cx, cy);

// create the animator for this view (the start radius is zero)
                    Animator anim =
                            ViewAnimationUtils.createCircularReveal(edit_coupon_code, cx, cy, initialRadius, 0);
// make the view visible and start the animation
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            edit_coupon_code.setVisibility(View.INVISIBLE);
                        }
                    });
                    coupon_code_applied.setVisibility(View.VISIBLE);
                    anim.start();
                }else{
                    edit_coupon_code.setVisibility(View.INVISIBLE);
                    coupon_code_applied.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
