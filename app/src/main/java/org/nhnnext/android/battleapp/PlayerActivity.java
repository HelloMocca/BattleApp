package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 플레이어 정보 검색을 위한 Activity
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class PlayerActivity extends Activity {

    private EditText searchText;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        getViews();
        setViewEvent();
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

    private void getViews() {
        searchText = (EditText) findViewById(R.id.player_search);
        listView = (ListView) findViewById(R.id.player_search_result);
    }

    /**
     * 검색 버튼에 대해 리스너를 세팅하는 메서드
     */
    private void setViewEvent() {
        Button searchBtn = (Button) findViewById(R.id.player_search_btn);
        searchBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearch();
            }
        });

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(CustomAction.ACTION_PLAYERINFO);
                Bundle args = new Bundle();
                args.putParcelable("player", new Player(1, "이영호", "Flash", "Terran", "KT Rolster", 1));
                intent.putExtras(args);
                startActivity(intent);
            }
        });
    }

    /**
     * 검색 이벤트시 호출되는 메서드
    **/
    private void onSearch() {
        String query = searchText.getText().toString();
        //TODO AsyncTask로 검색 결과 요청
        onListRender();
    }

    /**
     * 검색 결과를 ListView에 그려주는 메서드
     */
    private void onListRender() {
        String[] playerList = {"임요환","홍진호","이영호","송병구"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, playerList);
        listView.setAdapter(adapter);
    }
}
