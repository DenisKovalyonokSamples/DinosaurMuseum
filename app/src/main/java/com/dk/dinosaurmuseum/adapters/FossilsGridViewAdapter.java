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
        return 7;
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
            image.setImageResource(R.drawable.m_egypt);

            textName.setText("Egypt Coffins");
        }
        if (i == 1) {
            image.setImageResource(R.drawable.m_christians);

            textName.setText("Catholic Church");
            imageStatus.setImageResource(R.mipmap.fab_market_48dp);
        }
        if (i == 2) {
            image.setImageResource(R.drawable.m_greece);

            textName.setText("Ancient Greece");
            imageStatus.setImageResource(R.mipmap.fab_market_48dp);
        }
        if (i == 3) {
            image.setImageResource(R.drawable.m_buddas);

            textName.setText("Buddhism");
        }
        if (i == 4) {
            image.setImageResource(R.drawable.m_rome);

            textName.setText("The Roman Empire");
            imageStatus.setImageResource(R.mipmap.fab_market_48dp);
        }
        if (i == 5) {
            image.setImageResource(R.drawable.m_india_bundle);

            textName.setText("India");
        }
        if (i == 6) {
            image.setImageResource(R.drawable.m_knight_bundle);

            textName.setText("King Erik XIV");
            imageStatus.setImageResource(R.drawable.ic_cart_plus_24dp);
        }

        return view;
    }
}