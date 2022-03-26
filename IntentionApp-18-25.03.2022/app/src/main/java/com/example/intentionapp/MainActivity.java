package com.example.intentionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    // ID OF REQUESTS:
    public static final int DATA_REQUEST=1;
    public static final int PICTURE_REQUEST=2;

    // Stack with data.
    private static int nBit=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 1. Setting up the data.
        super.onCreate(savedInstanceState);

        // 2. Setting up the content view.
        setContentView(R.layout.activity_main);

        // 3. Setting up the onClick handler for form.
        ((Button)findViewById(R.id.b_insert_data)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSecondActivity();
            }
        });

        // 4. Setting up the onClick handler for the map.
        ((Button)findViewById(R.id.b_insert_address)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMap();
            }
        });

        // 5. Setting up the click handler for image capture button.
        ((Button)findViewById(R.id.b_photo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToImageCapture();
            }
        });

        // 6. Setting up the click handler for SMS button.
        ((Button)findViewById(R.id.b_sms)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToThirdActivity();
            }
        });
    }

    // <summary>
    // Open SMS activity.
    // </summary>
    private void goToThirdActivity()
    {
        // 1. Creating an intention.
        Intent intention = new Intent(this, ThirdActivity.class);

        // 2. Going to the third activity.
        startActivity(intention);
    }


    // <summary>
    // Open a image capture.
    // </summary>
    private void goToImageCapture()
    {
        // 1. Creating an intention.
        Intent intention = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 2. Starting the intention.
        startActivityForResult(intention, PICTURE_REQUEST);
    }


    // <summary>
    // Run the second activity and pass a intent.
    // </summary>
    private void goToSecondActivity(){
        // 1. Creating an intention.
        Intent intention = new Intent(this, SecondActivity.class);

        // 2. Putting the data into intention.
        intention.putExtra("data","");
        
        // 3. Starting other activity.
        startActivityForResult(intention, DATA_REQUEST);
    }

    // <summary>
    // Going to the another map.
    // </summary>
    private void goToMap(){
        // 0. Getting the text from the input with address.
        String address = ((EditText)findViewById(R.id.i_insert_address)).getText().toString();

        // 1. Creating uri.
        Uri uri = Uri.parse("geo:0,0?q="+address);

        // 3. Creating an intention.
        Intent intention = new Intent(Intent.ACTION_VIEW, uri);

        // 4. Starting the activity.
        startActivity(intention);
    }

    // <summary>
    // Displaying the data by using data from bundle (from intention).
    // </summary>
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        super.onActivityResult(requestCode, resultCode, result);

        switch(requestCode)
        {
            case DATA_REQUEST:
                // 1. Getting the data.
                String data = result.getStringExtra("data");

                // 2. Displaying the data.
                ((TextView)findViewById(R.id.display_inserted_data)).setText(data);
                break;
            case PICTURE_REQUEST:
                // 1. Getting the bundle.
                Bundle bundle = result.getExtras();

                // 2. Getting the image from the bundle.
                Bitmap img = (Bitmap) bundle.get("data");

                // 3. Adding img to buffer with images.
                if(nBit>=4)
                    nBit=0;

                switch(nBit)
                {
                    case 0:
                        ((ImageView)findViewById(R.id.firstImage)).setImageBitmap(img);
                        break;
                    case 1:
                        ((ImageView)findViewById(R.id.secondImage)).setImageBitmap(img);
                        break;
                    case 2:
                        ((ImageView)findViewById(R.id.thirdImage)).setImageBitmap(img);
                        break;
                    case 3:
                        ((ImageView)findViewById(R.id.fourthImage)).setImageBitmap(img);
                        break;
                }
                nBit++;

                // 4. Setting up the current image/ photo.
                ((ImageView)findViewById(R.id.img_photo)).setImageBitmap(img);
                break;
        }


    }

}