package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 플레이어 정보 검색을 위한 Activity
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.ListView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.nhnnext.android.battleapp.adapter.PlayerListAdapter;
import org.nhnnext.android.battleapp.model.Player;
import org.nhnnext.android.battleapp.util.GsonRequest;
import org.nhnnext.android.battleapp.util.VolleySingleton;

import java.util.ArrayList;

public class PlayerActivity extends Activity {

    private EditText searchText;
    private ListView listView;
    private ArrayList<Player> players;
    private RequestQueue requestQueue;
    public static final String PLAYER_EXTRA_KEY = "player";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Player","OnCreate");
        setContentView(R.layout.activity_player);
        getViews();
        setViewEvent();
        requestQueue = VolleySingleton.getInstance(this).getRequestQueue();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Player", "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Player", "OnResume");
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
        searchText = (EditText) findViewById(R.id.player_search);
        listView = (ListView) findViewById(R.id.player_search_result);
    }

    /**
     * 검색 버튼에 대해 리스너를 세팅하는 메서드
     */
    private void setViewEvent() {
        ImageButton searchBtn = (ImageButton) findViewById(R.id.player_search_btn);
        searchBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearch();
            }
        });
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(CustomAction.ACTION_PLAYERINFO);
                Bundle args = new Bundle();
                args.putParcelable("player", players.get(position));
                intent.putExtras(args);
                startActivity(intent);
            }
        });
    }

    /**
     * 검색 이벤트시 호출되는 메서드
    **/
    private void onSearch() {
        String query = searchText.getText().toString();
        String url = "http://125.209.198.90/battleapp/players.php?q="+query;
        GsonRequest gsonRequest = new GsonRequest<Player.PlayerList>(url, Player.PlayerList.class, null, new Response.Listener<Player.PlayerList>() {
            @Override
            public void onResponse(Player.PlayerList response) {
                players = response.getPlayers();
                onListRender();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("VolleyError", volleyError.getMessage());
            }
        });
        requestQueue.add(gsonRequest);
    }

    /**
     * 검색 결과를 ListView에 그려주는 메서드
     */
    private void onListRender() {
        PlayerListAdapter adapter = new PlayerListAdapter(this, players);
        listView.setAdapter(adapter);
    }
}
