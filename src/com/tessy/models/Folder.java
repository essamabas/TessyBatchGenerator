package com.tessy.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Folder
{
    private Module[] module;

    private String name;

    @XmlElement    
    public Module[] getModule ()
    {
        return module;
    }

    public void setModule (Module[] module)
    {
        this.module = module;
    }

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
        return "Class [module = "+module+", name = "+name+"]";
    }
}
