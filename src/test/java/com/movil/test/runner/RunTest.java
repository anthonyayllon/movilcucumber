package com.movil.test.runner;


import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/com/movil/test/features/"},
        glue = {"com/movil/test/steps"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        tags = {"@web"})

public class RunTest extends AbstractTestNGCucumberTests{

}

