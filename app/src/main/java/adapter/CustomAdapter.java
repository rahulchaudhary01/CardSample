package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.cardsample.Movies;
import com.android.cardsample.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by RAHUL CHAUDHARY on 11/15/2016.
 */
/*
public class CustomAdapter extends ArrayAdapter<Movies> {

    private ArrayList<Movies> movieSet;
    Context mContext;
    private static class ViewHolder {
        ImageView posterPathView;
        TextView adultView;
        TextView overviewView;
        TextView release_dateView;
        TextView genre_idsView;
        TextView idView;
        TextView original_titleView;
        TextView original_languageView;
        TextView titleView;
        ImageView backdrop_pathView;
        TextView popularityView;
        TextView vote_countView;
        TextView videoView;
        TextView vote_averageView;
    }

    public CustomAdapter(ArrayList<Movies> data, Context context) {
        super(context, R.layout.row_item, data);
        this.movieSet = data;
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        final View result;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.posterPathView = (ImageView) convertView.findViewById(R.id.posterpath);
            viewHolder.adultView = (TextView) convertView.findViewById(R.id.adult);
            viewHolder.overviewView = (TextView) convertView.findViewById(R.id.overview);
            viewHolder.release_dateView = (TextView) convertView.findViewById(R.id.releasedate);
            viewHolder.genre_idsView = (TextView) convertView.findViewById(R.id.genreid);
            viewHolder.idView = (TextView) convertView.findViewById(R.id.id);
            viewHolder.original_titleView = (TextView) convertView.findViewById(R.id.originaltitle);
            viewHolder.original_languageView = (TextView) convertView.findViewById(R.id.originallanguage);
            viewHolder.titleView = (TextView) convertView.findViewById(R.id.titleT);
            viewHolder.backdrop_pathView = (ImageView) convertView.findViewById(R.id.backdropath);
            viewHolder.popularityView = (TextView) convertView.findViewById(R.id.popularity);
            viewHolder.vote_countView = (TextView) convertView.findViewById(R.id.votecount);
            viewHolder.videoView = (TextView) convertView.findViewById(R.id.video);
            viewHolder.vote_averageView = (TextView) convertView.findViewById(R.id.voteaverage);
            result=convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        String posterPathUrl = "http://image.tmdb.org/t/p/w500/" + movieSet.get(position).getPosterPath();
        Picasso.with(getContext())
                .load(posterPathUrl)
                .into(viewHolder.posterPathView);
        viewHolder.adultView.setText(movieSet.get(position).getAdult().toString());
        viewHolder.overviewView.setText(movieSet.get(position).getOverview());
        viewHolder.overviewView.setMovementMethod(new ScrollingMovementMethod());
        viewHolder.release_dateView.setText(movieSet.get(position).getReleaseDate());
        viewHolder.genre_idsView.setText(movieSet.get(position).getGenreIds().toString());
        viewHolder.idView.setText(movieSet.get(position).getId().toString());
        viewHolder.original_titleView.setText(movieSet.get(position).getOriginalTitle());
        viewHolder.original_languageView.setText(movieSet.get(position).getOriginalLanguage());
        viewHolder.titleView.setText(movieSet.get(position).getTitle());
        String backdropPathUrl = "http://image.tmdb.org/t/p/w500/" + movieSet.get(position).getBackdropPath();
        Picasso.with(getContext())
                .load(backdropPathUrl)
                .into(viewHolder.backdrop_pathView);
        viewHolder.popularityView.setText(movieSet.get(position).getPopularity().toString());
        viewHolder.vote_countView.setText(movieSet.get(position).getVoteCount().toString());
        viewHolder.videoView.setText(movieSet.get(position).getVideo().toString());
        viewHolder.vote_averageView.setText(movieSet.get(position).getVoteAverage().toString());
        return convertView;
    }

    @Override
    public int getCount() {
        return movieSet.size();
    }
}
*/

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<Movies> movieSet;
    Context mContext;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView posterPathView;
        TextView release_dateView;
        TextView titleView;
        TextView popularityView;
        TextView vote_countView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.posterPathView = (ImageView) itemView.findViewById(R.id.posterpath);
            this.release_dateView = (TextView) itemView.findViewById(R.id.releasedate);
            this.titleView = (TextView) itemView.findViewById(R.id.title);
            this.popularityView = (TextView) itemView.findViewById(R.id.popularity);
            this.vote_countView = (TextView) itemView.findViewById(R.id.votecount);
        }
    }

    public CustomAdapter(ArrayList<Movies> movieData) {
        this.movieSet = movieData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview, parent, false);
        mContext = parent.getContext();
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        String posterPathUrl = "http://image.tmdb.org/t/p/w500/" + movieSet.get(position).getPosterPath();
        Picasso.with(mContext)
                .load(posterPathUrl)
                .into(holder.posterPathView);
        holder.release_dateView.setText("Release Date : " + movieSet.get(position).getReleaseDate());
        holder.titleView.setText(movieSet.get(position).getTitle());
        holder.popularityView.setText("Popularity : " + movieSet.get(position).getPopularity().toString());
        holder.vote_countView.setText("Votes : " + movieSet.get(position).getVoteCount().toString());
    }

    @Override
    public int getItemCount() {
        return movieSet.size();
    }
}
