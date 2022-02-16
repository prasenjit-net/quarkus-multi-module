package net.prasenjit.poc.client.filter;

import net.prasenjit.poc.client.config.ApiConfigGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.net.URI;

@Provider
public class ApiKeyInterceptor implements ClientRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiKeyInterceptor.class);

    @Inject
    ApiConfigGroup apiConfigGroup;

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        String configNName = (String) requestContext.getHeaders().getFirst("config-name");
        if (configNName == null) {
            return;
        }
        final ApiConfigGroup.ApiConfig apiConfig = apiConfigGroup.data().get(configNName);
        if (apiConfig != null && apiConfig.query() != null) {
            URI current = requestContext.getUri();
            UriBuilder uriBuilder = UriBuilder.fromUri(current);
            apiConfig.query().forEach(uriBuilder::queryParam);
            requestContext.setUri(uriBuilder.build());
        }
    }
}
