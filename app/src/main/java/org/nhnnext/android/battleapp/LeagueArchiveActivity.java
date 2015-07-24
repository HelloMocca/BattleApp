package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 각 리그의 경기목록 Activity
 */
import android.app.Activity;
import android.os.Bundle;

public class LeagueArchiveActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_archive);

        //TODO 현재 선택된 리그의 경기 목록 요청 메서드 호출(requestArchive)
        //TODO 경기 선택시 외부 링크로 이동하는 이벤트 리스너 구현
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
     * 경기 기록을 요청하는 메서드
     */
    private void requestArchive() {
        //TODO 경기 기록을 요청하는 AsyncTask 생성 및 ListView에 추가
    }
}
