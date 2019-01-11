package com.example.sajad.cofeyab.fragment;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.sajad.cofeyab.R;
import com.example.sajad.cofeyab.adapter.GrideAdapter;

/**
 * Created by sajad on 8/9/2018.
 */
public class Home extends Fragment{

    private GridView mGridView;
    private String[] lettersList = {"کافه های جدید", "کافه های پیشنهادی", "کافه های با غذا"};
    private int[] icons = {R.drawable.baseline_place_24, R.drawable.baseline_flag_24, R.drawable.baseline_restaurant_24};
    private FloatingActionButton currentLocation;
    private LocationManager mLocationManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        mGridView = view.findViewById(R.id.gridView);
        currentLocation = view.findViewById(R.id.current_location_fab);

        currentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        GrideAdapter adapter = new GrideAdapter(icons,lettersList, getContext());
        mGridView.setAdapter(adapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container_framelayout, new Cofees());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return view;
    }
}
