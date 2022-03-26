package com.example.intentionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 1. Setting up activity.
        super.onCreate(savedInstanceState);

        // 2. Setting up the content view.
        setContentView(R.layout.activity_third);

        // 3. Setting up the on click back handler.
        ((Button)findViewById(R.id.b_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFirstActivity();
            }
        });

        // 4. Setting up the on click sms handler.
        ((Button)findViewById(R.id.b_sms)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSMSActivity();
            }
        });
    }

    // <summary>
    // Going to the sms view/ activity.
    // </summary>
    private void goToSMSActivity(){
        // 1. Setting up the uri.
        Uri uri= Uri.parse("smsto:");

        // 2. Creating an intention.
        Intent intention = new Intent(Intent.ACTION_SENDTO, uri);
        intention.putExtra("sms_body", ((EditText)findViewById(R.id.t_content)).getText().toString());
        intention.putExtra("address", ((EditText)findViewById(R.id.t_address)).getText().toString());

        // 3. Starting the activity.
        startActivity(intention);

        // 4. Finishing.
        finish();
    }

    // <summary>
    // Going back to the main/ first activity.
    // </summary>
    private void goToFirstActivity()
    {
        // 1. Creating the intention.
        Intent intention=new Intent(this, MainActivity.class);

        // 2. Starting the activity.
        startActivity(intention);
    }
}