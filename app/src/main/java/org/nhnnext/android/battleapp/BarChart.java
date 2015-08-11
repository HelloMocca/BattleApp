package org.nhnnext.android.battleapp;

import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by mocca on 2015. 8. 10..
 */
public class BarChart extends View {

    private int BAR_HEIGHT = 75;
    private int BAR_MARGIN = 25;
    private int PADDING = 10;
    private Paint paint;
    private Canvas canvas;
    private float value = 50;
    private float destValue = 0;
    private List<FieldData> fieldDataList = new ArrayList<>();

    public BarChart(Context context) {
        super(context);
        init();
    }

    public BarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BarChart(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(40);
        paint.setAntiAlias(true);
        canvas = new Canvas(Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888));

    }

    public void setItems(List<FieldData> fieldDataList) {
        this.fieldDataList = fieldDataList;
        invalidate();
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int currBaseLine, i = 0;
        for (i = 0; i < fieldDataList.size(); i++) {
            currBaseLine = i*(BAR_MARGIN+BAR_HEIGHT);
            FieldData currData = fieldDataList.get(i);
            String[] columns = currData.getColumns();
            paint.setColor(Color.parseColor("#6799FF"));
            canvas.drawRect(0, currBaseLine, getWidth(), currBaseLine + BAR_HEIGHT, paint);
            paint.setColor(Color.parseColor("#F15F5F"));
            canvas.drawRect(0, currBaseLine, getWidth() * (Float.parseFloat(columns[0])/100), currBaseLine + BAR_HEIGHT, paint);
            paint.setTextSize(60);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(Color.YELLOW);
            canvas.drawText(currData.getFieldName(), this.getMeasuredWidth()/2, currBaseLine+BAR_HEIGHT-10, paint);
            paint.setColor(Color.WHITE);
            paint.setTextSize(50);
            if (!columns[1].equals("")) {
                paint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(columns[1], PADDING, currBaseLine+10+(BAR_HEIGHT/2), paint);
            }
            if (!columns[2].equals("")) {
                paint.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(columns[2], this.getMeasuredWidth()-PADDING, currBaseLine+10+(BAR_HEIGHT/2), paint);
            }
        }
    }

    private void animationDraw() {
        float distance;
        while (value != destValue) {
            distance = destValue - value;
            value += distance / 125;
            if (distance < 0.5) value = destValue;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                //TODO DEBUG LOG
            }
            postInvalidate();   // run on UI Thread
        }
    }
}
