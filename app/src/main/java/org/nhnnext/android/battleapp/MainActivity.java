package org.nhnnext.android.battleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.util.Log;
import android.graphics.Bitmap;

import org.nhnnext.android.battleapp.util.BitmapDecoder;

/**
 * Created by mocca on 2015. 7. 21..
 * 각 Activity에 접근할 수 있는 버튼 메뉴를 제공한다.
 */
public class MainActivity extends Activity {

    private ImageButton playerBtn;
    private ImageButton archiveBtn;
    private ImageButton matchingBtn;
    private Bitmap playermenuBitmap;
    private Bitmap archivemenuBitmap;
    private Bitmap matchingmenuBitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(CustomAction.ACTION_SPLASH));
        getViews();
        setButtonEvent();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setBitmaps();
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
        recycleBitmaps();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void getViews() {
        playerBtn = (ImageButton) findViewById(R.id.playerBtn);
        archiveBtn = (ImageButton) findViewById(R.id.archiveBtn);
        matchingBtn = (ImageButton) findViewById(R.id.matchingBtn);
    }

    private void setBitmaps() {
        playermenuBitmap = BitmapDecoder.decodeBitmapFromResource(getResources(), R.drawable.playersearch_menu, 150, 100);
        archivemenuBitmap = BitmapDecoder.decodeBitmapFromResource(getResources(), R.drawable.archive_menu, 150, 100);
        matchingmenuBitmap = BitmapDecoder.decodeBitmapFromResource(getResources(), R.drawable.matching_menu, 150, 100);
        playerBtn.setImageBitmap(playermenuBitmap);
        archiveBtn.setImageBitmap(archivemenuBitmap);
        matchingBtn.setImageBitmap(matchingmenuBitmap);
    }

    private void recycleBitmaps() {
        Log.d("MainActivity","recycleBitmaps");
        playermenuBitmap.recycle();
        playermenuBitmap = null;
        archivemenuBitmap.recycle();
        archivemenuBitmap = null;
        matchingmenuBitmap.recycle();
        matchingmenuBitmap = null;
    }

    /**
     * 화면의 버튼에 대해 리스너를 세팅하는 메서드
     */
    private void setButtonEvent() {
        playerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomAction.ACTION_PLAYER));
            }
        });
        archiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomAction.ACTION_LEAGUELIST));
            }
        });
        matchingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CustomAction.ACTION_MATCHING));
            }
        });
    }
}
