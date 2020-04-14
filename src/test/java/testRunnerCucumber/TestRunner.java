package testRunnerCucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/features",// package name for .feature file
                    glue = "stepDefinitions")//package name for test runner class

public class TestRunner {

}
