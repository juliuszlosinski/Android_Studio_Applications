package com.example.intentionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    // <summary>
    //  Creating the activity and saving the configuration.
    // </summary>
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 1. Creating activity.
        super.onCreate(savedInstanceState);

        // 2. Saving the content.
        setContentView(R.layout.activity_second);

        // 3. Getting reference to the button.
        Button goToFirstActivity_Button = (Button) findViewById(R.id.buttonGoToFirstActivity);

        // 4. Setting the on click handler.
        goToFirstActivity_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 4.1 Getting the intention.
                Intent intention = getIntent();

                String data=((EditText)findViewById(R.id.textInput)).getText().toString();

                System.out.println("SENT DATA: "+data);

                // 4.2 Putting the data.
                intention.putExtra("data", data);

                // 4.3 Setting the result.
                setResult(RESULT_OK, intention);

                // 4.4 Finishing the activity.
                finish();
            }
        });
    }
}