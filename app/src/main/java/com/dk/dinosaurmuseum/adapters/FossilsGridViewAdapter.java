package com.dk.dinosaurmuseum.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dk.dinosaurmuseum.R;

public class FossilsGridViewAdapter  extends BaseAdapter {
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int i) {
        return "Item " + String.valueOf(i + 1);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.grid_cell_category, viewGroup, false);
        }

        ImageView image = (ImageView) view.findViewById(R.id.image);
        ImageView imageDownload = (ImageView) view.findViewById(R.id.imageDownload);

        ImageView imageStatus = (ImageView) view.findViewById(R.id.imageStatus);
        TextView textName = (TextView) view.findViewById(R.id.textName);

        if (i == 0) {
            image.setImageResource(R.drawable.f_shark);

            textName.setText("Shark");
        }
        if (i == 1) {
            image.setImageResource(R.drawable.f_stegosaurus);

            textName.setText("Stegosaurus");
            imageStatus.setImageResource(R.mipmap.fab_market_48dp);
        }
        if (i == 2) {
            image.setImageResource(R.drawable.f_coelophysis_2);

            textName.setText("Coelophysis");
            imageStatus.setImageResource(R.mipmap.fab_market_48dp);
        }
        if (i == 3) {
            image.setImageResource(R.drawable.f_coelophysis);

            textName.setText("Coelophysis");
        }

        return view;
    }
}