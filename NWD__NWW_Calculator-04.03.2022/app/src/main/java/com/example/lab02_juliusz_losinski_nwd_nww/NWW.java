package com.example.lab02_juliusz_losinski_nwd_nww;

public class NWW extends NWD
{
    // REGION: Constructors. -----------]
    NWW(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    // ----------------------------------]

    // REGION: Methods. ------------------]
    // TARGET: Getting the result of nww.
    public int getResult()
    {
        return this.x*this.y/super.getResult();
    }
    // ------------------------------------]
}
