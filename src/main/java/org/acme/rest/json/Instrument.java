package org.acme.rest.json;

import java.util.Objects;

public class Instrument {

    private String name;


    public Instrument() {
        setName(System.getenv("INSTRUMENT_ID"));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
