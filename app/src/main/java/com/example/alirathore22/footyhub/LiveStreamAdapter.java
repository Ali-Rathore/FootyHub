package com.example.alirathore22.footyhub;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alirathore22.footyhub.models.Event;

import java.util.List;

public class LiveStreamAdapter extends RecyclerView.Adapter<LiveStreamAdapter.MyViewHolder> {


    private final List<Event> data;

    public LiveStreamAdapter(List<Event> dat)
    {
        this.data = dat;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live_match_link, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.home_team.setText(data.get(position).getStrHomeTeam());
        holder.away_team.setText(data.get(position).getStrAwayTeam());
        holder.stream_link.setText(data.get(position).getStrAwayTeam());

    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  home_team,  away_team, stream_link;
        public MyViewHolder(View itemView) {
            super(itemView);
            home_team = itemView.findViewById(R.id.home_team);
            away_team = itemView.findViewById(R.id.away_team);
            stream_link = itemView.findViewById(R.id.streaming_link);
        }
    }
}
