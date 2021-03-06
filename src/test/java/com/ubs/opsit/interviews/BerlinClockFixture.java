package com.ubs.opsit.interviews;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import com.ubs.opsit.interviews.clock.util.TimeConverter;
import com.ubs.opsit.interviews.clock.util.impl.BerlinTimeConverter;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Gaurav
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  
 * You will notice the TimeConverter has no implementation ... (hint)
 */
public class BerlinClockFixture {

    private TimeConverter berlinClock;
    private String theTime;

    //Added Constructor to for creating Berlin Clock Converter instance
    public BerlinClockFixture(){
    	berlinClock = new BerlinTimeConverter();
    }
    
    
    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }

    
    @When("the time is $time")
    public void whenTheTimeIs(String time) {
        theTime = time;
    }

    @Then("the clock should look like $theExpectedBerlinClockOutput")
    public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) {
        assertThat(berlinClock.convertTime(theTime)).isEqualTo(theExpectedBerlinClockOutput);
    }    
}
