package org.nhnnext.android.battleapp;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by mocca on 2015. 7. 21..
 * 앞으로 진행될 경기일정 정보제공
 */
public class ScheduleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        //TODO 경기일정 데이터 요청 메서드 호출
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
     * 경기일정 데이터 요청 메서드
     */
    private void requestSchedule() {
        //TODO 경기일정 요청 AsyncTask 생성 및 ListView에 추가
    }
}
