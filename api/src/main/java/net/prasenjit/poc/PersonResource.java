package net.prasenjit.poc;

import io.smallrye.mutiny.Uni;
import net.prasenjit.poc.models.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    @GET
    public Uni<Person> getPerson() {
        return Uni.createFrom().item(new Person("prasenjit", "My Address"));
    }

}
