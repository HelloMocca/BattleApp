package org.nhnnext.android.battleapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by mocca on 2015. 7. 28..
 * Matching Activity에서 승부예측결과를 출력하는 Fragment
 * Reference: http://developer.android.com/guide/components/fragments.html
 */
public class MatchingResultFragment extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_match_result, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        Player playerA = args.getParcelable(MatchingActivity.PLAYER_A);
        Player playerB = args.getParcelable(MatchingActivity.PLAYER_B);
        displayPlayer(playerA, playerB);
        BarChart targetScoreBar = (BarChart) getActivity().findViewById(R.id.target_score_bar);

        List<FieldData> fieldDataList = new ArrayList<>();
        fieldDataList.add(new FieldData("상대전적", new String[]{"25", "3승 7패", "7승 3패"}));
        fieldDataList.add(new FieldData("최근5경기", new String[]{"60", "4승 1패", "3승 2패"}));
        fieldDataList.add(new FieldData("종족전", new String[]{"50", "15승 8패", "14승 6패"}));
        fieldDataList.add(new FieldData("우승", new String[]{"80", "2회", "0회"}));
        fieldDataList.add(new FieldData("승자예측", new String[]{"76", "66%", "34%"}));
        targetScoreBar.setItems(fieldDataList);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void displayPlayer(Player playerA, Player playerB) {
        TextView player1NameView = (TextView) getActivity().findViewById(R.id.player1_name);
        TextView player2NameView = (TextView) getActivity().findViewById(R.id.player2_name);
        player1NameView.setText(playerA.getName());
        player2NameView.setText(playerB.getName());
        TextView player1PlayIdView = (TextView) getActivity().findViewById(R.id.player1_playId);
        TextView player2PlayIdView = (TextView) getActivity().findViewById(R.id.player2_playId);
        player1PlayIdView.setText(playerA.getPlayId());
        player2PlayIdView.setText(playerB.getPlayId());
        TextView player1TeamView = (TextView) getActivity().findViewById(R.id.player1_team);
        TextView player2TeamView = (TextView) getActivity().findViewById(R.id.player2_team);
        player1TeamView.setText(playerA.getTeam());
        player2TeamView.setText(playerB.getTeam());
    }
}
