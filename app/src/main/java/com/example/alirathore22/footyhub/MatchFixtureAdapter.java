package com.example.alirathore22.footyhub;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MatchFixtureAdapter extends RecyclerView.Adapter<MatchFixtureAdapter.MyViewHolder> {


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match_fixture, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //don't know what to do here
       // holder.date_match.setText();
       // holder.home_team.setText();
       // holder.home_score.setText();
       // holder.away_score.setText();
       // holder.away_team.setText();


    }

    @Override
    public int getItemCount() {
        //don't know what to do here
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date_match, home_team, home_score, away_score, away_team;

        public MyViewHolder(View itemView) {
            super(itemView);
            date_match = itemView.findViewById(R.id.date_match);
            home_score = itemView.findViewById(R.id.home_score);
            home_team = itemView.findViewById(R.id.home_team);
            away_score = itemView.findViewById(R.id.away_score);
            away_team = itemView.findViewById(R.id.away_team);

        }
    }
}
