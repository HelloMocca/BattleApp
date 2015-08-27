package org.nhnnext.android.battleapp;

import java.util.ArrayList;

/**
 * Created by mocca on 2015. 8. 6..
 * 각 경기내용을 포함하는 객체
 */
public class Game {
    private String player1;
    private String player2;
    private String leagueName;
    private int round;
    private int gameSet;
    private String groupName;
    private String matchDate;
    private String vodLink;
    private String result;

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getGameSet() { return gameSet; }

    public void setGameSet() { this.gameSet = gameSet; }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getVodLink() {
        return vodLink;
    }

    public void setVodLink(String vodLink) {
        this.vodLink = vodLink;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRoundSet() {
        String returnStr;
        switch (round) {
            case 2 : returnStr = "결승전"; break;
            default : returnStr = round+"강";
        }
        return returnStr+" "+gameSet+"세트";
    }

    public class GameList {
        private ArrayList<Game> games;
        private int gameCount;
        private int win;
        private int lose;
        private String vsT;
        private String vsZ;
        private String vsP;
        private String recent5Games;

        public void setGameCount(int gameCount) {
            this.gameCount = gameCount;
        }

        public int getGameCount() {
            return this.gameCount;
        }

        public void setWin(int win) {
            this.win = win;
        }

        public int getWin() {
            return this.win;
        }

        public void setLose(int lose) {
            this.lose = lose;
        }

        public int getLose() {
            return this.lose;
        }

        public void setVsT(String vsT) {
            this.vsT = vsT;
        }

        public String getVsT() {
            return this.vsT;
        }

        public int getVsTwin() {
            return Integer.parseInt(this.vsT.split("\\|")[0]);
        }

        public int getVsTlose() {
            return Integer.parseInt(this.vsT.split("\\|")[1]);
        }

        public void setVsZ(String vsZ) {
            this.vsZ = vsZ;
        }

        public String getVsZ() {
            return this.vsZ;
        }

        public int getVsZwin() {
            return Integer.parseInt(this.vsZ.split("\\|")[0]);
        }

        public int getVsZlose() {
            return Integer.parseInt(this.vsZ.split("\\|")[1]);
        }

        public void setVsP(String vsP) {
            this.vsP = vsP;
        }

        public String getVsP() {
            return this.vsP;
        }

        public int getVsPwin() {
            return Integer.parseInt(this.vsP.split("\\|")[0]);
        }

        public int getVsPlose() {
            return Integer.parseInt(this.vsP.split("\\|")[1]);
        }

        public void setRecent5Games(String recent5Games) {
            this.recent5Games = recent5Games;
        }

        public int getRecent5GamesWin() {
            return Integer.parseInt(this.recent5Games.split("\\|")[0]);
        }

        public int getRecent5GamesLose() {
            return Integer.parseInt(this.recent5Games.split("\\|")[1]);
        }

        public float getWinRate() {
            if (gameCount == 0) {
                return 1/2;
            }
            return Float.intBitsToFloat(this.win) / Float.intBitsToFloat(this.gameCount);
        }

        public ArrayList<Game> getGames() {
            return this.games;
        }
    }
}
