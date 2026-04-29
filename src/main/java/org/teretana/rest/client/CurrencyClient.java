package org.teretana.rest.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.teretana.model.CurrencyResponse;

@RegisterRestClient(configKey = "currency-api")
public interface CurrencyClient {

    @GET
    @Path("/api/rates")
    CurrencyResponse getRates(@QueryParam("from") String from, @QueryParam("to") String to);
}
