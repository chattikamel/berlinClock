package com.home.berlinclock;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.time.LocalTime;

public class BerlinClockSteps {

    private  BerlinClockConverter berlinClockConverter;

    @Given("^I have started the converter$")
    public void i_have_started_the_converter() throws Throwable {
        berlinClockConverter = new BerlinClockConverter();
    }

    @When("^I enter (.+)$")
    public void i_enter_time(@Transform(LocalTimeConverter.class) LocalTime time) throws Throwable {
        berlinClockConverter.time(time);
    }

    @Then("^(.+) is returned for the single minutes row$")
    public void row_is_returned_for_the_single_minutes_row(String row) throws Throwable {

        Assert.assertEquals(row, berlinClockConverter.singleMinutesRow());
    }

    @Then("^(.+) is returned for the five minutes row$")
    public void row_is_returned_for_the_five_minutes_row(String row) throws Throwable {
        Assert.assertEquals(row, berlinClockConverter.fiveMinutesRow());
    }

    @Then("^(.+) is returned for the single hours row$")
    public void row_is_returned_for_the_single_hours_row(String row) throws Throwable {
        Assert.assertEquals(row ,berlinClockConverter.singleHoursRow());
    }

    @Then("^(.+) is returned for the five hours row$")
    public void row_is_returned_for_the_five_hours_row(String row) throws Throwable {
        Assert.assertEquals(row ,berlinClockConverter.fiveHoursRow());
    }

    @Then("^(.+) is returned for the seconds lamp$")
    public void lamp_is_returned_for_the_seconds_lamp(String lamp) throws Throwable {
        Assert.assertEquals(lamp ,berlinClockConverter.secondsLamp());
    }

    @Then("^(.+) is returned$")
    public void clock_is_returned(String clock) throws Throwable {
        Assert.assertEquals(berlinClockConverter.entireClock(), clock);
    }
}
