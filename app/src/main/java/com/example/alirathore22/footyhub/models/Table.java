package com.example.alirathore22.footyhub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "teamid",
        "played",
        "goalsfor",
        "goalsagainst",
        "goalsdifference",
        "win",
        "draw",
        "loss",
        "total"
})
public class Table implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("teamid")
    private String teamid;
    @JsonProperty("played")
    private Integer played;
    @JsonProperty("goalsfor")
    private Integer goalsfor;
    @JsonProperty("goalsagainst")
    private Integer goalsagainst;
    @JsonProperty("goalsdifference")
    private Integer goalsdifference;
    @JsonProperty("win")
    private Integer win;
    @JsonProperty("draw")
    private Integer draw;
    @JsonProperty("loss")
    private Integer loss;
    @JsonProperty("total")
    private Integer total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6435049317583299334L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("teamid")
    public String getTeamid() {
        return teamid;
    }

    @JsonProperty("teamid")
    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    public Integer getTotal() {
        return total;
    }

    @JsonProperty("played")
    public Integer getPlayed() {
        return played;
    }

    @JsonProperty("played")
    public void setPlayed(Integer played) {
        this.played = played;
    }

    @JsonProperty("goalsfor")
    public Integer getGoalsfor() {
        return goalsfor;
    }

    @JsonProperty("goalsfor")
    public void setGoalsfor(Integer goalsfor) {
        this.goalsfor = goalsfor;
    }

    @JsonProperty("goalsagainst")
    public Integer getGoalsagainst() {
        return goalsagainst;
    }

    @JsonProperty("goalsagainst")
    public void setGoalsagainst(Integer goalsagainst) {
        this.goalsagainst = goalsagainst;
    }

    @JsonProperty("goalsdifference")
    public Integer getGoalsdifference() {
        return goalsdifference;
    }

    @JsonProperty("goalsdifference")
    public void setGoalsdifference(Integer goalsdifference) {
        this.goalsdifference = goalsdifference;
    }

    @JsonProperty("win")
    public Integer getWin() {
        return win;
    }

    @JsonProperty("win")
    public void setWin(Integer win) {
        this.win = win;
    }

    @JsonProperty("draw")
    public Integer getDraw() {
        return draw;
    }

    @JsonProperty("draw")
    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    @JsonProperty("loss")
    public Integer getLoss() {
        return loss;
    }
}
