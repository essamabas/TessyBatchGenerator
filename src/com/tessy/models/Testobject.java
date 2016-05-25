package com.tessy.models;

import javax.xml.bind.annotation.XmlAttribute;

public class Testobject
{
    private String name;

    @XmlAttribute    
    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+"]";
    }
}
