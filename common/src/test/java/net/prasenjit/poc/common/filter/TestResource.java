package net.prasenjit.poc.common.filter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.TEXT_PLAIN)
@Path("/test")
public class TestResource {
    @GET
    public String hello() {
        return "Hello";
    }
}
