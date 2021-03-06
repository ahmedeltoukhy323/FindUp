package khaled.example.com.findup.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import khaled.example.com.findup.R;

import khaled.example.com.findup.models.Place;

/**
 * Created by khaled on 7/4/18.
 */

public class NearMeAdapter extends RecyclerView.Adapter<NearMeAdapter.ViewHolder> {

    private List<Place> places;
    private Context context;

    public NearMeAdapter(Context context, List<Place> places) {
        this.context = context;
        this.places = places;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView placeName;
        TextView distance;
        TextView review;

        public ViewHolder(View view) {
            super(view);

            placeName = view.findViewById(R.id.nearItemName);
            distance = view.findViewById(R.id.nearItemDistance);
            review = view.findViewById(R.id.nearItemReview);
        }

        @Override
        public void onClick(View v) {
        }
    }

    @NonNull
    @Override
    public NearMeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.near_me_item, parent, false);
        return new NearMeAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Place place = places.get(position);
        holder.placeName.setText(place.getPlaceName());
        holder.distance.setText(place.getPlaceDistane());
        holder.review.setText(place.getPlaceReview());
    }

    @Override
    public int getItemCount() {
        return places.size();
    }
}
