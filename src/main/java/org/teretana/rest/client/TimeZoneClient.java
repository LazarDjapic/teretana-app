package org.teretana.rest.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.teretana.model.TimeZoneResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "timezone-api")
public interface TimeZoneClient {

    @GET
    @Path("/api/time/current/ip")
    TimeZoneResponse getTimeByIp(@QueryParam("ipAddress") String ip);
}