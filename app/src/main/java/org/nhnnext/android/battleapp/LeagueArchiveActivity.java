package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 각 리그의 경기목록 Activity
 */
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.nhnnext.android.battleapp.adapter.GameListAdapter;
import org.nhnnext.android.battleapp.model.Game;
import org.nhnnext.android.battleapp.model.League;
import org.nhnnext.android.battleapp.util.GsonRequest;
import org.nhnnext.android.battleapp.util.VolleySingleton;

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                //외부 동영상 링크
                Uri uri = Uri.parse(games.get(position).getVodLink());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private void setLeagueInfo() {
        leagueNameView.setText(league.getName());
        leagueDateView.setText(league.getOpenDate());
        if (league.getWinnerPlayer() != null) {
            leagueWinnerView.setText(league.getWinnerPlayer().getName());
        } else {
            leagueWinnerView.setText("");
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
                        onListRender(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Volley Error", volleyError.getMessage());
                Log.d("Volley Error", volleyError.toString());
            }
        });
        VolleySingleton.getInstance(this).addToRequestQueue(request);
    }

    private void onListRender(Game.GameList response) {
        games = response.getGames();
        listView.setAdapter(new GameListAdapter(this, games));
    }
}
