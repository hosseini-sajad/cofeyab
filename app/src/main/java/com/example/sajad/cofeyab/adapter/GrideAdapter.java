package com.example.sajad.cofeyab.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sajad.cofeyab.R;

/**
 * Created by sajad on 8/9/2018.
 */
public class GrideAdapter extends BaseAdapter {

    private int icons[];
    private String letters[];
    private Context mContext;

    public GrideAdapter(int[] icons, String[] letters, Context context) {
        this.icons = icons;
        this.letters = letters;
        mContext = context;
    }

    @Override
    public int getCount() {
        return letters.length;
    }

    @Override
    public Object getItem(int position) {
        return letters[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View gridView = view;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.grid_item, null);
            ImageView icon = gridView.findViewById(R.id.image_grid_item);
            TextView letter = gridView.findViewById(R.id.text_gride_item);

            icon.setImageResource(icons[position]);
            letter.setText(letters[position]);
        }else {
            gridView = (View) view;
        }



        return gridView;
    }
}
