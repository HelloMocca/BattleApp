package org.nhnnext.android.battleapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.nhnnext.android.battleapp.R;
import org.nhnnext.android.battleapp.model.League;

import java.util.List;

/**
 * Created by mocca on 2015. 8. 17..
 */
public class LeagueListAdapter extends BaseAdapter {

    private List<League> leagueList;
    private LayoutInflater inflater;
    public LeagueListAdapter(Context context, List<League> leagueList) {
        this.inflater = LayoutInflater.from(context);
        this.leagueList = leagueList;
    }

    @Override
    public int getCount() {
        return leagueList.size();
    }

    @Override
    public Object getItem(int position) {
        return leagueList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        League league = leagueList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.league_list, parent, false);
            holder = new ViewHolder(
                    (TextView) convertView.findViewById(R.id.league_openDate),
                    (TextView) convertView.findViewById(R.id.league_name),
                    (ImageView) convertView.findViewById(R.id.league_logo)
            );
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.getOpenDateView().setText(league.getOpenDate());
        holder.getNameView().setText(league.getName());
        return convertView;
    }

    private static class ViewHolder {
        private TextView openDateView;
        private TextView nameView;
        private ImageView logoView;
        public ViewHolder(TextView openDateView, TextView nameView, ImageView logoView) {
            this.openDateView = openDateView;
            this.nameView = nameView;
            this.logoView = logoView;
        }
        public TextView getOpenDateView() {
            return this.openDateView;
        }
        public TextView getNameView() {
            return this.nameView;
        }
        public ImageView getLogoView() {
            return this.logoView;
        }
    }
}
