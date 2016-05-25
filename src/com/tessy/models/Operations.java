package com.tessy.models;

import javax.xml.bind.annotation.XmlElement;

public class Operations
{
    private Operation operation;

    @XmlElement    
    public Operation getOperation ()
    {
        return operation;
    }

    public void setOperation (Operation operation)
    {
        this.operation = operation;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [operation = "+operation+"]";
    }
}