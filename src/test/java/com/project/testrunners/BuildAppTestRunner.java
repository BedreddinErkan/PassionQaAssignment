package com.project.testrunners;

import cucumber.api.CucumberOptions;

@CucumberOptions(

        features = "src/test/Features/BuildApp.feature",
        tags = "@Done",
        glue= {"com/project/stepdefs"},
        plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/report.html",
                "json:target/cucumber.json"}, dryRun = false

)

public class BuildAppTestRunner extends BaseTestRunner {
}
