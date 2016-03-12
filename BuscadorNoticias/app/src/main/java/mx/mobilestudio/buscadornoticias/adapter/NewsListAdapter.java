package mx.mobilestudio.buscadornoticias.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mx.mobilestudio.buscadornoticias.R;
import mx.mobilestudio.buscadornoticias.dto.GoogleNewsServiceResponse;

/**
 * Created by mobile on 3/5/16.
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {


    private GoogleNewsServiceResponse googleNewsServiceResponse;

    public NewsListAdapter(GoogleNewsServiceResponse googleNewsServiceResponse) {
        this.googleNewsServiceResponse = googleNewsServiceResponse;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Generate the View
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_news_item,parent,false);

        //Generate ViewHolder
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//Metodo donde seteo los datos a la vista

        String title =googleNewsServiceResponse.getResponseData().getResults().get(position).getTitleNoFormatting();

        holder.textView.setText(title);

    }

    @Override
    public int getItemCount() {
        return googleNewsServiceResponse.getResponseData().getResults().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

                textView = (TextView) itemView.findViewById(R.id.news_title);
                imageView = (ImageView) itemView.findViewById(R.id.news_image);
        }
    }
}
