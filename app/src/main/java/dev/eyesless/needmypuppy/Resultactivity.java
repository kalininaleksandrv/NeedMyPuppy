package dev.eyesless.needmypuppy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultactivity extends AppCompatActivity {

    public static final String EXTRA_MSG = "empty_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultactivity);
        Intent incItntent = getIntent();
        String incMessage = incItntent.getStringExtra(EXTRA_MSG);
        TextView resultViev = (TextView) findViewById(R.id.resultText);
        resultViev.setText(incMessage);
    }
}
