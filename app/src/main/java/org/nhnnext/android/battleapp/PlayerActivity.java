package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 플레이어 정보 검색을 위한 Activity
 */
import android.app.Activity;
import android.os.Bundle;

public class PlayerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        //TODO 검색버튼 이벤트 리스너 구현
        //TODO LIST ITEM Click 이벤트 리스너 구현 (startActivity: PlayerInfoActivity)
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
     * 검색 이벤트시 호출되는 메서드
    **/
    private void onSearch() {
        //TODO EditView 에 사용자가 입력한 문자열 받기
        //TODO AsyncTask로 검색 결과 요청
    }
}
