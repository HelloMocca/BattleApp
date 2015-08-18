package org.nhnnext.android.battleapp;

import java.util.ArrayList;
import android.support.v4.app.ListFragment;
import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import android.os.Bundle;

/**
 * Created by mocca on 2015. 7. 28..
 * Matching Activity에서 선수검색 결과를 출력하는 Fragment
 * Reference: http://developer.android.com/guide/components/fragments.html
 */
public class PlayerListFragment extends ListFragment {

    OnPlayerSelectedListener mCallback;
    final static String QUERY = "query";
    private ArrayList<Player> players;

    public interface OnPlayerSelectedListener {
        void onPlayerSelected(Player player);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnPlayerSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnPlayerSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        onSearch(args.getString(QUERY));
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

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Notify the parent activity of selected item
        Player player = players.get(position);
        mCallback.onPlayerSelected(player);
    }

    private void onSearch(String query) {
        //TODO 유저를 찾는 AsyncTask
        players = new ArrayList<>();
        if (query.equals("player1")) {
            players.add(new Player(0,"이승현","Life","Zerg","KT Rolster", 3));
            players.add(new Player(1,"이영호","Flash","Terran","KT Rolster", 1));
            players.add(new Player(2,"이원표","Curious","Zerg","SBENU", 1));
            players.add(new Player(3,"이제동","JAEDONG","Zerg","Evil Genius", 0));
            players.add(new Player(4,"이주경","Sona","Terran","CJ ENTUS", 0));
            players.add(new Player(5,"원이삭","Parting","Protoss","Yoe Flash Wolves", 1));
        } else {
            players.add(new Player(6,"김대엽","Stats","Protoss","KT Rolster", 0));
            players.add(new Player(7,"김도우","Classic","Protoss","SKT T1", 1));
            players.add(new Player(8,"김명식","MyuNgSiK","Protoss","SBENU", 0));
            players.add(new Player(9,"김준호","herO","Protoss","CJ ENTUS", 0));
            players.add(new Player(10,"김유진","sOs","Protoss","JINAIR Greenwings", 0));
        }
        updatePlayerList();
    }

    private void updatePlayerList() {
        setListAdapter(new PlayerListAdapter(getActivity(), players));
    }
}
