package com.tessy.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
// Ref: http://stackoverflow.com/questions/26959343/convert-java-object-to-xml-string
// Ref: http://pojo.sodhanalibrary.com/

@XmlRootElement
public class Batchtest
{
    private Settings settings;

    private Operations operations;

    private Elements elements;

    @XmlElement
    public Settings getSettings ()
    {
        return settings;
    }

    public void setSettings (Settings settings)
    {
        this.settings = settings;
    }

    @XmlElement    
    public Operations getOperations ()
    {
        return operations;
    }

    public void setOperations (Operations operations)
    {
        this.operations = operations;
    }

    @XmlElement
    public Elements getElements ()
    {
        return elements;
    }

    public void setElements (Elements elements)
    {
        this.elements = elements;
    }

    @Override
    public String toString()
    {
        return "Class [settings = "+settings+", operations = "+operations+", elements = "+elements+"]";
    }
}
