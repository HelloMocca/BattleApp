package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 선수를 선택하여 승부를 예측하는 기능을 제공하는 Activity
 */
import android.app.Activity;
import android.os.Bundle;

public class MatchingActivity extends Activity {

    private int playerAId;
    private int playerBId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);

        //TODO 선수 A를 검색하는 버튼 이벤트 구현
        //TODO 선수 B를 검색하는 버튼 이벤트 구현
        //TODO ListView에서 선수에 해당하는 Item Click 이벤트 리스너 구현
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
     * 플레이어의 정보를 요청하는 메서드
     */
    private void requestPlayer(int playerId) {
        //TODO Player의 정보를 요청하는 AsyncTask 생성
    }

    /**
     * 플레이어들의 정보를 토대로 승패 확률을 계산하는 메서드
     */
    private void predictGame() {

    }
}
