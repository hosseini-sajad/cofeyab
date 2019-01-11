package com.example.sajad.cofeyab.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sajad.cofeyab.R;
import com.example.sajad.cofeyab.activity.CofeDetail;
import com.example.sajad.cofeyab.model.Cofe;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sajad on 8/21/2018.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListViewHolder> {

    private List<Cofe> mCofes;
    private Context mContext;

    public RecyclerAdapter(List<Cofe> cofes, Context context) {
        mCofes = cofes;
        mContext = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cofees_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Cofe cofe = mCofes.get(position);
        holder.name.setText(cofe.getName());
        holder.location.setText(cofe.getLocation());
        Picasso.get().load(cofe.getImageUrl()).into(holder.image);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CofeDetail.class);
                intent.putExtra("name", cofe.getName());
                intent.putExtra("imageUrl", cofe.getImageUrl());
                intent.putExtra("location", cofe.getLocation());
                intent.putExtra("address", cofe.getAddress());
                intent.putExtra("phone", cofe.getPhone());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCofes.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView name;
        private TextView location;
        private ImageView image;
        private ConstraintLayout layout;

        public ListViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_of_cofe);
            location = itemView.findViewById(R.id.location_of_cofe);
            image = itemView.findViewById(R.id.image_of_cofe);
            layout = itemView.findViewById(R.id.cons_cofe);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }
    }
}
