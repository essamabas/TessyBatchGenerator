package com.tessy.models;

public class Settings
{
    private Setting[] setting;

    public Setting[] getSetting ()
    {
        return setting;
    }

    public void setSetting (Setting[] setting)
    {
        this.setting = setting;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [setting = "+setting+"]";
    }
}
