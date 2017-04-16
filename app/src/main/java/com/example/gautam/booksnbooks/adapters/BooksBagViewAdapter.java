package com.example.gautam.booksnbooks.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gautam.booksnbooks.R;

/**
 * Created by Gautam on 26/03/17.
 */

public class BooksBagViewAdapter extends RecyclerView.Adapter<BooksBagViewAdapter.BookBagViewHolder> {

    private LayoutInflater inflater;
    private Bitmap img;

    public BooksBagViewAdapter(Context context){
        inflater = inflater.from(context);
        img = BitmapFactory.decodeResource(context.getResources(), R.drawable.resized_harry);
    }

    @Override
    public BookBagViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.book_item_bag,parent,false);
        BookBagViewHolder viewHolder = new BookBagViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BookBagViewHolder holder, int position) {
        final GradientDrawable gd = new GradientDrawable();
        Palette.from(img).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette p) {
                // Use generated instance
               /* List<Palette.Swatch> swatches = p.getSwatches();
                int max = 0;
                int max2 = 0;
                int color1 = 0;
                int color2 = 0;
                for (int i=0;i<swatches.size();++i) {
                    Palette.Swatch swatch = swatches.get(i);
                    if (swatch != null) {
                        if(swatch.getPopulation()>max){
                            color2 = color1;
                            color1 = swatch.getRgb();
                        }
                    }
                }
                gd.setOrientation(GradientDrawable.Orientation.BL_TR);
                gd.setColors(new int[] {color1,0xFFFFFF} );
                holder.card_bacground_view.setBackground(gd);*/
                int color1 = 0;
                int color2 = 0;
                color1 = p.getDarkVibrantColor(Color.RED);
                color2 = p.getDarkMutedColor(Color.TRANSPARENT);
                gd.setOrientation(GradientDrawable.Orientation.BL_TR);
                gd.setColors(new int[] {color1,color2} );
                holder.card_bacground_view.setBackground(gd);

            }
        });
        gd.setCornerRadius(0f);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class BookBagViewHolder extends RecyclerView.ViewHolder{

        TextView original_price;
        View card_bacground_view;

        public BookBagViewHolder(View itemView) {
            super(itemView);
            card_bacground_view = itemView.findViewById(R.id.card_background_view);
            original_price = (TextView) itemView.findViewById(R.id.original_price);
            original_price.setPaintFlags(original_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        }
    }
}
