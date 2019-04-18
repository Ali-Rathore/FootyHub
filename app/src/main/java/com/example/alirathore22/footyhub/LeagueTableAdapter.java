package com.example.alirathore22.footyhub;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alirathore22.footyhub.models.Table;

import java.util.List;

public class LeagueTableAdapter extends RecyclerView.Adapter<LeagueTableAdapter.MyViewHolder> {

    List<Table> table;

    LeagueTableAdapter(List<Table> items){
        this.table = items;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.teams_table, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.team_name.setText(table.get(position).getName());
        holder.matches_played.setText(table.get(position).getPlayed().toString());
        holder.goals_for.setText(table.get(position).getGoalsfor().toString());
        holder.goal_difference.setText(table.get(position).getGoalsdifference().toString());
        holder.goals_against.setText(table.get(position).getGoalsagainst().toString());
        holder.wins.setText(table.get(position).getWin().toString());
        holder.draws.setText(table.get(position).getDraw().toString());
        holder.loss.setText(table.get(position).getLoss().toString());
        holder.total_points.setText(table.get(position).getTotal().toString());
    }

    @Override
    public int getItemCount() {
        return this.table.size();
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
