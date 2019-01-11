package com.example.sajad.cofeyab.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sajad.cofeyab.R;
import com.example.sajad.cofeyab.fragment.MapsActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by sajad on 8/21/2018.
 */
public class CofeDetail extends AppCompatActivity {

    private Button mapButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cofe_detail);

        ImageView imageView = findViewById(R.id.image_of_cofeDetail);
        TextView name = findViewById(R.id.name_of_cofeDetail);
        TextView location = findViewById(R.id.location_of_cofeDetail);
        TextView phone = findViewById(R.id.phone_of_cofeDetail);
        TextView address = findViewById(R.id.address_of_cofeDetail);

        Picasso.get().load(getIntent().getStringExtra("imageUrl")).into(imageView);
        name.setText(getIntent().getStringExtra("name"));
        location.setText(getIntent().getStringExtra("location"));
        phone.setText(getIntent().getStringExtra("phone"));
        address.setText(getIntent().getStringExtra("address"));

        mapButton = findViewById(R.id.map_btn);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CofeDetail.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
