package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 선택한 선수의 정보를 제공하는 Activity
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.net.Uri;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.List;

public class PlayerInfoActivity extends Activity {

    private Player player;
    private ArrayList<Game> games;
    private ListView listView;
    private NetworkImageView profileView;
    private TextView nameView;
    private TextView playIdView;
    private TextView raceView;
    private TextView teamNameView;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
        getViews();
        setViewEvent();
        player = getIntent().getExtras().getParcelable(PlayerActivity.PLAYER_EXTRA_KEY);
        requestQueue = VolleySingleton.getInstance(getApplicationContext()).getRequestQueue();
        requestPlayerInfo();
        requestPlayerGames();
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
    protected void onDestroy() { super.onDestroy(); }

    private void getViews() {
        profileView = (NetworkImageView) findViewById(R.id.player_profile);
        nameView = (TextView) findViewById(R.id.player_name);
        playIdView = (TextView) findViewById(R.id.player_playid);
        raceView = (TextView) findViewById(R.id.player_race);
        teamNameView = (TextView) findViewById(R.id.player_team_name);
        listView = (ListView) findViewById(R.id.player_archive);
    }

    private void setViewEvent() {
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                //외부 동영상 링크
                Uri uri = Uri.parse(games.get(position).getVodLink());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }


    /**
     * 선수의 일반 정보 요청 메서드
     **/
    private void requestPlayerInfo() {
        profileView.setImageUrl("http://125.209.198.90/battleapp/profile/"+player.getId()+".png", VolleySingleton.getInstance(getApplicationContext()).getImageLoader());
        profileView.setDefaultImageResId(R.drawable.noprofile);
        profileView.setErrorImageResId(R.drawable.noprofile);
        nameView.setText(player.getName());
        playIdView.setText(player.getPlayId());
        raceView.setText(player.getRace());
        teamNameView.setText(player.getTeam());
    }

    /**
     *  선수의 경기기록 요청 메서드
     **/
    private void requestPlayerGames() {
        requestQueue.add(new GsonRequest<Game.GameList>("http://125.209.198.90/battleapp/playerRecords.php?pid=" + player.getId(), Game.GameList.class, null,
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
        }));
    }

    /**
     * 선수의 경기기록을 리스트에 보여주는 메서드
     */
    private void onListRender(Game.GameList response) {
        BarChart playerRecordChart = (BarChart) findViewById(R.id.player_record_chart);
        List<FieldData> fieldDataList = new ArrayList<>();
        fieldDataList.add(new FieldData("", new String[]{Float.toString( response.getWinRate() * 100 ),"Total Score", response.getWin()+"W "+response.getLose()+"L"}));
        fieldDataList.add(new FieldData("", new String[]{Float.toString( Float.intBitsToFloat(response.getVsTwin()) / Float.intBitsToFloat(response.getVsTwin()+response.getVsTlose()) * 100),"vs T", response.getVsTwin()+"W "+response.getVsTlose()+"L"}));
        fieldDataList.add(new FieldData("", new String[]{Float.toString( Float.intBitsToFloat(response.getVsZwin()) / Float.intBitsToFloat(response.getVsZwin()+response.getVsZlose()) * 100),"vs Z", response.getVsZwin()+"W "+response.getVsZlose()+"L"}));
        fieldDataList.add(new FieldData("", new String[]{Float.toString( Float.intBitsToFloat(response.getVsPwin()) / Float.intBitsToFloat(response.getVsPwin()+response.getVsPlose()) * 100),"vs P", response.getVsPwin()+"W "+response.getVsPlose()+"L"}));
        playerRecordChart.setItems(fieldDataList);

        games = new ArrayList<Game>();
        games = response.getGames();
        listView.setAdapter(new GameListAdapter(this, games));
    }
}
