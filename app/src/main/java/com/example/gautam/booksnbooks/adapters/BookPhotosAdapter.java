package com.example.gautam.booksnbooks.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gautam.booksnbooks.R;

/**
 * Created by Gautam on 07/03/17.
 */

public class BookPhotosAdapter extends RecyclerView.Adapter<BookPhotosAdapter.BookPhotoHolder> {

    private Context context;
    private LayoutInflater inflater;

    public BookPhotosAdapter(Context context){
        this.context = context;
        inflater = inflater.from(context);
    }

    @Override
    public BookPhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.book_photo_item,parent,false);
        BookPhotoHolder holderSmall = new BookPhotoHolder(v);
        return holderSmall;
    }

    @Override
    public void onBindViewHolder(BookPhotoHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class BookPhotoHolder extends RecyclerView.ViewHolder{

        public BookPhotoHolder(View itemView) {
            super(itemView);
        }
    }
}
