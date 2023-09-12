Feature: Sign up feature
  I want to be able to signup on the application

  Background: 
    Given Initialize the elements on the SignUp page

  @SignUp
  Scenario: Signup with new user
    When User clicks on Signup link
    And User enters the new email and password on signup popup
    And User clicks on Signup button on the signup popup
    Then validate that signup is successful

  @SignUp
  Scenario Outline: Signup with existing user
    When User clicks on Signup link
    But User enters the existing email "<username>" and existing password "<password>" on signup popup
    And User clicks on Signup button on the signup popup
    Then validate that signup is unsuccessful

    Examples: 
      | username              | password |
      | username354@gmail.com | abcd123  |
