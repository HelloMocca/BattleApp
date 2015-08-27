package org.nhnnext.android.battleapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import org.nhnnext.android.battleapp.R;
import org.nhnnext.android.battleapp.util.VolleySingleton;
import org.nhnnext.android.battleapp.model.Player;

import java.util.List;

/**
 * Created by mocca on 2015. 8. 17..
 */
public class PlayerListAdapter extends BaseAdapter {

    private List<Player> playerList;
    private LayoutInflater inflater;
    public PlayerListAdapter(Context context, List<Player> playerList) {
        this.inflater = LayoutInflater.from(context);
        this.playerList = playerList;
    }

    @Override
    public int getCount() {
        return playerList.size();
    }

    @Override
    public Object getItem(int position) {
        return playerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player player = playerList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.player_list, parent, false);
            holder = new ViewHolder(
                    (NetworkImageView) convertView.findViewById(R.id.player_list_player_profile),
                    (TextView) convertView.findViewById(R.id.player_list_playername),
                    (TextView) convertView.findViewById(R.id.player_list_playerid),
                    (TextView) convertView.findViewById(R.id.player_list_player_team),
                    (ImageView) convertView.findViewById(R.id.player_list_player_team_logo),
                    (ImageView) convertView.findViewById(R.id.player_list_playerrace)
            );
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.getProfile().setImageUrl(Player.PROFILE_IMAGE_URL+player.getId()+".png", VolleySingleton.getInstance(convertView.getContext().getApplicationContext()).getImageLoader());
        holder.getProfile().setDefaultImageResId(R.drawable.noprofile);
        holder.getProfile().setErrorImageResId(R.drawable.noprofile);
        holder.getNameView().setText(player.getName());
        holder.getPlayIdView().setText(player.getPlayId());
        holder.getTeamView().setText(player.getTeam());
        holder.getRaceView().setImageResource(player.getRaceSymbol());
        holder.getTeamlogoView().setImageResource(player.getTeamLogo());
        return convertView;
    }

    private static class ViewHolder {
        private NetworkImageView profile;
        private ImageView raceView;
        private TextView nameView;
        private TextView playIdView;
        private ImageView teamlogoView;
        private TextView teamView;
        public ViewHolder(NetworkImageView profile, TextView nameView, TextView playIdView, TextView teamView, ImageView teamlogoView, ImageView raceView) {
            this.profile = profile;
            this.nameView = nameView;
            this.playIdView = playIdView;
            this.teamView = teamView;
            this.teamlogoView = teamlogoView;
            this.raceView = raceView;
        }
        public NetworkImageView getProfile() {
            return this.profile;
        }
        public TextView getNameView() {
            return this.nameView;
        }
        public TextView getPlayIdView() {
            return this.playIdView;
        }
        public TextView getTeamView() {
            return this.teamView;
        }
        public ImageView getTeamlogoView() {
            return this.teamlogoView;
        }
        public ImageView getRaceView() {
            return this.raceView;
        }
    }
}
