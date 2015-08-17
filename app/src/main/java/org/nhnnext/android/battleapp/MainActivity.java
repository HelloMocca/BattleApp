package org.nhnnext.android.battleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

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
        setButtonEvent();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //TODO 현재 진행중인 경기정보 요청 (다른 Activity에서 현재 Activity로 돌아왔을 때 갱신되어야 하므로)
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
     * 화면의 버튼에 대해 리스너를 세팅하는 메서드
     */
    private void setButtonEvent() {
        ImageButton scheduleBtn = (ImageButton) findViewById(R.id.scheduleBtn);
        scheduleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomAction.ACTION_SCHEDULE));
            }
        });
        ImageButton leagueBtn = (ImageButton) findViewById(R.id.leagueBtn);
        leagueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomAction.ACTION_LEAGUE));
            }
        });
        ImageButton playerBtn = (ImageButton) findViewById(R.id.playerBtn);
        playerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomAction.ACTION_PLAYER));
            }
        });
        ImageButton archiveBtn = (ImageButton) findViewById(R.id.archiveBtn);
        archiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomAction.ACTION_LEAGUELIST));
            }
        });
        ImageButton matchingBtn = (ImageButton) findViewById(R.id.matchingBtn);
        matchingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomAction.ACTION_MATCHING));
            }
        });
    }
}
