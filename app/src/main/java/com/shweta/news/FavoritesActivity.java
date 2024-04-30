package com.shweta.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.shweta.news.helpers.SharedPrefs;
import com.shweta.news.model.FavoriteModel;
import com.shweta.news.model.NewsHeadlines;
import com.shweta.news.model.Source;

import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String title,name,urlToImage;
    FavoriteAdapter adapter;
    Source source;
    NewsHeadlines newsHeadlines;
    public FavoritesActivity(Object object, String title,String name,String urlToImage) {
        if (object instanceof Source)
            this.source = (Source) object;
        if (object instanceof NewsHeadlines)
            this.newsHeadlines = (NewsHeadlines) object;

        this.title = title;
        this.name = name;
        this.urlToImage = urlToImage;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        recyclerView = findViewById(R.id.rv_fav);

        List<FavoriteModel> favList= SharedPrefs.getInstance().getFavList(SharedPrefs.KEY_SAVED);
        if(favList!=null)
            getFavList(favList);
    }
    private void getFavList(List<FavoriteModel> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new FavoriteAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

}