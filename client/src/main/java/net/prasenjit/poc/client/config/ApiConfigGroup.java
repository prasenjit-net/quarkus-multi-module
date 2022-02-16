package net.prasenjit.poc.client.config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithParentName;

import java.util.Map;

@ConfigMapping(prefix = "api")
public interface ApiConfigGroup {

    @WithParentName
    Map<String, ApiConfig> data();

    interface ApiConfig {
        Map<String, String> query();
    }

}
