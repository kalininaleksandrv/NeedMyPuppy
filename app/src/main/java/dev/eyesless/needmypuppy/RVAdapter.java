package dev.eyesless.needmypuppy;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Eyesless on 19.06.2017.
 */

public class RVAdapter extends RecyclerView.Adapter  <RVAdapter.BreedViewHolder> {


    public class BreedViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView breedImage;
        TextView breedTitle;
        TextView breedDescription;

        public BreedViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardview_main);
            breedImage = (ImageView) itemView.findViewById(R.id.cv_imageView);
            breedTitle = (TextView) itemView.findViewById(R.id.cv_title);
            breedDescription = (TextView) itemView.findViewById(R.id.cv_description);

        }
    }

    ArrayList<Breed_mod> breeds;

    RVAdapter (ArrayList<Breed_mod> breeds){

        this.breeds = breeds;
    }


    @Override
    public BreedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_main, parent, false);

        BreedViewHolder breedViewHolder = new BreedViewHolder(v);

        return breedViewHolder;

    }

    @Override
    public void onBindViewHolder(BreedViewHolder holder, int position) {

        holder.breedImage.setImageResource(R.drawable.b_germshep);
        holder.breedTitle.setText("Немецкая овчарка");
        holder.breedDescription.setText("Отличная собака для охраны и компании");

    }

    @Override
    public int getItemCount() {
        return breeds.size();
    }
}
