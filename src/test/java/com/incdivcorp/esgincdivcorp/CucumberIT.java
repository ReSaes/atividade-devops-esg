package com.incdivcorp.esgincdivcorp;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
// 1. Aponta para a pasta onde estão os arquivos .feature
@SelectClasspathResource("/")
// 2. Define o pacote onde estão os Steps (Glue)
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.incdivcorp.esgincdivcorp.steps")
// 3. Define explicitamente o idioma padrão para o Cucumber não se perder
@ConfigurationParameter(key = Constants.ANSI_COLORS_DISABLED_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports.html")
public class CucumberIT {
}