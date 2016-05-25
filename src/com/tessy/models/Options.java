package com.tessy.models;

import javax.xml.bind.annotation.XmlElement;

public class Options
{
    private Option[] option;

    @XmlElement
    public Option[] getOption ()
    {
        return option;
    }

    public void setOption (Option[] option)
    {
        this.option = option;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [option = "+option+"]";
    }
}
