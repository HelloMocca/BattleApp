package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 개최된 리그의 목록을 제공하는 Activity
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LeagueListActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_list);

        getViews();
        setViewEvent();
        //TODO 개최된 리그 목록 데이터 요청 (requestLeagues)
        requestLeagues();
        //TODO 리그 목록 ListView의 Item Click 이벤트 리스너 구현 (startActivity: LeagueArchiveActivity)
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
        listView = (ListView) findViewById(R.id.league_list_view);
    }

    private void setViewEvent() {
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                startActivity(new Intent(CustomAction.ACTION_ARCHIVE));
            }
        });
    }

    /**
     * 개최된 리그의 목록 요청
     */
    private void requestLeagues() {
        //TODO 리그 목록 요청 AsyncTask 생성 및 ListView에 추가
        onListRender();
    }

    /**
     * ListView에 리그 리스트 생성
     */
    private void onListRender() {
        String[] leagueList = {
                "NAVER 스타리그 2015",
                "SKTelecom 프로리그 2015 Round1",
                "2015 GSL Season 3",
                "KeSPA컵 스타리그",
                "2015 GSL Season 2",
                "SBENU 스타리그 2015",
                "2015 GSL Season 1",
                "SKPlanet 프로리그 2014 Round3",
                "2014 GSL Code S Season 3",
                "신한은행 프로리그 2014 Round2",
                "2014 GSL Code A Season 2"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, leagueList);
        listView.setAdapter(adapter);
    }
}
