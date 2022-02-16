package net.prasenjit.poc;

import io.smallrye.mutiny.Uni;
import net.prasenjit.poc.client.WeatherClient;
import net.prasenjit.poc.models.weather.CurrentWeather;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Path("/weather")
public class WeatherResource {

    @RestClient
    WeatherClient weatherClient;

    @GET
    public Uni<CurrentWeather> currentWeather() {
        return weatherClient.getWeatherByCity("London");
    }
}
