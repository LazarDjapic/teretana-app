package org.teretana.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.teretana.model.Clan;
import org.teretana.service.ClanService;

import java.util.List;

@Path("/clan")
public class ClanResource {

    @Inject
    private ClanService clanService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addClan")
    public String addClan(Clan clan) {
        clanService.createClan(clan);
        return "Clan dodat";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllClanovi")
    public Response getAllClanovi() {
        List<Clan> clanovi = clanService.getAllClanovi();
        return Response.ok().entity(clanovi).build();
    }
}
