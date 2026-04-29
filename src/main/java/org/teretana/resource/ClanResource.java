package org.teretana.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.teretana.exception.ClanException;
import org.teretana.model.Clan;
import org.teretana.model.Clanarina;
import org.teretana.service.ClanService;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.teretana.rest.client.IpClient;
import org.teretana.rest.client.TimeZoneClient;
import org.teretana.model.TimeZoneLog;
import org.teretana.model.TimeZoneResponse;

import java.util.List;

@Path("/clan")
@RolesAllowed("admin")
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

  //Pretraga entiteta koristeći @QueryParam
  @GET
  @Path("/getClanByIme")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getClanByIme(@QueryParam("ime") String name){
      List<Clan> clanovi = clanService.getClanByIme(name);
      return Response.ok().entity(clanovi).build();
  }

  //Endpoint koji vraća kolekciju (članarine) za ID člana
  @GET
  @Path("/getClanarineByClanId")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getClanarineByClanId(@QueryParam("id") Long id){
    List<Clanarina> clanarine = clanService.getClanarineByClanId(id);

    return Response.ok().entity(clanarine).build();
  }


    @Inject
    @RestClient
    IpClient ipClient;

    @Inject
    @RestClient
    TimeZoneClient timeZoneClient;

    @GET
    @Path("/getTimezoneByIP")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTimezoneByIP(@QueryParam("userId") Long userId) {
    try {
        Clan clan = clanService.findById(userId);
        if (clan == null) {
            throw new ClanException("Korisnik sa ID " + userId + " nije pronađen!");
        }

        String mojIp = "85.94.121.233"; 
        TimeZoneResponse apiOdgovor = timeZoneClient.getTimeByIp(mojIp);
        
        TimeZoneLog noviLog = new TimeZoneLog(mojIp, apiOdgovor.getTimeZone(), apiOdgovor.getDateTime(), clan);
        
        clan.getTimeLogs().add(noviLog);
        clanService.updateClan(clan);

        return Response.ok().entity(clan).build();

    } catch (ClanException e) {
        return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Greška: " + e.getMessage()).build();
    }
  }

  

}