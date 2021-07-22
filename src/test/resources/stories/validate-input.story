Story: The Berlin Clock Validation

Narrative:
In order to avoid invalid clock input 
As a Developer 
I want to add validation for berlin clock
					 
Scenario: Currect input
Given a clockinput of the time is 13:34:55 and the timeformat is HH:MM:SS
Then the validation should look like
Validation Succeed
					 
Scenario: Unsupported format
Given a clockinput of the time is 13:34:55 and the timeformat is HH:MM:SSS
Then the validation should look like
Supported format is HH:MM:SS, Please pick System Defined format from Constants.Hours_Minutes_Seconds.

Scenario: Time entered in invalid format
Given a clockinput of the time is 13:34:55:88 and the timeformat is HH:MM:SS
Then the validation should look like
Please enter full time details in HH:MM:SS format

Scenario: Hours entered in invalid format
Given a clockinput of the time is 13AM:34:55 and the timeformat is HH:MM:SS
Then the validation should look like
Please enter hours in integer value range of 0 to 24

Scenario: Minutes entered in invalid format
Given a clockinput of the time is 13:Quater:55 and the timeformat is HH:MM:SS
Then the validation should look like
Please enter minutes in integer value range of 0 to 59

Scenario: Seconds entered in invalid format
Given a clockinput of the time is 13:15:55S and the timeformat is HH:MM:SS
Then the validation should look like
Please enter seconds in integer value range of 0 to 59

Scenario: Invalid value entered for Hours
Given a clockinput of the time is 55:34:55 and the timeformat is HH:MM:SS
Then the validation should look like
Please enter hours within range of 0 to 24

Scenario: Invalid value entered for Minutes
Given a clockinput of the time is 13:-4:55 and the timeformat is HH:MM:SS
Then the validation should look like
Please enter minutes within range of 0 to 59

Scenario: Invalid value entered for Seconds
Given a clockinput of the time is 13:15:1000 and the timeformat is HH:MM:SS
Then the validation should look like
Please enter seconds within range of 0 to 59



