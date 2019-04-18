package com.example.alirathore22.footyhub;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class LeagueTableAdapter extends RecyclerView.Adapter<LeagueTableAdapter.MyViewHolder> {

    //List<Table> table;

//    LeagueTableAdapter(List<Table> items){
//        this.Table = items;
//    }
//

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.teams_table, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView team_name, matches_played, goals_for, goals_against, goal_difference, wins, draws, loss, total_points;

        public MyViewHolder(View itemView) {
            super(itemView);

            team_name = itemView.findViewById(R.id.team_name);
            matches_played = itemView.findViewById(R.id.matches_played);
            goals_for = itemView.findViewById(R.id.goals_for);
            goals_against = itemView.findViewById(R.id.goals_against);
            goal_difference= itemView.findViewById(R.id.goal_difference);
            wins = itemView.findViewById(R.id.wins);
            draws = itemView.findViewById(R.id.draws);
            loss = itemView.findViewById(R.id.loss);
            total_points = itemView.findViewById(R.id.total);

        }
    }
}
