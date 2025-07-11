
package com.skyscanner.hoenscanner;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoenScannerApplication extends Application<io.dropwizard.Configuration> {
    private final List<SearchResult> searchResults = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<io.dropwizard.Configuration> bootstrap) {}

    @Override
    public void run(io.dropwizard.Configuration configuration, Environment environment) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        SearchResult[] hotels = mapper.readValue(new File("src/main/resources/hotels.json"), SearchResult[].class);
        SearchResult[] cars = mapper.readValue(new File("src/main/resources/rental_cars.json"), SearchResult[].class);

        searchResults.addAll(Arrays.asList(hotels));
        searchResults.addAll(Arrays.asList(cars));

        final SearchResource resource = new SearchResource(searchResults);
        environment.jersey().register(resource);
    }
}
