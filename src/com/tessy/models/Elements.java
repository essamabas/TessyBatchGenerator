package com.tessy.models;

import javax.xml.bind.annotation.XmlElement;

public class Elements
{
    private Testcollection[] testcollection;

    @XmlElement    
    public Testcollection[] getTestcollection ()
    {
        return testcollection;
    }

    public void setTestcollection (Testcollection[] testcollection)
    {
        this.testcollection = testcollection;
    }

    @Override
    public String toString()
    {
        return "Class [testcollection = "+testcollection+"]";
    }
}
