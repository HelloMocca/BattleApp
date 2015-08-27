package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 개최된 리그의 목록을 제공하는 Activity
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;

public class LeagueListActivity extends Activity {

    private ListView listView;
    private ArrayList<League> leagueList = new ArrayList<League>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LeagueActivity","onCreate");
        setContentView(R.layout.activity_league_list);
        getViews();
        setViewEvent();
        requestLeagues();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LeagueActivity","onStart");
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
        listView = (ListView) findViewById(R.id.league_list_view);
    }

    private void setViewEvent() {
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(CustomAction.ACTION_ARCHIVE);
                Bundle args = new Bundle();
                args.putParcelable("league", leagueList.get(position));
                intent.putExtras(args);
                startActivity(intent);
            }
        });
    }

    /**
     * 개최된 리그의 목록 요청
     */
    private void requestLeagues() {
        String url = "http://125.209.198.90/battleapp/leagues.php";
        GsonRequest request = new GsonRequest<League.LeagueList>(url, League.LeagueList.class, null, new Response.Listener<League.LeagueList>() {
            @Override
            public void onResponse(League.LeagueList response) {
                leagueList = response.getLeagues();
                onListRender(leagueList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("VolleyError", volleyError.getMessage());
            }
        });
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
    }

    /**
     * ListView에 리그 리스트 생성
     */
    private void onListRender(ArrayList<League> leagues) {
        LeagueListAdapter adapter = new LeagueListAdapter(this, leagues);
        listView.setAdapter(adapter);
    }
}
