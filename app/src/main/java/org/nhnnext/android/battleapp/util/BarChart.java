package org.nhnnext.android.battleapp.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Bitmap;

import org.nhnnext.android.battleapp.model.FieldData;

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
    private ValueAnimator valueAnimator;
    private List<FieldData> fieldDataList = new ArrayList<>();
    private List<Bar> barList = new ArrayList<>();

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
        makeBars();
        animationDraw();
    }

    public void makeBars() {
        int i;
        FieldData currFd;
        String[] columns;
        for (i = 0; i < fieldDataList.size(); i++) {
            currFd = fieldDataList.get(i);
            columns = currFd.getColumns();
            barList.add(new Bar(currFd.getFieldName(), columns[1], columns[2], 0, Float.parseFloat(columns[0])));
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int currBaseLine, i = 0;
        for (i = 0; i < barList.size(); i++) {
            currBaseLine = i*(BAR_MARGIN+BAR_HEIGHT);
            Bar bar = barList.get(i);
            paint.setColor(Color.parseColor("#050099"));
            canvas.drawRect(0, currBaseLine, getWidth(), currBaseLine + BAR_HEIGHT, paint);
            paint.setColor(Color.parseColor("#BC2424"));
            canvas.drawRect(0, currBaseLine, getWidth() * (bar.getCurrValue() / 100), currBaseLine + BAR_HEIGHT, paint);
            paint.setTextSize(45);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(Color.YELLOW);
            canvas.drawText(bar.getTitle(), this.getMeasuredWidth()/2, currBaseLine+BAR_HEIGHT-13, paint);
            paint.setColor(Color.WHITE);
            paint.setTextSize(45);
            if (!bar.getLeftWord().equals("")) {
                paint.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(bar.getLeftWord(), PADDING, currBaseLine+10+(BAR_HEIGHT/2), paint);
            }
            if (!bar.getRightWord().equals("")) {
                paint.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(bar.getRightWord(), this.getMeasuredWidth()-PADDING, currBaseLine+10+(BAR_HEIGHT/2), paint);
            }
        }
    }

    private void animationDraw() {
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(2500);
        valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float frac = animation.getAnimatedFraction();

                for (Bar bar : barList) {
                    bar.setCurrValue(bar.getGoalValue() * frac);
                }
                // run on UI Thread
                postInvalidate();
            }
        });
        valueAnimator.start();
    }

    class Bar {
        private String title;
        private String leftWord;
        private String rightWord;
        private float currValue;
        private float goalValue;

        public Bar(String title, float currValue, float goalValue) {
            this(title, "", "", currValue, goalValue);
        }

        public Bar(String title, String leftWord, String rightWord, float currValue, float goalValue) {
            this.title = title;
            this.leftWord = leftWord;
            this.rightWord = rightWord;
            this.currValue = currValue;
            this.goalValue = goalValue;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setLeftWord(String leftWord) {
            this.leftWord = leftWord;
        }

        public void setRightWord(String rightWord) {
            this.rightWord = rightWord;
        }

        public void setCurrValue(float currValue) {
            this.currValue = currValue;
        }

        public void setGoalValue(float goalValue) {
            this.goalValue = goalValue;
        }

        public String getTitle() {
            return title;
        }

        public String getLeftWord() {
            return leftWord;
        }

        public String getRightWord() {
            return rightWord;
        }

        public float getCurrValue() {
            return currValue;
        }

        public float getGoalValue() {
            return goalValue;
        }
    }
}
