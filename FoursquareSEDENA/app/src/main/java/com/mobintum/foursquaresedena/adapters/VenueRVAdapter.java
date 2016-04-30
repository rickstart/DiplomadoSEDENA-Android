package com.mobintum.foursquaresedena.adapters;

import android.content.Context;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobintum.foursquaresedena.R;
import com.mobintum.foursquaresedena.fragments.DialogMapFragment;
import com.mobintum.foursquaresedena.fragments.RvVenuesFragment;
import com.mobintum.foursquaresedena.models.Category;
import com.mobintum.foursquaresedena.models.Venue;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Rick on 30/04/16.
 */
public class VenueRVAdapter extends RecyclerView.Adapter<VenueRVAdapter.ViewHolder> {

    private List<Venue> venues;
    private Context context;
    private Fragment fragment;

    public VenueRVAdapter(List<Venue> venues, Fragment fragment) {
        this.venues = venues;
        this.fragment = fragment;

    }

    @Override
    public VenueRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_venue, parent, false);
        this.context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final VenueRVAdapter.ViewHolder holder, int position) {
        final Venue venue = venues.get(position);
        holder.txtVenueName.setText(venue.getName());
        if(venue.getCategories()!=null){
            if(venue.getCategories().size()>0) {
                Category category = venue.getCategories().get(0);
                Log.e("DEBUG", category.getIcon().getPrefix() + category.getIcon().getSuffix());
                Picasso.with(context).load(category.getIcon().getPrefix() + "32" + category.getIcon().getSuffix()).into(holder.imgVenue);
            }
        }


        holder.btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.layoutStats.getVisibility()==View.VISIBLE)
                    holder.layoutStats.setVisibility(View.GONE);
                else {
                    holder.layoutStats.setVisibility(View.VISIBLE);
                    if(venue.getStats()!=null) {
                        holder.txtUsers.setText(""+venue.getStats().getUsersCount());
                        holder.txtCheckIns.setText(""+venue.getStats().getCheckinsCount());
                        holder.txtTips.setText(""+venue.getStats().getTipCount());
                    }
                }

            }
        });

        holder.btnLocMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DialogMapFragment fragmentDialog = DialogMapFragment.newInstance(venue);
                RvVenuesFragment rvVenuesFragment = (RvVenuesFragment) fragment;
                fragmentDialog.setTargetFragment(rvVenuesFragment, 1);
                fragmentDialog.show(fragment.getChildFragmentManager(), DialogMapFragment.TAG);
            }
        });

    }

    @Override
    public int getItemCount() {
        return venues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtVenueName, txtUsers, txtCheckIns, txtTips;
        ImageView imgVenue;
        ImageButton btnLocMap, btnStats;
        LinearLayout layoutStats;

        public ViewHolder(View itemView) {
            super(itemView);
            txtVenueName = (TextView) itemView.findViewById(R.id.txtVenueName);
            txtUsers = (TextView) itemView.findViewById(R.id.txtUsers);
            txtCheckIns = (TextView) itemView.findViewById(R.id.txtCheckIns);
            txtTips = (TextView) itemView.findViewById(R.id.txtTips);
            imgVenue = (ImageView) itemView.findViewById(R.id.imgVenue);
            btnLocMap = (ImageButton) itemView.findViewById(R.id.btnMapLoc);
            btnStats = (ImageButton) itemView.findViewById(R.id.btnStats);
            layoutStats = (LinearLayout) itemView.findViewById(R.id.layoutStats);


        }
    }
}
