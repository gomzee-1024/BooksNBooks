package com.example.gautam.booksnbooks.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gautam.booksnbooks.R;
import com.example.gautam.booksnbooks.models.Book;

import java.util.List;

/**
 * Created by Gautam on 04/03/17.
 */

public class BooksHorizontalAdapter extends RecyclerView.Adapter<BooksHorizontalAdapter.BooksHolderSmall> {

    private List<Book> bookList;
    private Context context;
    private LayoutInflater inflater;

    public BooksHorizontalAdapter(Context context, List<Book> bookList){
        this.context = context;
        this.bookList = bookList;
        inflater = inflater.from(context);
    }

    @Override
    public BooksHolderSmall onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.book_item_small,parent,false);
        BooksHolderSmall holderSmall = new BooksHolderSmall(v);
        return holderSmall;
    }

    @Override
    public void onBindViewHolder(BooksHolderSmall holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class BooksHolderSmall extends RecyclerView.ViewHolder{

        public BooksHolderSmall(View itemView) {
            super(itemView);
        }
    }
}
