package com.example.alirathore22.footyhub.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Event implements Serializable
{

    @JsonProperty("idEvent")
    private String idEvent;
    @JsonProperty("idSoccerXML")
    private String idSoccerXML;
    @JsonProperty("strEvent")
    private String strEvent;
    @JsonProperty("strFilename")
    private String strFilename;
    @JsonProperty("strSport")
    private String strSport;
    @JsonProperty("idLeague")
    private String idLeague;
    @JsonProperty("strLeague")
    private String strLeague;
    @JsonProperty("strSeason")
    private String strSeason;
    @JsonProperty("strDescriptionEN")
    private Object strDescriptionEN;
    @JsonProperty("strHomeTeam")
    private String strHomeTeam;
    @JsonProperty("strAwayTeam")
    private String strAwayTeam;
    @JsonProperty("intHomeScore")
    private Object intHomeScore;
    @JsonProperty("intRound")
    private String intRound;
    @JsonProperty("intAwayScore")
    private Object intAwayScore;
    @JsonProperty("intSpectators")
    private Object intSpectators;
    @JsonProperty("strHomeGoalDetails")
    private Object strHomeGoalDetails;
    @JsonProperty("strHomeRedCards")
    private Object strHomeRedCards;
    @JsonProperty("strHomeYellowCards")
    private Object strHomeYellowCards;
    @JsonProperty("strHomeLineupGoalkeeper")
    private Object strHomeLineupGoalkeeper;
    @JsonProperty("strHomeLineupDefense")
    private Object strHomeLineupDefense;
    @JsonProperty("strHomeLineupMidfield")
    private Object strHomeLineupMidfield;
    @JsonProperty("strHomeLineupForward")
    private Object strHomeLineupForward;
    @JsonProperty("strHomeLineupSubstitutes")
    private Object strHomeLineupSubstitutes;
    @JsonProperty("strHomeFormation")
    private Object strHomeFormation;
    @JsonProperty("strAwayRedCards")
    private Object strAwayRedCards;
    @JsonProperty("strAwayYellowCards")
    private Object strAwayYellowCards;
    @JsonProperty("strAwayGoalDetails")
    private Object strAwayGoalDetails;
    @JsonProperty("strAwayLineupGoalkeeper")
    private Object strAwayLineupGoalkeeper;
    @JsonProperty("strAwayLineupDefense")
    private Object strAwayLineupDefense;
    @JsonProperty("strAwayLineupMidfield")
    private Object strAwayLineupMidfield;
    @JsonProperty("strAwayLineupForward")
    private Object strAwayLineupForward;
    @JsonProperty("strAwayLineupSubstitutes")
    private Object strAwayLineupSubstitutes;
    @JsonProperty("strAwayFormation")
    private Object strAwayFormation;
    @JsonProperty("intHomeShots")
    private Object intHomeShots;
    @JsonProperty("intAwayShots")
    private Object intAwayShots;
    @JsonProperty("dateEvent")
    private String dateEvent;
    @JsonProperty("datetimeEventUTC")
    private Object datetimeEventUTC;
    @JsonProperty("strDate")
    private String strDate;
    @JsonProperty("strTime")
    private String strTime;
    @JsonProperty("strTVStation")
    private Object strTVStation;
    @JsonProperty("idHomeTeam")
    private String idHomeTeam;
    @JsonProperty("idAwayTeam")
    private String idAwayTeam;
    @JsonProperty("strResult")
    private Object strResult;
    @JsonProperty("strCircuit")
    private Object strCircuit;
    @JsonProperty("strCountry")
    private Object strCountry;
    @JsonProperty("strCity")
    private Object strCity;
    @JsonProperty("strPoster")
    private Object strPoster;
    @JsonProperty("strFanart")
    private Object strFanart;
    @JsonProperty("strThumb")
    private Object strThumb;
    @JsonProperty("strBanner")
    private Object strBanner;
    @JsonProperty("strMap")
    private Object strMap;
    @JsonProperty("strLocked")
    private String strLocked;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6740932447744899065L;

    @JsonProperty("idEvent")
    public String getIdEvent() {
        return idEvent;
    }

    @JsonProperty("idEvent")
    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    @JsonProperty("idSoccerXML")
    public String getIdSoccerXML() {
        return idSoccerXML;
    }

    @JsonProperty("idSoccerXML")
    public void setIdSoccerXML(String idSoccerXML) {
        this.idSoccerXML = idSoccerXML;
    }

    @JsonProperty("strEvent")
    public String getStrEvent() {
        return strEvent;
    }

    @JsonProperty("strEvent")
    public void setStrEvent(String strEvent) {
        this.strEvent = strEvent;
    }

    @JsonProperty("strFilename")
    public String getStrFilename() {
        return strFilename;
    }

    @JsonProperty("strFilename")
    public void setStrFilename(String strFilename) {
        this.strFilename = strFilename;
    }

    @JsonProperty("strSport")
    public String getStrSport() {
        return strSport;
    }

    @JsonProperty("strSport")
    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    @JsonProperty("idLeague")
    public String getIdLeague() {
        return idLeague;
    }

    @JsonProperty("idLeague")
    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    @JsonProperty("strLeague")
    public String getStrLeague() {
        return strLeague;
    }

    @JsonProperty("strLeague")
    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    @JsonProperty("strSeason")
    public String getStrSeason() {
        return strSeason;
    }

    @JsonProperty("strSeason")
    public void setStrSeason(String strSeason) {
        this.strSeason = strSeason;
    }

    @JsonProperty("strDescriptionEN")
    public Object getStrDescriptionEN() {
        return strDescriptionEN;
    }

    @JsonProperty("strDescriptionEN")
    public void setStrDescriptionEN(Object strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    @JsonProperty("strHomeTeam")
    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    @JsonProperty("strHomeTeam")
    public void setStrHomeTeam(String strHomeTeam) {
        this.strHomeTeam = strHomeTeam;
    }

    @JsonProperty("strAwayTeam")
    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    @JsonProperty("strAwayTeam")
    public void setStrAwayTeam(String strAwayTeam) {
        this.strAwayTeam = strAwayTeam;
    }

    @JsonProperty("intHomeScore")
    public Object getIntHomeScore() {
        return intHomeScore;
    }

    @JsonProperty("intHomeScore")
    public void setIntHomeScore(Object intHomeScore) {
        this.intHomeScore = intHomeScore;
    }

    @JsonProperty("intRound")
    public String getIntRound() {
        return intRound;
    }

    @JsonProperty("intRound")
    public void setIntRound(String intRound) {
        this.intRound = intRound;
    }

    @JsonProperty("intAwayScore")
    public Object getIntAwayScore() {
        return intAwayScore;
    }

    @JsonProperty("intAwayScore")
    public void setIntAwayScore(Object intAwayScore) {
        this.intAwayScore = intAwayScore;
    }

    @JsonProperty("intSpectators")
    public Object getIntSpectators() {
        return intSpectators;
    }

    @JsonProperty("intSpectators")
    public void setIntSpectators(Object intSpectators) {
        this.intSpectators = intSpectators;
    }

    @JsonProperty("strHomeGoalDetails")
    public Object getStrHomeGoalDetails() {
        return strHomeGoalDetails;
    }

    @JsonProperty("strHomeGoalDetails")
    public void setStrHomeGoalDetails(Object strHomeGoalDetails) {
        this.strHomeGoalDetails = strHomeGoalDetails;
    }

    @JsonProperty("strHomeRedCards")
    public Object getStrHomeRedCards() {
        return strHomeRedCards;
    }

    @JsonProperty("strHomeRedCards")
    public void setStrHomeRedCards(Object strHomeRedCards) {
        this.strHomeRedCards = strHomeRedCards;
    }

    @JsonProperty("strHomeYellowCards")
    public Object getStrHomeYellowCards() {
        return strHomeYellowCards;
    }

    @JsonProperty("strHomeYellowCards")
    public void setStrHomeYellowCards(Object strHomeYellowCards) {
        this.strHomeYellowCards = strHomeYellowCards;
    }

    @JsonProperty("strHomeLineupGoalkeeper")
    public Object getStrHomeLineupGoalkeeper() {
        return strHomeLineupGoalkeeper;
    }

    @JsonProperty("strHomeLineupGoalkeeper")
    public void setStrHomeLineupGoalkeeper(Object strHomeLineupGoalkeeper) {
        this.strHomeLineupGoalkeeper = strHomeLineupGoalkeeper;
    }

    @JsonProperty("strHomeLineupDefense")
    public Object getStrHomeLineupDefense() {
        return strHomeLineupDefense;
    }

    @JsonProperty("strHomeLineupDefense")
    public void setStrHomeLineupDefense(Object strHomeLineupDefense) {
        this.strHomeLineupDefense = strHomeLineupDefense;
    }

    @JsonProperty("strHomeLineupMidfield")
    public Object getStrHomeLineupMidfield() {
        return strHomeLineupMidfield;
    }

    @JsonProperty("strHomeLineupMidfield")
    public void setStrHomeLineupMidfield(Object strHomeLineupMidfield) {
        this.strHomeLineupMidfield = strHomeLineupMidfield;
    }

    @JsonProperty("strHomeLineupForward")
    public Object getStrHomeLineupForward() {
        return strHomeLineupForward;
    }

    @JsonProperty("strHomeLineupForward")
    public void setStrHomeLineupForward(Object strHomeLineupForward) {
        this.strHomeLineupForward = strHomeLineupForward;
    }

    @JsonProperty("strHomeLineupSubstitutes")
    public Object getStrHomeLineupSubstitutes() {
        return strHomeLineupSubstitutes;
    }

    @JsonProperty("strHomeLineupSubstitutes")
    public void setStrHomeLineupSubstitutes(Object strHomeLineupSubstitutes) {
        this.strHomeLineupSubstitutes = strHomeLineupSubstitutes;
    }

    @JsonProperty("strHomeFormation")
    public Object getStrHomeFormation() {
        return strHomeFormation;
    }

    @JsonProperty("strHomeFormation")
    public void setStrHomeFormation(Object strHomeFormation) {
        this.strHomeFormation = strHomeFormation;
    }

    @JsonProperty("strAwayRedCards")
    public Object getStrAwayRedCards() {
        return strAwayRedCards;
    }

    @JsonProperty("strAwayRedCards")
    public void setStrAwayRedCards(Object strAwayRedCards) {
        this.strAwayRedCards = strAwayRedCards;
    }

    @JsonProperty("strAwayYellowCards")
    public Object getStrAwayYellowCards() {
        return strAwayYellowCards;
    }

    @JsonProperty("strAwayYellowCards")
    public void setStrAwayYellowCards(Object strAwayYellowCards) {
        this.strAwayYellowCards = strAwayYellowCards;
    }

    @JsonProperty("strAwayGoalDetails")
    public Object getStrAwayGoalDetails() {
        return strAwayGoalDetails;
    }

    @JsonProperty("strAwayGoalDetails")
    public void setStrAwayGoalDetails(Object strAwayGoalDetails) {
        this.strAwayGoalDetails = strAwayGoalDetails;
    }

    @JsonProperty("strAwayLineupGoalkeeper")
    public Object getStrAwayLineupGoalkeeper() {
        return strAwayLineupGoalkeeper;
    }

    @JsonProperty("strAwayLineupGoalkeeper")
    public void setStrAwayLineupGoalkeeper(Object strAwayLineupGoalkeeper) {
        this.strAwayLineupGoalkeeper = strAwayLineupGoalkeeper;
    }

    @JsonProperty("strAwayLineupDefense")
    public Object getStrAwayLineupDefense() {
        return strAwayLineupDefense;
    }

    @JsonProperty("strAwayLineupDefense")
    public void setStrAwayLineupDefense(Object strAwayLineupDefense) {
        this.strAwayLineupDefense = strAwayLineupDefense;
    }

    @JsonProperty("strAwayLineupMidfield")
    public Object getStrAwayLineupMidfield() {
        return strAwayLineupMidfield;
    }

    @JsonProperty("strAwayLineupMidfield")
    public void setStrAwayLineupMidfield(Object strAwayLineupMidfield) {
        this.strAwayLineupMidfield = strAwayLineupMidfield;
    }

    @JsonProperty("strAwayLineupForward")
    public Object getStrAwayLineupForward() {
        return strAwayLineupForward;
    }

    @JsonProperty("strAwayLineupForward")
    public void setStrAwayLineupForward(Object strAwayLineupForward) {
        this.strAwayLineupForward = strAwayLineupForward;
    }

    @JsonProperty("strAwayLineupSubstitutes")
    public Object getStrAwayLineupSubstitutes() {
        return strAwayLineupSubstitutes;
    }

    @JsonProperty("strAwayLineupSubstitutes")
    public void setStrAwayLineupSubstitutes(Object strAwayLineupSubstitutes) {
        this.strAwayLineupSubstitutes = strAwayLineupSubstitutes;
    }

    @JsonProperty("strAwayFormation")
    public Object getStrAwayFormation() {
        return strAwayFormation;
    }

    @JsonProperty("strAwayFormation")
    public void setStrAwayFormation(Object strAwayFormation) {
        this.strAwayFormation = strAwayFormation;
    }

    @JsonProperty("intHomeShots")
    public Object getIntHomeShots() {
        return intHomeShots;
    }

    @JsonProperty("intHomeShots")
    public void setIntHomeShots(Object intHomeShots) {
        this.intHomeShots = intHomeShots;
    }

    @JsonProperty("intAwayShots")
    public Object getIntAwayShots() {
        return intAwayShots;
    }

    @JsonProperty("intAwayShots")
    public void setIntAwayShots(Object intAwayShots) {
        this.intAwayShots = intAwayShots;
    }

    @JsonProperty("dateEvent")
    public String getDateEvent() {
        return dateEvent;
    }

    @JsonProperty("dateEvent")
    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    @JsonProperty("datetimeEventUTC")
    public Object getDatetimeEventUTC() {
        return datetimeEventUTC;
    }

    @JsonProperty("datetimeEventUTC")
    public void setDatetimeEventUTC(Object datetimeEventUTC) {
        this.datetimeEventUTC = datetimeEventUTC;
    }

    @JsonProperty("strDate")
    public String getStrDate() {
        return strDate;
    }

    @JsonProperty("strDate")
    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    @JsonProperty("strTime")
    public String getStrTime() {
        return strTime;
    }

    @JsonProperty("strTime")
    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    @JsonProperty("strTVStation")
    public Object getStrTVStation() {
        return strTVStation;
    }

    @JsonProperty("strTVStation")
    public void setStrTVStation(Object strTVStation) {
        this.strTVStation = strTVStation;
    }

    @JsonProperty("idHomeTeam")
    public String getIdHomeTeam() {
        return idHomeTeam;
    }

    @JsonProperty("idHomeTeam")
    public void setIdHomeTeam(String idHomeTeam) {
        this.idHomeTeam = idHomeTeam;
    }

    @JsonProperty("idAwayTeam")
    public String getIdAwayTeam() {
        return idAwayTeam;
    }

    @JsonProperty("idAwayTeam")
    public void setIdAwayTeam(String idAwayTeam) {
        this.idAwayTeam = idAwayTeam;
    }

    @JsonProperty("strResult")
    public Object getStrResult() {
        return strResult;
    }

    @JsonProperty("strResult")
    public void setStrResult(Object strResult) {
        this.strResult = strResult;
    }

    @JsonProperty("strCircuit")
    public Object getStrCircuit() {
        return strCircuit;
    }

    @JsonProperty("strCircuit")
    public void setStrCircuit(Object strCircuit) {
        this.strCircuit = strCircuit;
    }

    @JsonProperty("strCountry")
    public Object getStrCountry() {
        return strCountry;
    }

    @JsonProperty("strCountry")
    public void setStrCountry(Object strCountry) {
        this.strCountry = strCountry;
    }

    @JsonProperty("strCity")
    public Object getStrCity() {
        return strCity;
    }

    @JsonProperty("strCity")
    public void setStrCity(Object strCity) {
        this.strCity = strCity;
    }

    @JsonProperty("strPoster")
    public Object getStrPoster() {
        return strPoster;
    }

    @JsonProperty("strPoster")
    public void setStrPoster(Object strPoster) {
        this.strPoster = strPoster;
    }

    @JsonProperty("strFanart")
    public Object getStrFanart() {
        return strFanart;
    }

    @JsonProperty("strFanart")
    public void setStrFanart(Object strFanart) {
        this.strFanart = strFanart;
    }

    @JsonProperty("strThumb")
    public Object getStrThumb() {
        return strThumb;
    }

    @JsonProperty("strThumb")
    public void setStrThumb(Object strThumb) {
        this.strThumb = strThumb;
    }

    @JsonProperty("strBanner")
    public Object getStrBanner() {
        return strBanner;
    }

    @JsonProperty("strBanner")
    public void setStrBanner(Object strBanner) {
        this.strBanner = strBanner;
    }

    @JsonProperty("strMap")
    public Object getStrMap() {
        return strMap;
    }

    @JsonProperty("strMap")
    public void setStrMap(Object strMap) {
        this.strMap = strMap;
    }

    @JsonProperty("strLocked")
    public String getStrLocked() {
        return strLocked;
    }

    @JsonProperty("strLocked")
    public void setStrLocked(String strLocked) {
        this.strLocked = strLocked;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
