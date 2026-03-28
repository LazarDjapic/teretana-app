package org.teretana.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.teretana.exception.ClanException;
import org.teretana.model.Clan;
import org.teretana.model.Clanarina;
import org.teretana.service.ClanService;

import java.util.List;

@Path("/clan")
public class ClanResource {

    @Inject
    private ClanService clanService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addClan")
    public Response addClan(Clan clan) {
      try {
        clanService.createClan(clan);
      } catch (ClanException e) {
          return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
      }
      return Response.ok().build();
    }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getAllClanovi")
  public Response getAllClanovi() {
    List<Clan> clanovi = null;
    try {
      clanovi = clanService.getAllClanovi();
    } catch (ClanException e) {
      return Response.status(Response.Status.NO_CONTENT).entity(e.getMessage()).build();
    }
    return Response.ok().entity(clanovi).build();
  }

  // Tačka 3 domaćeg: Pretraga entiteta koristeći @QueryParam
  @GET
  @Path("/getClanByIme")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getClanByIme(@QueryParam("ime") String name){
      List<Clan> clanovi = clanService.getClanByIme(name);
      return Response.ok().entity(clanovi).build();
  }

  // Tačka 5 domaćeg: Endpoint koji vraća kolekciju (članarine) za ID člana
  @GET
  @Path("/getClanarineByClanId")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getClanarineByClanId(@QueryParam("id") Long id){
    List<Clanarina> clanarine = clanService.getClanarineByClanId(id);

    return Response.ok().entity(clanarine).build();
  }
}