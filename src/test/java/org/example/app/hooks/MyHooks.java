package org.example.app.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.app.util.RestAssuredExtension;

/**
 * 2/19/2024
 * 3:39 PM
 */
public class MyHooks {
    private Scenario scenario;
    private final ResponseContext context;
    private final RestAssuredExtension extension;

    public MyHooks(ResponseContext context, RestAssuredExtension extension) {
        this.context = context;
        this.extension = extension;
    }

    @Before
    public void setup(Scenario scenario){
        this.scenario=scenario;
        context.setScenario(scenario);
    }
}
