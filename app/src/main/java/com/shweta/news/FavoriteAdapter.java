package com.shweta.news;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shweta.news.model.FavoriteModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder>{
    Context context;
    List<FavoriteModel> arrayList;
    public FavoriteAdapter(Context context, List<FavoriteModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.headline_list_items, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {
        FavoriteModel model = arrayList.get(position);
        holder.text_title.setText(model.getTitle());
        holder.text_source.setText(model.getName());
        if (arrayList.get(position).getUrlToImage()!=null) {
            Picasso.get().load(arrayList.get(position).getUrlToImage()).into(holder.img_headline);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_headline;
        TextView text_title;
        TextView text_source;
        CardView main_container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.text_title);
            img_headline = itemView.findViewById(R.id.img_headline);
            text_source = itemView.findViewById(R.id.text_source);
            main_container = itemView.findViewById(R.id.main_container);

            main_container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FavoriteModel model= arrayList.get(getAdapterPosition());
                    Intent i = new Intent(context,FavoritesActivity.class);
                    i.putExtra("title",model.getTitle());
                    context.startActivity(i);
                  //  Common.openFragment(new FullScreenVideoFragment(model,model.getId(), model.getVideoLink(), model.getTitle(), model.getImage()));

                }
            });
        }
    }
}
