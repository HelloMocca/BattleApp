package org.nhnnext.android.battleapp.util;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;

import android.content.Context;
import android.util.LruCache;
import android.util.Log;
import android.graphics.Bitmap;

/**
 * Created by mocca on 2015. 8. 18..
 * VolleySingleton class for RequestQueue and ImageLoader both as single instance
 */

public class VolleySingleton {
    private static VolleySingleton instance;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private static Context context;
    private static int CACHE_SIZE = 20;

    private VolleySingleton(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();

        imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache(){
           private final LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(CACHE_SIZE);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }

        });
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (instance == null) {
            Log.d("VolleySingleton","Make Volley Instance");
            instance = new VolleySingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

}
