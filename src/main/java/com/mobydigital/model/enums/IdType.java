package com.mobydigital.model.enums;

public enum IdType {

    DNI("DNI"),
    LE("LE"),
    LC("LC");

    private final String string;

    IdType (final String string)
    {
        this.string = string;
    }

    // public String getType(){return string;}  ver si despues se usa, sino sacarlo

}
