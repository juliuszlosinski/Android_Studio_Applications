package com.example.lab03_lists_juliusz_losinski;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.Collator;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

// TARGET: Provide the student that will have all the information and comparing methods that are implemented.
@RequiresApi(api = Build.VERSION_CODES.O)
public class Student implements Comparable<Student>
{
    // REGION: STATIC AREA. ===========================]
    // REGION: FIELDS. ---------]
    static ArrayList<Student> ALL_STUDENTS =new ArrayList<Student>();
    static LocalDate TODAY = LocalDate.now();
    static Comparator<Student> comparatorAccordingToAVG=(s1, s2)->
    {
        double delta=s1.getAvg()-s2.getAvg();
        if(delta>0) return 1;
        return (delta<0)? -1: 0;
    };

    static Comparator<Student>comparatorAccordingToNames= Student::compareTo;
    // END REGION --------------]

    // REGION: METHODS. --------]


    // TARGET: Sort the buffer according to average.
    public static void SortAccordingToAVG()
    {
        ALL_STUDENTS.sort(comparatorAccordingToAVG);
    }

    // TARGET: Sort the buffer according to first names/ last names.
    public static void SortAccordingToNames()
    {
        ALL_STUDENTS.sort(comparatorAccordingToNames);
    }

    // TARGET: Fill the buffer with students.
    public static void FillStudents(int[]ids_of_photos)
    {
        // 1. Creating a buffer with first names.
        String[]firstNames={
                "Jack",
                "Johny",
                "Mark",
                "Sylvester",
                "Jeremy",
        };

        // 2. Creating a buffer with last names.
        String[]lastNames={
                "Back",
                "Drake",
                "Greg",
                "Stallone",
                "VanDam",
        };

        // 3. Creating a buffer with fields.
        String[]fields={
                "FE",
                "PiT",
                "FM",
                "FP",
                "FD",
        };

        // 4. Creating a buffer with dates.
        String[]dates={
                "1998-01-11",
                "1995-05-08",
                "2000-11-11",
                "1995-03-18",
                "2005-05-05"
        };

        // 5. Creating a buffer with averages;
        float[]averages={
                4.5f,
                3.5f,
                4.8f,
                5.0f,
                4.3f
        };

        // 5. Filling the buffer with students.
        for(int i=0;i<dates.length;i++)
        {
            // 5.1 Adding a new student.
           new Student(
                    firstNames[i],
                    lastNames[i],
                    fields[i],
                    dates[i],
                    averages[i],
                    ids_of_photos[i]
            );
        }
    }
    // END REGION --------------]
    // END REGION. ====================================]

    // REGION: INSTANCE AREA. =========================]
    // REGION: FIELDS. -------------]
    String firstName;
    String lastName;
    String field;
    String dataOfBirth;
    double avg;
    int photo;
    // END REGION -------------------]

    // REGION: CONSTRUCTORS. -------]
    public Student()
    {
        // 1. Initializing fields of the objects.
        firstName ="John";
        lastName="Black";
        field="PiT";
        dataOfBirth="1999-12-12";
        avg=4.5;
        photo=0;

        // 2. Adding the student to list with all students.
        ALL_STUDENTS.add(this);
    }

    public Student(String firstName, String lastName, String field, String dataOfBirth, double avg, int photo)
    {
        // 1. Initializing fields of the objects.
        this.firstName = firstName;
        this.lastName = lastName;
        this.field = field;
        this.dataOfBirth = dataOfBirth;
        this.avg = avg;
        this.photo = photo;

        // 2. Adding the student to list with all students.
        ALL_STUDENTS.add(this);
    }
    // END REGION -------------------]

    // REGION: PROPERTIES. ------------]
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(String dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
    // END REGION -------------------]

    // REGION: METHODS. ------------]
    @Override
    public String toString() {
        return "Name: " + firstName +
                "\nLast name: " + lastName+
                "\nField: "+ field+
                "\nAVG: "+avg;
    }

    // TARGET: Providing comparing of two students (think about java collections that will sort these students by using this method).
    @Override
    public int compareTo(Student student)
    {
        // 1. Creating the object that will provide comparing two objects.
        Collator collator = Collator.getInstance(new Locale("pl", "PL"));

        // 2. Comparing last names of students.
        int compareLastNames = collator.compare(lastName, student.getLastName());

        // 3. Comparing first names of students.
        int compareFirstNames = collator.compare(firstName, student.getLastName());

        // 4. Checking the results of comparing.
        return (compareLastNames==0)? compareFirstNames: compareLastNames;
    }

    //TARGET: Get age of the student.
    @RequiresApi(api = Build.VERSION_CODES.O)
    public double getAge()
    {
        // 1. Getting the data.
        int year=Integer.parseInt(dataOfBirth.substring(0, 4));
        int month=Integer.parseInt(dataOfBirth.substring(5,7));
        int day=Integer.parseInt(dataOfBirth.substring(8, 10));

        // 2. Creating an object of local date.
        LocalDate date = LocalDate.of(year, month, day);

        // 3. Getting period between current date and student's date of birth.
        Period per= Period.between(date, TODAY);

        // 4. Returng the result.
        double res=per.getYears()+per.getMonths()/12.0+per.getDays()/365.0;

        char[]buff=(res+"").toCharArray();
        boolean dot=false;
        int precision=2;
        String value="";
        for(char c: buff)
        {
            if(precision==0)
            {
                break;
            }
            if(dot)
            {
                precision--;
            }
            if(c=='.')
            {
                dot=true;
            }
            value+=c;
        }
        return Double.parseDouble(value);
    }

    // END REGION -------------------]
    // END REGION =====================================]
}
