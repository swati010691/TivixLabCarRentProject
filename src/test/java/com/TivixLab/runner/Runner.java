package com.TivixLab.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="E:\\Programing\\eclipse-workspace\\TivixLabsTestProject\\src\\test\\resources\\Features\\CarRent.feature",glue= {"\\com\\TivixLab\\stepDefinations"}
,plugin = {"pretty", "html:target/TestReport"})
public class Runner extends AbstractTestNGCucumberTests{

}
//AbstractTestNGCucumberTests