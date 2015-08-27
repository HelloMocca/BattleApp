package org.nhnnext.android.battleapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by mocca on 2015. 8. 25..
 */
public class League implements Parcelable {
    private int id;
    private String leagueType;  // "SINGLE" OR "TEAM" LEAGUE
    private String name;        // NAME OF LEAGUE
    private String sponsor;     // SPONSOR OF LEAGUE
    private String openDate;
    private String closeDate;
    private Player winnerPlayer;
    private String winnerTeam;
    private String logoUrl;     // IMAGE RESOURCE URL OF LEAGUE LOGO

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeagueType() {
        return leagueType;
    }

    public void setLeagueType(String leagueType) {
        this.leagueType = leagueType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getOpenDate() {
        if (openDate.equals("")) return "";
        return openDate.split(" ")[0];
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        if (closeDate.equals("")) return "";
        return closeDate.split(" ")[0];
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public void setWinnerPlayer(Player winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

    public String getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(String winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "League{" +
                "id=" + id +
                ", leagueType='" + leagueType + '\'' +
                ", name='" + name + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", openDate='" + openDate + '\'' +
                ", closeDate='" + closeDate + '\'' +
                ", winnerPlayer=" + winnerPlayer +
                ", winnerTeam='" + winnerTeam + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                '}';
    }

    public class LeagueList {
        private ArrayList<League> leagues = new ArrayList<League>();
        public ArrayList<League> getLeagues() {
            return this.leagues;
        }
        public void setLeagues(ArrayList<League> leagues) {
            this.leagues = leagues;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(sponsor);
        dest.writeString(openDate);
        dest.writeString(closeDate);
        dest.writeParcelable(winnerPlayer, flags);
        dest.writeString(winnerTeam);
        dest.writeString(logoUrl);
    }

    public static final Parcelable.Creator<League> CREATOR = new Parcelable.Creator<League>() {
        public League createFromParcel(Parcel in) {
            return new League(in);
        }

        public League[] newArray(int size) {
            return new League[size];
        }
    };

    private League(Parcel in) {
        id = in.readInt();
        name = in.readString();
        sponsor = in.readString();
        openDate = in.readString();
        closeDate = in.readString();
        winnerPlayer = in.readParcelable(Player.class.getClassLoader());
        winnerTeam = in.readString();
        logoUrl = in.readString();
    }
}
