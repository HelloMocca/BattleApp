package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 각 리그의 경기목록 Activity
 */
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LeagueArchiveActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_archive);
        getViews();
        setViewEvent();
        //TODO 현재 선택된 리그의 경기 목록 요청 메서드 호출(requestArchive)
        requestArchive();
        //TODO 경기 선택시 외부 링크로 이동하는 이벤트 리스너 구현
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
        listView = (ListView) findViewById(R.id.league_archive);
    }

    private void setViewEvent() {

    }

    /**
     * 경기 기록을 요청하는 메서드
     */
    private void requestArchive() {
        //TODO 경기 기록을 요청하는 AsyncTask 생성 및 ListView에 추가
        onListRender();
    }

    private void onListRender() {
        String[] playList = {
                "결승전, 7세트, 정명훈 VS 원이삭",
                "결승전, 6세트, 정명훈 VS 원이삭",
                "결승전, 5세트, 정명훈 VS 원이삭",
                "결승전, 4세트, 정명훈 VS 원이삭",
                "결승전, 3세트, 정명훈 VS 원이삭",
                "결승전, 2세트, 정명훈 VS 원이삭",
                "결승전, 1세트, 정명훈 VS 원이삭",
                "Ro.4, 2경기 4세트, 원이삭 VS 조성주",
                "Ro.4, 2경기 3세트, 원이삭 VS 조성주",
                "Ro.4, 2경기 2세트, 원이삭 VS 조성주",
                "Ro.4, 2경기 1세트, 원이삭 VS 조성주",
                "Ro.4, 1경기 5세트, 이승현 VS 정명훈",
                "Ro.4, 1경기 4세트, 이승현 VS 정명훈",
                "Ro.4, 1경기 3세트, 이승현 VS 정명훈",
                "Ro.4, 1경기 2세트, 이승현 VS 정명훈",
                "Ro.4, 1경기 1세트, 이승현 VS 정명훈"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, playList);
        listView.setAdapter(adapter);
    }
}
