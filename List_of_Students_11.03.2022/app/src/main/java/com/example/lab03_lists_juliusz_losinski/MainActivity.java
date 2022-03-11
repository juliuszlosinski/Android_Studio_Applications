package com.example.lab03_lists_juliusz_losinski;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private StudentAdapter studentArrayAdapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // 1. Reading the instance.
        super.onCreate(savedInstanceState);

        // 2. Setting the layout.
        setContentView(R.layout.activity_main);

        // 3. Checking if list of students is empty.
        if(Student.ALL_STUDENTS.isEmpty())
        {
            // 3.1 Creating the buffer with profiles of students.
            String[]images={
                    "student_0",
                    "student_1",
                    "student_2",
                    "student_3",
                    "student_4"
            };

            // 3.2 Creating the empty buffer for id of images.
            int[]ids= new int[images.length];

            // 3.3 Filling the empty buffer with ids.
            for(int i=0;i<images.length;i++)
            {
                // 3.3.1 Adding the id to buffer.
                ids[i]=getResources().getIdentifier(images[i], "drawable", getPackageName());
            }

            // 3.4 Fill the static buffer with students/ creating the students.
            Student.FillStudents(ids);
        }

        // 4. Creating an adapter for students.
        ListView view=findViewById(R.id.listWithAllStudents);
        studentArrayAdapter=new StudentAdapter(
                this,
                android.R.layout.simple_list_item_checked,
                Student.ALL_STUDENTS
        );


        // 5. Setting up the adapter.
        view.setAdapter(studentArrayAdapter);

        // 6. Setting up the on click listener who listens for click event. This operation includes creating event handler.
        AdapterView.OnItemClickListener iCL = new AdapterView.OnItemClickListener() {
            @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    // 6.1 Finding the display.
                    TextView display = (TextView) findViewById(R.id.displayView);

                    // 6.2 Setting up the text on the display.
                    String lastName=Student.ALL_STUDENTS.get(i).getLastName();
                    String age=((Student.ALL_STUDENTS.get(i).getAge())+"");
                    display.setText(lastName+": "+age);

                    // 6.3 Setting up the image on the current image.
                    ImageView currentImage = (ImageView)findViewById(R.id.currentImage);
                    currentImage.setImageResource(Student.ALL_STUDENTS.get(i).getPhoto());
                }
        };

        // 7. Setting up the listener.
        view.setOnItemClickListener(iCL);

        // 8. Setting up the default image.
        ((ImageView)findViewById(R.id.currentImage)).setImageResource(R.drawable.student_0);

        // 9. Setting up the default text.
        ((TextView)findViewById(R.id.displayView)).setText(Student.ALL_STUDENTS.get(0).getLastName()+": "+Student.ALL_STUDENTS.get(0).getAge());
    }

    // TARGET: Handling the radio buttons.
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onRBDClicked(View view)
    {
        switch(view.getId())
        {
            case R.id.accordingToNames:
                Student.SortAccordingToNames();
                studentArrayAdapter.notifyDataSetChanged();
                break;
            case R.id.accordingToAverage:
                Student.SortAccordingToAVG();
                studentArrayAdapter.notifyDataSetChanged();
                break;
        }
        System.out.println("Sorting!");
    }
}