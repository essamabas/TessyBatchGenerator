package com.tessy.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Testcollection
{
    private Folder[] folder;

    private String name;

    @XmlElement    
    public Folder[] getFolder ()
    {
        return folder;
    }

    public void setFolder (Folder[] folder)
    {
        this.folder = folder;
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
        return "Class [folder = "+folder+", name = "+name+"]";
    }
}
