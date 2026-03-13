package org.teretana;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.transaction.Transactional;
import java.util.List;

import org.teretana.model.Clan;

@Path("/clanovi")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClanResource {

    @Inject
    ClanRepository repo;

    @GET
    public List<Clan> getAll() {
        return repo.listAll();
    }

    @POST
    @Transactional
    public void addClan(Clan clan) {
        repo.persist(clan);
    }
}
