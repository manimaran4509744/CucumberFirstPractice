Feature:To test Orange Hrm login functionality
@Positive
	Scenario:To test orange Hrm with valid credentials
	Given User is on loginpage
	When user enters valid credentials
	|Username|Password|
	|Admin|admin123|
	And user clicks login
	Then user should see homepage

@Negative
	Scenario:To test orange Hrm with invalid credentials
	Given User is on the loginpage
	When user enters invalid credentials
	|Username|Password|
	|akash|akash123|
	And user clicks login button
	Then user should get error message