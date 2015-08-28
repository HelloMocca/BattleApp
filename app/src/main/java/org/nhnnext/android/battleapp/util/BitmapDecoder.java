package org.nhnnext.android.battleapp.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

/**
 * Created by mocca on 2015. 8. 28..
 * Bitmap 관련 작업을 위한 클래스.
 * Resource 의 Bitmap 이미지 크기를 조절하는 decodeBitmapFromResource 메서드를 포함한다.
 */
public class BitmapDecoder {
    /**
     * Bitmap 크기를 조절하는 메서드로 원하는 리소스의 id(resId)와 가로길이(reqWidth), 세로길이(reqHeight)를 받아
     * calculateInSampleSize() 메서드로 부터 원하는 크기로 축소하여 결과 Bitmap 을 반환한다.
     * @param res
     * @param resId
     * @param reqWidth
     * @param reqHeight
     * @return Resized Bitmap object
     */
    public static Bitmap decodeBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    /**
     * 원하는 가로길이(reqWidth)와 세로길이(reqHeight)가 되기 위해 나누어야할 최소한의 값을 계산하여 반환한다.
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return 원하는 크기로 줄이기 위해 나누어져야 하는 정수값
     */
    private static int calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height/2;
            final int halfWidth = width/2;
            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}
