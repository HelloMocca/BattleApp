package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 7. 21..
 * 선수를 선택하여 승부를 예측하는 기능을 제공하는 Activity
 */
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MatchingActivity extends FragmentActivity implements PlayerListFragment.OnPlayerSelectedListener {

    public static final String PLAYER_A = "PLAYER_A";
    public static final String PLAYER_B = "PLAYER_B";
    private Player playerA = null;
    private Player playerB = null;
    private String currPlayerStatus = MatchingActivity.PLAYER_A;
    private EditText player1EditText;
    private EditText player2EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);
        getViews();
        setViewEvent();
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
        player1EditText = (EditText) findViewById(R.id.player1_search);
        player2EditText = (EditText) findViewById(R.id.player2_search);
    }

    /**
     * 플레이어의 정보를 요청하는 메서드
     */
    private void setViewEvent() {
        ImageButton p1SearchBtn = (ImageButton) findViewById(R.id.player1_search_btn);
        ImageButton p2SearchBtn = (ImageButton) findViewById(R.id.player2_search_btn);

        p1SearchBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                currPlayerStatus = MatchingActivity.PLAYER_A;
                Bundle args = new Bundle();
                args.putString(PlayerListFragment.QUERY,"player1");
                replaceFragment(R.id.matching_activity_fragment_container, args, new PlayerListFragment());
            }
        });

        p2SearchBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                currPlayerStatus = MatchingActivity.PLAYER_B;
                Bundle args = new Bundle();
                args.putString(PlayerListFragment.QUERY, "player2");
                replaceFragment(R.id.matching_activity_fragment_container, args, new PlayerListFragment());
            }
        });
    }

    /**
     * 선수 리스트에서 선수를 선택했을때 수행되는 메서드
     * playerA 와 playerB 가 모두 선택되면 승률을 계산하는 predictGame() 을 호출한다.
     * @param player
     */
    public void onPlayerSelected(Player player) {
        if (currPlayerStatus.equals(MatchingActivity.PLAYER_A)) {
            playerA = player;
            player1EditText.setText(player.getName());
        } else {
            playerB = player;
            player2EditText.setText(player.getName());
        }
        Toast.makeText(this, player.getName()+"선수가 선택되었습니다.", Toast.LENGTH_SHORT).show();
        /** 선수 두명이 모두 선택되면 승자예측을 시작한다. **/
        if (playerA != null && playerB != null) {
            predictGame();
        }

    }

    /**
     * 플레이어들의 정보를 토대로 승패 확률을 계산하는 메서드
     */
    private void predictGame() {
        Toast.makeText(this, "분석을 시작합니다.", Toast.LENGTH_SHORT).show();
        //TODO 두 선수의 승패를 계산한다.
        //TODO 승부예측 결과를 Fragment에 전달
        Bundle args = new Bundle();
        args.putParcelable(MatchingActivity.PLAYER_A, playerA);
        args.putParcelable(MatchingActivity.PLAYER_B, playerB);
        replaceFragment(R.id.matching_activity_fragment_container, args, new MatchingResultFragment());
    }

    /**
     * Fragment 를 전환하는 메서드
     * @param containerViewId
     * @param args
     * @param fragment
     */
    private void replaceFragment(@IdRes int containerViewId, Bundle args, Fragment fragment) {
        /** In case this activity was started with special instructions from an
         Intent, pass the Intent's extras to the fragment as arguments **/
        fragment.setArguments(args);
        /** Add the fragment to the 'fragment_container' FrameLayout **/
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(containerViewId, fragment);
        transaction.commit();
    }
}
