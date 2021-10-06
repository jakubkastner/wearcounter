package cz.jkastner.wearcounter;

import android.content.Context;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends WearableActivity {

    private TextView mTextView;
    private Counter counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();

        // init counter
        counter = new Counter();
        Button clickedButton = (Button)findViewById(R.id.buttonCounter);
        clickedButton.setText(counter.getNumber());
    }

    /**
     * Clicked on main button
     * @param v view
     */
    public void counterClick(View v)
    {
        // check max int
        if (!counter.addNumber())
        {
            Context toastContext = getApplicationContext();
            CharSequence toastText = "Maximum number reached!";
            int toastDuration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(toastContext, toastText, toastDuration);
            toast.show();
            return;
        }

        Button clickedButton = (Button)findViewById(R.id.buttonCounter);
        clickedButton.setText(counter.getNumber());
    }
}
