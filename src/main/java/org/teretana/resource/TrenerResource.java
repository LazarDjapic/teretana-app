package org.teretana.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.teretana.exception.ClanException;
import org.teretana.model.Termin;
import org.teretana.model.Trener;
import org.teretana.service.TrenerService;

@Path("/trener")
@RolesAllowed("admin")
public class TrenerResource {

    @Inject
    private TrenerService trenerService;

    @POST
    @Path("/addTrener")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTrener(Trener trener) {
        try {
            trenerService.createTrener(trener);
            return Response.ok().build();
        } catch (ClanException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok().entity(trenerService.getAllTreneri()).build();
    }


    @GET
    @Path("/getTerminiByProgramId")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTermini(@QueryParam("id") Long id) {
        return Response.ok().entity(trenerService.getTerminiByProgramId(id)).build();
    }

    @POST
    @Path("/addTermin")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTermin(Termin termin) {
        try {
            trenerService.createTermin(termin);
            return Response.ok().build();
        } catch (ClanException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
