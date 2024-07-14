package org.example.app;

import static org.junit.Assert.assertTrue;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Unit test for simple App.
 */
@CucumberOptions(
//        features = {"classpath:features/GetAccessToken.feature"},
        features = {"src/test/resources/features/CreateOrder.feature"},

        dryRun = false,
        monochrome = true,
        glue = {"org.example.app.stepDefs","org.example.app.hooks"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class AppTestRunner extends AbstractTestNGCucumberTests
{
    /**
     * Rigorous Test :-)
     */

}
