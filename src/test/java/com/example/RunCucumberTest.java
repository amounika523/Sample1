package com.example;

import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.*;


import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/api.feature")
//@ConfigurationParameter(key = TAGS_PROPERTY_NAME, value = "@smoke")
@ConfigurationParameter(key = "cucumber.glue", value = "com.example.steps")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:target/cucumber-report.html")
public class RunCucumberTest {
}