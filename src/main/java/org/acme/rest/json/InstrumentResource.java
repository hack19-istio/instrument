package org.acme.rest.json;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/instrument")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InstrumentResource {

    private String instrumentId;
    private Instrument instrument = new Instrument("piano_01");
    /*public InstrumentResource(String instrumentId){
        this.instrumentId=instrumentId;
    }*/

    @GET
    public Instrument linstrument() {
        // return should be piano_01 or drums_02
        return instrument;
    }


}