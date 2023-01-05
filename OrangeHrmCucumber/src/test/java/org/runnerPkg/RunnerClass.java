package org.runnerPkg;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles/OrangeHrmFeatureFile.feature",tags= ("not @Negative"),dryRun=false,glue= {"org.stepDefinitionPkg"})
public class RunnerClass {

}
