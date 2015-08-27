package org.nhnnext.android.battleapp;

import java.util.ArrayList;
import android.support.v4.app.ListFragment;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by mocca on 2015. 7. 28..
 * Matching Activity에서 선수검색 결과를 출력하는 Fragment
 * Reference: http://developer.android.com/guide/components/fragments.html
 */
public class PlayerListFragment extends ListFragment {

    OnPlayerSelectedListener mCallback;
    final static String QUERY = "query";
    private ArrayList<Player> players;
    private RequestQueue requestQueue;

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
        requestQueue = VolleySingleton.getInstance(getActivity().getApplicationContext()).getRequestQueue();
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
        String url = "http://125.209.198.90/battleapp/players.php?q="+query;
        players = new ArrayList<>();
        GsonRequest gsonRequest = new GsonRequest<PlayerList>(url, PlayerList.class, null, new Response.Listener<PlayerList>() {
            @Override
            public void onResponse(PlayerList response) {
                Log.d("gsonResult", response.getPlayers().toString());
                players = response.getPlayers();
                updatePlayerList();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("VolleyError", volleyError.getMessage());
            }
        });
        VolleySingleton.getInstance(getActivity().getApplicationContext()).addToRequestQueue(gsonRequest);
    }

    private void updatePlayerList() {
        setListAdapter(new PlayerListAdapter(getActivity(), players));
    }

    private class PlayerList {
        private ArrayList<Player> players;
        public ArrayList<Player> getPlayers() {
            return players;
        }
    }
}
