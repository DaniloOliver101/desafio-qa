package br.com.desafioqa.core;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, features = {"src/test/resources/features"},
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},
        glue = {"classpath:br.com.desafioqa.steps"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        stepNotifications = true,
        tags = {"@TEST"})
public class Runner {

}
