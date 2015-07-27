package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 리그정보 Activity
 */
import android.app.Activity;
import android.os.Bundle;

public class LeagueActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);

        //TODO 리그 정보 요청 메서드 호출
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

    /**
     * 현재 진행중인 리그정보를 요청하는 메서드
     */
    private void requestCurrentLeagues() {
        //TODO 리그 정보 요청 AsyncTask 생성 및 ListView에 추가
    }
}
