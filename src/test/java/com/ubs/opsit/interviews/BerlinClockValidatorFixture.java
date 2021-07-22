package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import com.ubs.opsit.interviews.clock.util.TimeValidator;
import com.ubs.opsit.interviews.clock.util.impl.BerlinTimeValildator;

/**
 * @author Gaurav
 *
 */
public class BerlinClockValidatorFixture {

	private TimeValidator validator;
	private String theTime;
	private String theTimeFormat;
	
	public BerlinClockValidatorFixture(){
		validator = new BerlinTimeValildator() ;
	}
	
	@Test
    public void berlinTimeValidatorAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("validate-input.story")
                .run();
    }

	//When annotation is replace with Given as we are passing two field
    @Given("a clockinput of the time is $time and the timeformat is $timeformat")
    public void aClockinput(String time,String timeformat) {
        theTime = time;
        theTimeFormat = timeformat;
    }

    @Then("the validation should look like $theExpectedBerlinTimeValidationOutput")
    public void thenTheValidationShouldLookLike(String theExpectedBerlinTimeValidationOutput) {
        assertThat(validator.validateTime(theTime, theTimeFormat)).isEqualTo(theExpectedBerlinTimeValidationOutput);
    }    
	
}
