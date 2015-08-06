package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 선택한 선수의 정보를 제공하는 Activity
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlayerInfoActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
        getViews();
        setViewEvent();
        //TODO 선수데이터 요청 메서드(requestPlayerInfo) 호출
        //TODO 선수 경기기록 요청 메서드(requestPlayerGames) 호출
        requestPlayerGames();
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
    protected void onDestroy() { super.onDestroy(); }

    private void getViews() {
        listView = (ListView) findViewById(R.id.player_archive);
    }

    private void setViewEvent() {
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                //외부 동영상 링크
            }
        });
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
        onListRender();
    }

    private void onListRender() {
        String[] playList = {
                "SKTelecom StarLeague 2015, Ro.16, B조 3경기 3세트, VS 조성주 ",
                "SKTelecom StarLeague 2015, Ro.16, B조 3경기 2세트, VS 조성주",
                "SKTelecom StarLeague 2015, Ro.16, B조 3경기 1세트, VS 조성주",
                "SKTelecom StarLeague 2015, Ro.16, B조 1경기 3세트, VS 김도우"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, playList);
        listView.setAdapter(adapter);
    }
}
