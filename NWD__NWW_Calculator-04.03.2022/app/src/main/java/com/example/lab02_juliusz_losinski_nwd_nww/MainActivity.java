package com.example.lab02_juliusz_losinski_nwd_nww;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // REGION: Methods. ---------------------------------]
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // 1. Saving the state that contains data.
        super.onCreate(savedInstanceState);

        // 2. Setting the content view.
        setContentView(R.layout.activity_main);

        // 3. Getting the views.
        View nwd_view=findViewById(R.id.idNWD);
        View nww_view=findViewById(R.id.idNWW);

        // 4. Creating listeners for the views.
        View.OnClickListener nwd_view_listener=new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // 4.0 Getting the views.
                EditText inputA=findViewById(R.id.inputTextA);
                EditText inputB=findViewById(R.id.inputTextB);

                // 4.1 Getting the values of a and b.
                String a=inputA.getText().toString();
                String b=inputB.getText().toString();

                try {
                    // 4.2 Parsing the values.
                    int i_a = Integer.parseInt(a);
                    int i_b = Integer.parseInt(b);

                    // 4.3 Calculating the NWD value.
                    int nwd_result = new NWD(i_a, i_b).getResult();

                    // 4.4 Displaying the nwd value.
                    TextView display = (TextView)findViewById(R.id.label);
                    display.setText("NWD: "+nwd_result);
                }catch(Exception e)
                {
                    // 4.2 Setting the empty values.
                    inputA.setText("");
                    inputB.setText("");
                }
            }
        };

        View.OnClickListener nww_view_listener=new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // 4.0 Getting the views.
                EditText inputA=findViewById(R.id.inputTextA);
                EditText inputB=findViewById(R.id.inputTextB);

                // 4.1 Getting the values of a and b.
                String a=inputA.getText().toString();
                String b=inputB.getText().toString();

                try {
                    // 4.2 Parsing the values.
                    int i_a = Integer.parseInt(a);
                    int i_b = Integer.parseInt(b);

                    // 4.3 Calculating the NWD value.
                    int nwd_result = new NWW(i_a, i_b).getResult();

                    // 4.4 Displaying the nwd value.
                    TextView display = (TextView)findViewById(R.id.label);
                    display.setText("NWW: "+nwd_result);
                }catch(Exception e)
                {
                    // 4.2 Setting the empty values.
                    inputA.setText("");
                    inputB.setText("");
                }
            }
        };

        // 5. Adding the listeners.
        nwd_view.setOnClickListener(nwd_view_listener);
        nww_view.setOnClickListener(nww_view_listener);
    }
    // -------------------------------------------------------------]
}