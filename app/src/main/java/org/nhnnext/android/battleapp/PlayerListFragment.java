package org.nhnnext.android.battleapp;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;

/**
 * Created by mocca on 2015. 7. 28..
 * Matching Activity에서 선수검색 결과를 출력하는 Fragment
 * Reference: http://developer.android.com/guide/components/fragments.html
 */
public class PlayerListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_playerlist, container, false);
    }
}
