package org.nhnnext.android.battleapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;

import org.nhnnext.android.battleapp.model.FieldData;
import org.nhnnext.android.battleapp.model.Game;
import org.nhnnext.android.battleapp.model.Player;
import org.nhnnext.android.battleapp.util.BarChart;
import org.nhnnext.android.battleapp.util.GsonRequest;
import org.nhnnext.android.battleapp.util.VolleySingleton;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by mocca on 2015. 7. 28..
 * Matching Activity에서 승부예측결과를 출력하는 Fragment
 * Reference: http://developer.android.com/guide/components/fragments.html
 */
public class MatchingResultFragment extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_match_result, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        Player playerA = args.getParcelable(MatchingActivity.PLAYER_A);
        Player playerB = args.getParcelable(MatchingActivity.PLAYER_B);
        displayPlayer(playerA, playerB);
        requestTargetScore(playerA, playerB);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void displayPlayer(Player playerA, Player playerB) {
        NetworkImageView player1Profile = (NetworkImageView) getActivity().findViewById(R.id.player1_profile);
        NetworkImageView player2Profile = (NetworkImageView) getActivity().findViewById(R.id.player2_profile);
        player1Profile.setImageUrl(Player.PROFILE_IMAGE_URL+playerA.getId()+".png", VolleySingleton.getInstance(getActivity().getApplicationContext()).getImageLoader());
        player1Profile.setDefaultImageResId(R.drawable.noprofile);
        player1Profile.setErrorImageResId(R.drawable.noprofile);
        player2Profile.setImageUrl(Player.PROFILE_IMAGE_URL+playerB.getId()+".png", VolleySingleton.getInstance(getActivity().getApplicationContext()).getImageLoader());
        player2Profile.setDefaultImageResId(R.drawable.noprofile);
        player2Profile.setErrorImageResId(R.drawable.noprofile);
        TextView player1NameView = (TextView) getActivity().findViewById(R.id.player1_name);
        TextView player2NameView = (TextView) getActivity().findViewById(R.id.player2_name);
        player1NameView.setText(playerA.getName());
        player2NameView.setText(playerB.getName());
        TextView player1PlayIdView = (TextView) getActivity().findViewById(R.id.player1_playId);
        TextView player2PlayIdView = (TextView) getActivity().findViewById(R.id.player2_playId);
        player1PlayIdView.setText(playerA.getPlayId());
        player2PlayIdView.setText(playerB.getPlayId());
        ImageView player1RaceSymbolView = (ImageView) getActivity().findViewById(R.id.player1_race_symbol);
        ImageView player2RaceSymbolView = (ImageView) getActivity().findViewById(R.id.player2_race_symbol);
        player1RaceSymbolView.setImageResource(playerA.getRaceSymbol());
        player2RaceSymbolView.setImageResource(playerB.getRaceSymbol());
        TextView player1TeamView = (TextView) getActivity().findViewById(R.id.player1_team);
        TextView player2TeamView = (TextView) getActivity().findViewById(R.id.player2_team);
        player1TeamView.setText(playerA.getTeam());
        player2TeamView.setText(playerB.getTeam());
    }

    private void requestTargetScore(final Player playerA, final Player playerB) {
        String url = "http://125.209.198.90/battleapp/verdict.php?pid1="+playerA.getId()+"&pid2="+playerB.getId();
        GsonRequest gsonRequest = new GsonRequest<Game.GameList>(url, Game.GameList.class, null, new Response.Listener<Game.GameList>() {
            @Override
            public void onResponse(Game.GameList response) {
                displayVerdict(response, playerA, playerB);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("VolleyError", volleyError.getMessage());
            }
        });
        VolleySingleton.getInstance(getActivity().getApplicationContext()).addToRequestQueue(gsonRequest);
    }

    private void displayVerdict(Game.GameList response, Player playerA, Player playerB) {
        BarChart targetScoreBar = (BarChart) getActivity().findViewById(R.id.target_score_bar);

        List<FieldData> fieldDataList = new ArrayList<>();
        String[] totalRecords = calcTotalRecords(playerA, playerB);
        String[] eachOtherGames = new String[]{  Float.toString(response.getWinRate() * 100)  , response.getWin()+"W "+response.getLose()+"L", response.getLose()+"W "+response.getWin()+"L"};
        String[] recent5Games = calcRecent5Games(playerA, playerB);
        String[] opposingRace = calcOpposingRace(playerA, playerB);
        fieldDataList.add(new FieldData("Total Records", totalRecords));
        fieldDataList.add(new FieldData("vs. each other", eachOtherGames));
        fieldDataList.add(new FieldData("Recent 5Games", recent5Games));
        fieldDataList.add(new FieldData("Opposing race", opposingRace));
        fieldDataList.add(new FieldData("Verdict", calcVerdict(totalRecords[0], eachOtherGames[0], recent5Games[0], opposingRace[0])));
        targetScoreBar.setItems(fieldDataList);
    }

    private String[] calcTotalRecords(Player playerA, Player playerB) {
        float playerAwins = Float.intBitsToFloat(playerA.getGameRecords().getWin());
        float playerAlose = Float.intBitsToFloat(playerA.getGameRecords().getLose());
        float playerBwins = Float.intBitsToFloat(playerB.getGameRecords().getWin());
        float playerBlose = Float.intBitsToFloat(playerA.getGameRecords().getLose());
        float playerArates = 0;
        float playerBrates = 0;
        if ((playerAwins + playerAlose) == 0) {
            playerArates = 50;
        } else {
            playerArates = (playerAwins / (playerAwins+playerAlose)) * 100;
        }
        if ((playerBwins + playerBlose) == 0) {
            playerBrates = 50;
        } else {
            playerBrates = (playerBwins / (playerBwins+playerBlose)) * 100;
        }
        float totalRates = (playerArates / (playerArates + playerBrates)) * 100;
        return new String[] { Float.toString(totalRates),
        playerA.getGameRecords().getWin()+"W "+playerA.getGameRecords().getLose()+"L",
        playerB.getGameRecords().getWin()+"W "+playerB.getGameRecords().getLose()+"L"};
    }

    private String[] calcRecent5Games(Player playerA, Player playerB) {
        float playerAwins = Float.intBitsToFloat(playerA.getGameRecords().getRecent5GamesWin());
        float playerBwins = Float.intBitsToFloat(playerB.getGameRecords().getRecent5GamesWin());
        float recent5GamesRate = 0;
        if ((playerAwins + playerBwins) == 0) recent5GamesRate = 50;
        recent5GamesRate = (playerAwins / (playerAwins + playerBwins)) * 100;
        return new String[]{Float.toString(recent5GamesRate),
                playerA.getGameRecords().getRecent5GamesWin()+"W "+playerA.getGameRecords().getRecent5GamesLose()+"L",
                playerB.getGameRecords().getRecent5GamesWin()+"W "+playerB.getGameRecords().getRecent5GamesLose()+"L"
        };
    }

    private String[] calcOpposingRace(Player playerA, Player playerB) {
        int playerAwins = 0;
        int playerBwins = 0;
        int playerAlose = 0;
        int playerBlose = 0;
        switch (playerA.getRace()) {
            case "Terran": playerBwins = playerB.getGameRecords().getVsTwin(); playerBlose = playerB.getGameRecords().getVsTlose(); break;
            case "Zerg": playerBwins = playerB.getGameRecords().getVsZwin(); playerBlose = playerB.getGameRecords().getVsZlose(); break;
            case "Protoss": playerBwins = playerB.getGameRecords().getVsPwin(); playerBlose = playerB.getGameRecords().getVsPlose(); break;
        }
        switch (playerB.getRace()) {
            case "Terran": playerAwins = playerA.getGameRecords().getVsTwin(); playerAlose = playerA.getGameRecords().getVsTlose(); break;
            case "Zerg": playerAwins = playerA.getGameRecords().getVsZwin(); playerAlose = playerA.getGameRecords().getVsZlose(); break;
            case "Protoss": playerAwins = playerA.getGameRecords().getVsPwin(); playerAlose = playerA.getGameRecords().getVsPlose(); break;
        }

        float playerArates = 0;
        if ((playerAwins + playerAlose) == 0) playerArates = 50;
        else {
            playerArates = (Float.intBitsToFloat(playerAwins) / Float.intBitsToFloat(playerAwins + playerAlose))*100;
        }
        float playerBrates = 0;
        if ((playerBwins + playerBlose) == 0) playerBrates = 50;
        else {
            playerBrates = (Float.intBitsToFloat(playerBwins) / Float.intBitsToFloat(playerBwins + playerBlose))*100;
        }
        float totalRates = (playerArates / (playerArates+playerBrates)) * 100;
        return new String[] {
            Float.toString(totalRates),
            playerAwins+"W "+playerAlose+"L",
            playerBwins+"W "+playerBlose+"L"
        };
    }

    private String[] calcVerdict(String totalGames, String eachGames, String recentGames, String oppsingRace) {
        float TOTAL_GAME_WEIGHT = 1;
        float EACH_GAME_WEIGHT = 5;
        float RECENT_GAME_WEIGHT = 3;
        float OPPOSING_RACE_WEIGHT = 2;
        float playerAScore = (Float.parseFloat(totalGames)*TOTAL_GAME_WEIGHT) + (Float.parseFloat(eachGames)*EACH_GAME_WEIGHT) + (Float.parseFloat(recentGames)*RECENT_GAME_WEIGHT) + (Float.parseFloat(oppsingRace)*OPPOSING_RACE_WEIGHT);
        float playerBScore = ((100 - Float.parseFloat(totalGames))*TOTAL_GAME_WEIGHT) + ((100 - Float.parseFloat(eachGames))*EACH_GAME_WEIGHT) + ((100 - Float.parseFloat(recentGames))*RECENT_GAME_WEIGHT) + ( (100 - Float.parseFloat(oppsingRace))*OPPOSING_RACE_WEIGHT);
        float totalScore = 0;
        if ((playerAScore + playerBScore) == 0) {
            totalScore = 50;
        } else {
            totalScore = (playerAScore / (playerAScore+playerBScore)) * 100;
        }
        return new String[] {Float.toString(totalScore),
                Float.toString(totalScore)+"%",
                Float.toString(100-totalScore)+"%"
        };
    }
}
