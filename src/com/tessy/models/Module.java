package com.tessy.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Module
{
    private String name;

    private Testobject[] testobject;

    @XmlAttribute    
    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @XmlElement    
    public Testobject[] getTestobject ()
    {
        return testobject;
    }

    public void setTestobject (Testobject[] testobject)
    {
        this.testobject = testobject;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", testobject = "+testobject+"]";
    }
}

