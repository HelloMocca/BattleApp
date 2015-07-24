package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 개최된 리그의 목록을 제공하는 Activity
 */
import android.app.Activity;
import android.os.Bundle;

public class LeagueListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_list);

        //TODO 개최된 리그 목록 데이터 요청 (requestLeagues)
        //TODO 리그 목록 ListView의 Item Click 이벤트 리스너 구현 (startActivity: LeagueArchiveActivity)
    }

    @Override
    protected void onStart() {

    }

    @Override
    protected void onResume() {

    }

    @Override
    protected void onPause() {

    }

    @Override
    protected void onStop() {

    }

    @Override
    protected void onDestroy() {

    }

    /**
     * 개최된 리그의 목록 요청
     */
    private void requestLeagues() {
        //TODO 리그 목록 요청 AsyncTask 생성 및 ListView에 추가
    }
}
