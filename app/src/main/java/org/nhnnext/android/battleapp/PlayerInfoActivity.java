package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 선택한 선수의 정보를 제공하는 Activity
 */
import android.app.Activity;
import android.os.Bundle;

public class PlayerInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        //TODO 선수데이터 요청 메서드(requestPlayerInfo) 호출
        //TODO 선수 경기기록 요청 메서드(requestPlayerGames) 호출
        //TODO 선수 경기기록 LIST Click 이벤트 리스너 구현
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
     * 선수의 일반 정보 요청 메서드
     **/
    private void requestPlayerInfo() {

    }

    /**
     *  선수의 경기기록 요청 메서드
     **/
    private void requestPlayerGames() {

    }
}
