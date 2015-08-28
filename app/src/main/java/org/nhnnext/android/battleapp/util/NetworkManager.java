package org.nhnnext.android.battleapp.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.app.Activity;

/**
 * Created by mocca on 2015. 8. 28..
 * 네트워크 상태를 체크하는 메서드와
 * 경고창을 띄우는 메서드를 포함한 클래스.
 */
public class NetworkManager {
    /**
     * 현재 Activity에서 네트워크의 상태를 체크
     * @param context
     * @return true(Connected) or false(Disconnected)
     */
    public static boolean isOnline(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    /**
     * 현재 Activity에서 경고 Dialog를 띄우고 Activity를 종료(onDestory)한다.
     * @param context
     */
    public static void showNotConnectedAlert(Context context) {
        final Context mContext = context;
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        DialogInterface.OnClickListener positiveListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                /** Activity onDestory() **/
                ((Activity) mContext).finish();
            }
        };
        builder.setMessage("인터넷 연결이 되어있지 않아 정상적인 서비스가 불가능합니다.")
                .setCancelable(false)
                .setPositiveButton("Yes", positiveListener);
        AlertDialog alertDialog = builder.create();
        alertDialog.setTitle("Network Not Connected");
        alertDialog.show();
    }
}
