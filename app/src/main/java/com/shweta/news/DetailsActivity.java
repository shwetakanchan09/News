package com.shweta.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shweta.news.helpers.SharedPrefs;
import com.shweta.news.model.FavoriteModel;
import com.shweta.news.model.NewsHeadlines;
import com.shweta.news.model.Source;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    NewsHeadlines headlines;
    TextView txt_title, txt_author,txt_time,txt_detail,txt_content;
    ImageView img_news,back;
    AppCompatButton btn_fav;

    String title,name,urlToImage;

    Source source;
    NewsHeadlines newsHeadlines;
/*
    public DetailsActivity(Object object, String title,String name,String urlToImage) {
        if (object instanceof Source)
            this.source = (Source) object;
        if (object instanceof NewsHeadlines)
            this.newsHeadlines = (NewsHeadlines) object;

        this.title = title;
        this.name = name;
        this.urlToImage = urlToImage;
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        back = findViewById(R.id.back);

        txt_title = findViewById(R.id.text_detail_title);
        txt_author = findViewById(R.id.text_detail_author);
        txt_time = findViewById(R.id.text_detail_time);
        txt_detail = findViewById(R.id.text_detail_detail);
        txt_content = findViewById(R.id.text_detail_content);
        img_news = findViewById(R.id.img_detail_news);
        btn_fav = findViewById(R.id.btn_fav);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(intent);*/
                finish();
            }
        });

        btn_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<FavoriteModel> favoriteList= SharedPrefs.getInstance().getFavList(SharedPrefs.KEY_FAVORITE);
                if (favoriteList!=null){
                    FavoriteModel model = new FavoriteModel(headlines.getTitle(), headlines.getUrlToImage(),headlines.getAuthor());
                    favoriteList.add(model);
                    SharedPrefs.getInstance().saveFavList(favoriteList,SharedPrefs.KEY_FAVORITE);

                    Toast.makeText(DetailsActivity.this, "Add to Favorite", Toast.LENGTH_SHORT).show();

                }

            }
        });

        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_time.setText(headlines.getPublishedAt());
        txt_detail.setText(headlines.getDescription());
        txt_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);
    }


}