package com.tessy.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Operation
{
    private String key;

    private Options options;

    @XmlAttribute    
    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }

    @XmlElement
    public Options getOptions ()
    {
        return options;
    }

    public void setOptions (Options options)
    {
        this.options = options;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [key = "+key+", options = "+options+"]";
    }
}
