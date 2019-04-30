package com.example.alirathore22.footyhub.models;

public class StreamingLink {

    String team_a, team_b, link;

    public String getTeam_a() {
        return team_a;
    }

    public void setTeam_a(String team_a) {
        this.team_a = team_a;
    }

    public String getTeam_b() {
        return team_b;
    }

    public void setTeam_b(String team_b) {
        this.team_b = team_b;
    }

    public String getLink() {
        return link;
    }

    public StreamingLink(String team_a, String team_b, String link) {
        this.team_a = team_a;
        this.team_b = team_b;
        this.link = link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
