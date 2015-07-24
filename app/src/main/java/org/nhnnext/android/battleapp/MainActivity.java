package org.nhnnext.android.battleapp;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by mocca on 2015. 7. 21..
 * 현재 진행중인 경기 정보를 API로 받아와 보여주고
 * 각 Activity에 접근할 수 있는 버튼 메뉴를 제공한다.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 각 Activity로 이동하는 버튼 이벤트 리스너 구현
    }

    @Override
    protected void onStart() {
        //TODO 현재 진행중인 경기정보 요청 (다른 Activity에서 현재 Activity로 돌아왔을 때 갱신되어야 하므로)
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
}
