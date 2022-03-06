package com.example.gcd_lcm_application_juliusz_losinski;

// TARGET: Save the data and calculate the GCD of the values.
public class GCD
{
    // REGION: FIELDS. --------------------------]
    protected int a; // First value.
    protected int b; // Second value.
    // END REGION -------------------------------]

    // REGION: CONSTRUCTORS.---------------------]
    // TARGET: Creating customize constructor.
    public GCD(int a, int b)
    {
        this.a=a;
        this.b=b;
    }

    // TARGET: Creating default constructor.
    public GCD()
    {
        // 1. Setting the default values.
        this.a=12;
        this.b=18;
    }
    // END REGION --------------------------------]

    // REGION: PROPERTIES. -----------------------]
    // TARGET: Getting the value of a.
    public int getA()
    {
        return a;
    }

    // TARGET: Getting the value of b.
    public int getB()
    {
        return b;
    }
    // END REGION --------------------------------]

    // REGION: METHODS. --------------------------]
    // TARGET: Get the GCD of the values ("a" and "b").
    public int getResult()
    {
        while(a>0 && b>0)
        {
            if(a>b)
            {
                a=a%b;
            }
            else
            {
                b=b%a;
            }
        }
        return a+b;
    }
    // END REGION--------------------------------]
}
