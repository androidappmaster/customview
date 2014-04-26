package es.customviewmaster.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;


public class MyTextView extends TextView {

    public MyTextView(Context context) {
        super(context);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setTextSize(35);
    }

    public void setValid(boolean valid) {
        if ( valid ) {
            setTextColor(Color.GREEN);
            return;
        }
        setTextColor(Color.RED);
    }

}
