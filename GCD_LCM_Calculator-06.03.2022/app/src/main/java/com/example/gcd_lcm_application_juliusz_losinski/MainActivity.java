package com.example.gcd_lcm_application_juliusz_losinski;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // 1. Setting the state of the activity.
        super.onCreate(savedInstanceState);

        // 2. Setting the layout.
        setContentView(R.layout.activity_main);

        // 3. Setting the event handler for click event for textView GCD.
        ((TextView)(findViewById(R.id.GCD_button))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // 3.1 Getting the value of a.
                    int a = Integer.parseInt(((EditText) findViewById(R.id.input_a)).getText().toString());

                    // 3.2 Getting the value of b.
                    int b = Integer.parseInt(((EditText) findViewById(R.id.input_b)).getText().toString());

                    // 3.3 Calculating and displaying the result.
                    ((TextView)findViewById(R.id.display)).setText("GCD: "+new GCD(a, b).getResult());
                }catch(Exception e)
                {
                    ((EditText)findViewById(R.id.input_a)).setText("");
                    ((EditText)findViewById(R.id.input_b)).setText("");
                }
            }
        });

        // 4. Setting the event handler for click event for textView LCM.
        ((TextView)(findViewById(R.id.LCM_button))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // 3.1 Getting the value of a.
                    int a = Integer.parseInt(((EditText) findViewById(R.id.input_a)).getText().toString());

                    // 3.2 Getting the value of b.
                    int b = Integer.parseInt(((EditText) findViewById(R.id.input_b)).getText().toString());

                    // 3.3 Calculating and displaying the result.
                    ((TextView)findViewById(R.id.display)).setText("LCM: "+new LCM(a, b).getResult());
                }catch(Exception e)
                {
                    ((EditText)findViewById(R.id.input_a)).setText("");
                    ((EditText)findViewById(R.id.input_b)).setText("");
                }
            }
        });
    }
}