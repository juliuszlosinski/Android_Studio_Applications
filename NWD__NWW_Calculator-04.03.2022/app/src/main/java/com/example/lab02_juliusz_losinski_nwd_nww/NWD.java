package com.example.lab02_juliusz_losinski_nwd_nww;

public class NWD
{
    // REGION: FIELDS. ---------------]
    protected int x;
    protected int y;
    // END REGION---------------------]

    // REGION: CONSTRUCTORS. ---------]
    public NWD(int x, int y)
    {
        // 1. Setting the values.
        this.x = x;
        this.y = y;
    }

    public NWD()
    {
        // 1. Setting the values.
        this.x = 12;
        this.y = 18;
    }
    // -------------------------------]

    // REGION: PROPERTIES. -----------]
    // TARGET: Getting the number x.
    public int getX() {
        return x;
    }

    // TARGET: Getting the number y.
    public int getY() {
        return y;
    }
    // --------------------------------]

    // TARGET: Calculating the result.
    public int getResult()
    {
        while(x>0 && y >0)
        {
            if(x>y)
            {
                x=x%y;
            }
            else
            {
                y=y%x;
            }
        }
        return x+y;
    }
}
