package org.timecontrol.rest;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.timecontrol.db.Database;
import org.timecontrol.domain.TijdRegistratie;
import org.timecontrol.domain.Weekstaat;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/weekstaten")
public class WeekstaatResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Weekstaat> getTijdRegistraties() {
        return Database.INSTANCE.getWeekstaten();
    }

    @Path("{jaar}/{weeknummer}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Weekstaat getWeekstaatByWeekNumber(@PathParam("jaar") int jaar, @PathParam("weeknummer") int weeknummer) {
        return Database.INSTANCE.getWeekstaat(jaar, weeknummer);
    }

    @Path("{jaar}/{weeknummer}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveTijdregistratie(@PathParam("jaar") int jaar, @PathParam("weeknummer") int weeknummer, TijdRegistratie registratie) {
        Database.INSTANCE.save(jaar, weeknummer, registratie);
    }
}
