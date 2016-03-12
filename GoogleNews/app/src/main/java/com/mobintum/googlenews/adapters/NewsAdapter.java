package com.mobintum.googlenews.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobintum.googlenews.R;
import com.mobintum.googlenews.models.GoogleNews;
import com.squareup.picasso.Picasso;

import java.util.List;
/**
 * Created by Rick on 12/03/16.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<GoogleNews> objects;
    private Context context;

    public NewsAdapter(List<GoogleNews> objects, Context context) {
        this.objects = objects;
        this.context = context;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_news,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        final GoogleNews googleNews = objects.get(position);
        holder.txtTitle.setText(googleNews.getTitleNoFormatting());
        if(googleNews.getImage()!=null)
            Picasso.with(context).load(googleNews.getImage().getUrl()).into(holder.imgNews);
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgNews;
        TextView txtTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            imgNews = (ImageView) itemView.findViewById(R.id.imgNews);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
        }
    }
}
