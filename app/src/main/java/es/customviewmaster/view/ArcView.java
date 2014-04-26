package es.customviewmaster.view;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import es.customviewmaster.R;

public class ArcView extends View {

    private int bgColor, arcColor;

    private int percent = 0;

    private RectF oval;
    private float initAngle = 180;
    private float sweepTotal = 180;
    private float sweep = 0;
    private float left, top, right, bottom, radius;

    public ArcView(Context context) {
        super(context);
    }

    public ArcView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.ArcView);
        bgColor = values.getColor(R.styleable.ArcView_backgroundColor, 0);
        arcColor = values.getColor(R.styleable.ArcView_arcColor, 0);
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int reference = getWidth() > getHeight() ? getHeight() : getWidth();
        radius = reference / 3;

        left = (getWidth() / 2) - radius;
        top = (getHeight() / 2) - radius;
        bottom = (getHeight() / 2) + radius;
        right = (getWidth() / 2) + radius;

        oval = new RectF();
        oval.set(left, top, right, bottom);

        Paint arcPaint = new Paint();
        arcPaint.setAntiAlias(true);
        // 0xFF0000FF = 0xaarrggbb
        arcPaint.setColor(bgColor);
        arcPaint.setStrokeWidth(80);
        arcPaint.setStyle(Paint.Style.STROKE);

        canvas.drawArc(oval, initAngle, sweepTotal, false, arcPaint);

        sweep = percent * (sweepTotal / 100);
        arcPaint.setColor(arcColor);
        arcPaint.setStrokeWidth(40);
        canvas.drawArc(oval, initAngle, sweep, false, arcPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_MOVE) {

            float positionX = event.getX() - left;
            float widthPercent = (positionX / oval.width()) * 100;

            if ( widthPercent < 0 ) {
                widthPercent = 0;
            } else if (widthPercent > 100) {
                widthPercent = 100;
            }

            setPercent((int) widthPercent);
            Log.d("xxx", " posx " + positionX);
            Log.d("xxx", " left " + oval.width() + " percent " + (int) (positionX / oval.width()));

        }

        return true;
    }

}
