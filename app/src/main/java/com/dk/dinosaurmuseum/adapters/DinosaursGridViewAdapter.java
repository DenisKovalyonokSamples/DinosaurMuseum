package com.dk.dinosaurmuseum.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dk.dinosaurmuseum.R;

public class DinosaursGridViewAdapter  extends BaseAdapter {
    @Override
    public int getCount() {
        return 8;
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

        ImageView image = view.findViewById(R.id.image);
        ImageView imageDownload = view.findViewById(R.id.imageDownload);
        ImageView imageStatus = view.findViewById(R.id.imageStatus);
        TextView textName = view.findViewById(R.id.textName);

        if (i == 0) {
            image.setImageResource(R.drawable.d_allosaurus);

            textName.setText("Allosaurus");
        }
        if (i == 1) {
            image.setImageResource(R.drawable.d_carnotaurus);

            textName.setText("Carnotaurus");
            imageStatus.setImageResource(R.mipmap.fab_market_48dp);
        }
        if (i == 2) {
            image.setImageResource(R.drawable.d_diabloceratops);

            textName.setText("Diabloceratops");
            imageStatus.setImageResource(R.mipmap.fab_market_48dp);
        }
        if (i == 3) {
            image.setImageResource(R.drawable.d_diplodocus);

            textName.setText("Diplodocus");
        }
        if (i == 4) {
            image.setImageResource(R.drawable.d_spinosaurus);

            textName.setText("Spinosaurus");
            imageStatus.setImageResource(R.mipmap.fab_market_48dp);
        }
        if (i == 5) {
            image.setImageResource(R.drawable.d_gorgosaurus);

            textName.setText("Gorgosaurus");
        }
        if (i == 6) {
            image.setImageResource(R.drawable.d_ceratosaurus);

            textName.setText("Ceratosaurus");
            imageStatus.setImageResource(R.drawable.ic_cart_plus_24dp);
        }

        if (i == 7) {
            image.setImageResource(R.drawable.d_cryolophosaurus);

            textName.setText("Cryolophosaurus");
            imageStatus.setImageResource(R.drawable.ic_cart_plus_24dp);
        }

        return view;
    }
}
