package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 각 리그의 경기목록 Activity
 */
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LeagueArchiveActivity extends Activity {

    private TextView leagueNameView;
    private TextView leagueDateView;
    private TextView leagueWinnerView;
    private ListView listView;
    private League league;
    private ArrayList<Game> games = new ArrayList<Game>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_archive);
        league = getIntent().getExtras().getParcelable("league");
        getViews();
        setLeagueInfo();
        setViewEvent();
        requestArchive();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void getViews() {
        leagueNameView = (TextView) findViewById(R.id.league_title);
        leagueDateView = (TextView) findViewById(R.id.league_date);
        leagueWinnerView = (TextView) findViewById(R.id.league_winner);
        listView = (ListView) findViewById(R.id.league_archive);
    }

    private void setViewEvent() {

    }

    private void setLeagueInfo() {
        leagueNameView.setText(league.getName());
        leagueDateView.setText(league.getOpenDate());
        if (league.getWinnerPlayer() != null) {
            leagueWinnerView.setText(league.getWinnerPlayer().getName());
        }
        if (league.getWinnerPlayer().equals(" ")) {

        }
    }

    /**
     * 경기 기록을 요청하는 메서드
     */
    private void requestArchive() {
        GsonRequest request = new GsonRequest<Game.GameList>("http://125.209.198.90/battleapp/games.php?lid=" + league.getId(), Game.GameList.class, null,
                new Response.Listener<Game.GameList>() {
                    @Override
                    public void onResponse(Game.GameList response) {
                        games = response.getGames();
                        onListRender(games);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Volley Error", volleyError.getMessage());
                Log.d("Volley Error", volleyError.toString());
            }
        });
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
    }

    private void onListRender(ArrayList<Game> games) {
        GameListAdapter adapter = new GameListAdapter(this, games);
        listView.setAdapter(adapter);
    }
}
