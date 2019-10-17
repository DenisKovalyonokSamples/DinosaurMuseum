package com.dk.dinosaurmuseum.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dk.dinosaurmuseum.R;

public class SkeletonsGridViewAdapter  extends BaseAdapter {
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
                    .inflate(R.layout.grid_cell_model, viewGroup, false);
        }

        ImageView image = (ImageView) view.findViewById(R.id.image);
        ImageView imageFavorite = (ImageView) view.findViewById(R.id.imageFavorite);
        ImageView imageDownload = (ImageView) view.findViewById(R.id.imageDownload);

        ImageView imageStatus = (ImageView) view.findViewById(R.id.imageStatus);
        TextView textName = (TextView) view.findViewById(R.id.textName);

        if (i == 0) {
            image.setImageResource(R.drawable.s_triceratops);

            textName.setText("Triceratops Skull");
        }
        if (i == 1) {
            image.setImageResource(R.drawable.s_gomphothere);
            imageFavorite.setImageResource(R.drawable.ic_favorite_filled);

            textName.setText("Gomphothere Skull");
        }
        if (i == 2) {
            image.setImageResource(R.drawable.s_teratophoneus);

            textName.setText("Teratophoneus Skull");
        }
        if (i == 3) {
            image.setImageResource(R.drawable.s_utahraptor);
            imageFavorite.setImageResource(R.drawable.ic_favorite_filled);
            imageStatus.setImageResource(R.mipmap.fab_market_48dp);

            textName.setText("Utahraptor");
        }

        return view;
    }
}
