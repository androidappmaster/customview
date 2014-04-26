package es.customviewmaster;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import es.customviewmaster.view.ArcView;
import es.customviewmaster.view.MyTextView;


public class MainActivity extends ActionBarActivity {

    private ArcView arcView;
    private MyTextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arcView = (ArcView) findViewById(R.id.my_arc_view);
        arcView.setPercent(25);

        myTextView = (MyTextView) findViewById(R.id.my_textview);
        myTextView.setValid(false);
    }

}
