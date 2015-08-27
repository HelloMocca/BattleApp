package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 8. 6..
 * 선수 정보를 표현하는 객체
 */

import android.os.Parcelable;
import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;

public class Player implements Parcelable{

    private int id;
    private String name;
    private String playId;
    private String race;
    private String team;
    private Game.GameList gameRecords;
    public static final String PROFILE_IMAGE_URL = "http://125.209.198.90/battleapp/profile/";

    public Player(int id, String name, String playId, String race, String team) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.playId = playId;
        this.team = team;
    }


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(id);
        out.writeString(name);
        out.writeString(playId);
        out.writeString(race);
        out.writeString(team);
    }

    public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    private Player(Parcel in) {
        id = in.readInt();
        name = in.readString();
        playId = in.readString();
        race = in.readString();
        team = in.readString();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayId() {
        return this.playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId;
    }

    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Game.GameList getGameRecords() {
        return this.gameRecords;
    }

    public void setGameRecords(Game.GameList gameRecords) {
        this.gameRecords = gameRecords;
    }

    public int getRaceSymbol() {
        switch (this.race.toLowerCase()) {
            case "terran" : return R.drawable.terran_symbol;
            case "zerg" : return R.drawable.zerg_symbol;
            case "protoss" : return R.drawable.protoss_symbol;
        }
        return R.drawable.terran_symbol;
    }

    public int getTeamLogo() {
        switch (this.team.toLowerCase()) {
            case "kt rolster" : return R.drawable.ktrolster_logo;
            case "samsung galaxy" : return R.drawable.samsunggalaxy_logo;
            case "skt t1" : return R.drawable.skt1_logo;
            case "cj entus" : return R.drawable.cjentus_logo;
            case "jinair greenwings" : return R.drawable.jinair_logo;
            case "prime" : return R.drawable.prime_logo;
            case "mvp" : return R.drawable.mvp_logo;
            case "sbenu" : return R.drawable.sbenu_logo;
        }
        return R.drawable.team_icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (id != player.id) return false;
        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        if (playId != null ? !playId.equals(player.playId) : player.playId != null) return false;
        if (race != null ? !race.equals(player.race) : player.race != null) return false;
        return !(team != null ? !team.equals(player.team) : player.team != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (playId != null ? playId.hashCode() : 0);
        result = 31 * result + (race != null ? race.hashCode() : 0);
        result = 31 * result + (team != null ? team.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playId='" + playId + '\'' +
                ", race='" + race + '\'' +
                ", team='" + team + '\'' +
                '}';
    }

    public class PlayerList {
        private ArrayList<Player> players;
        public ArrayList<Player> getPlayers() {
            return players;
        }
    }
}
