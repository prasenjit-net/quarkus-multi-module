package net.prasenjit.poc.client;

import io.smallrye.mutiny.Uni;
import net.prasenjit.poc.models.weather.CurrentWeather;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/data/2.5/weather")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "weather")
@ClientHeaderParam(name = "config-name", value = "weather")
public interface WeatherClient {

    @GET
    Uni<CurrentWeather> getWeatherByCity(@QueryParam("q") String city);
}
