package com.example.newsapi;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private Context context;
    private ArrayList<Article> articlesList;
    Button readMore;


    public class ArticleViewHolder  extends RecyclerView.ViewHolder{
        private TextView author, title, description;
        public ArticleViewHolder (View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            readMore = itemView.findViewById(R.id.readMore);


        }
    }


    public ArticleAdapter(Context context, ArrayList<Article> articlesList){
        this.articlesList = articlesList;
        this.context = context;
    }


    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.news, null, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article model = articlesList.get(position);

        holder.author.setText("" + model.getAuthor());
        holder.title.setText("" + model.getTitle());
        holder.description.setText("" + model.getDescription());

    }



    @Override
    public int getItemCount() {
        return articlesList.size();
    }

}
