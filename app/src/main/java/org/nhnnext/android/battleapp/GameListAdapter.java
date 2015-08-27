package org.nhnnext.android.battleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by mocca on 2015. 8. 17..
 */
public class GameListAdapter extends BaseAdapter {

    private List<Game> gameList;
    private LayoutInflater inflater;
    public GameListAdapter(Context context, List<Game> gameList) {
        this.inflater = LayoutInflater.from(context);
        this.gameList = gameList;
    }

    @Override
    public int getCount() {
        return gameList.size();
    }

    @Override
    public Object getItem(int position) {
        return gameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Game game = gameList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.game_list, parent, false);
            holder = new ViewHolder(
                    (TextView) convertView.findViewById(R.id.league_name),
                    (TextView) convertView.findViewById(R.id.player1_name),
                    (TextView) convertView.findViewById(R.id.player2_name),
                    (TextView) convertView.findViewById(R.id.round_set)
            );
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.getLeagueNameView().setText(game.getLeagueName());
        holder.getPlayer1View().setText(game.getPlayer1());
        holder.getPlayer2View().setText(game.getPlayer2());
        holder.getRoundSetView().setText(game.getRoundSet());
        return convertView;
    }

    private static class ViewHolder {
        private TextView leagueNameView;
        private TextView player1View;
        private TextView player2View;
        private TextView roundSetView;
        public ViewHolder(TextView leagueNameView, TextView player1View, TextView player2View, TextView roundSetView) {
            this.leagueNameView = leagueNameView;
            this.player1View = player1View;
            this.player2View = player2View;
            this.roundSetView = roundSetView;
        }
        public TextView getLeagueNameView() {
            return leagueNameView;
        }

        public void setLeagueNameView(TextView leagueNameView) {
            this.leagueNameView = leagueNameView;
        }

        public TextView getPlayer1View() {
            return player1View;
        }

        public void setPlayer1View(TextView player1View) {
            this.player1View = player1View;
        }

        public TextView getPlayer2View() {
            return player2View;
        }

        public void setPlayer2View(TextView player2View) {
            this.player2View = player2View;
        }

        public TextView getRoundSetView() {
            return roundSetView;
        }

        public void setRoundSetView(TextView roundSetView) {
            this.roundSetView = roundSetView;
        }
    }
}
