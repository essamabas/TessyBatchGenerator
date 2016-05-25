package com.tessy.models;

public class TessyBatch
{
    private Batchtest batchtest;

    public Batchtest getBatchtest ()
    {
        return batchtest;
    }

    public void setBatchtest (Batchtest batchtest)
    {
        this.batchtest = batchtest;
    }

    @Override
    public String toString()
    {
        return "Class [batchtest = "+batchtest+"]";
    }
}
