package org.teretana.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.teretana.exception.ClanException;
import org.teretana.model.Clan;
import org.teretana.model.CurrencyResponse;
import org.teretana.rest.client.CurrencyClient;
import org.teretana.service.ClanService;

@Path("/currencyConversion")
@RolesAllowed("admin")
public class CurrencyResource {

    @Inject
    private ClanService clanService;

    @Inject
    @RestClient
    CurrencyClient currencyClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response currencyConversion(@QueryParam("from") String from, @QueryParam("to") String to,
                                       @QueryParam("value") double value, @QueryParam("clanId") Long clanId) {
        try {
            Clan clan = clanService.findById(clanId);
            if (clan == null) {
                throw new ClanException("Clan sa ID " + clanId + " nije pronadjen!");
            }

            CurrencyResponse currencyResponse = currencyClient.getRates(from, to);
            double convertedValue = value * currencyResponse.getRate();

            currencyResponse.setValue(value);
            currencyResponse.setConvertedValue(convertedValue);
            currencyResponse.setClan(clan);

            clan.getCurrencyResponses().add(currencyResponse);
            clanService.updateClan(clan);

            return Response.ok(currencyResponse).build();
        } catch (ClanException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Greska: " + e.getMessage())
                    .build();
        }
    }
}
