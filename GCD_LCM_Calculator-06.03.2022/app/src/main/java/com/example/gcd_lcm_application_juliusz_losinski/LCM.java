package com.example.gcd_lcm_application_juliusz_losinski;

// TARGET: Calculate the LCM of the values.
public class LCM extends GCD
{
    // REGION: CONSTRUCTORS. --------------]
    // TARGET: Create default constructor.
    public LCM()
    {
        // 1. Setting the default values.
        super();
    }

    // TARGET: Create customize constructor.
    public LCM(int a, int b)
    {
        // 1. Setting the values.
        super(a, b);
    }
    // ------------------------------------]

    // REGION: Methods.--------------------]
    // TARGET: Get the LCM of the values.
    public int getResult()
    {
        return a*b/super.getResult();
    }
    // END REGION -------------------------]
}
