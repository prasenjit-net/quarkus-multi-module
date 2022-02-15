package net.prasenjit.poc;

import net.prasenjit.poc.models.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/person")
@Produces("application/json")
public class PersonResource {

    @GET
    public List<Person> getAllPerson() {
        return Person.listAll();
    }
}
