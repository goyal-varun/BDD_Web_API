Feature: Sign In feature
  I want to be able to Sign in the application

  Background: 
    Given Initialize the elements on the SignIn page

  @ui @SignIn
  Scenario Outline: Sign in successful
    When User clicks on Signin link
    And User enters the username "<username>" and password "<password>" on signin popup
    And User clicks on Signin button on the signin popup
    Then validate that Signin is successful
    And User clicks on Logout button

    Examples: 
      | username              | password |
      | username354@gmail.com | abcd123  |

  @SignIn
  Scenario Outline: Sign in with invalid password
    When User clicks on Signin link
    But User enters the username "<username>" and password "<password>" on signin popup
    And User clicks on Signin button on the signin popup
    Then validate that Signin is unsuccessful for invalid password

    Examples: 
      | username              | password  |
      | username354@gmail.com | abcd12345 |

  @SignIn
  Scenario Outline: Sign in with unregistered user
    When User clicks on Signin link
    But User enters the username "<username>" and password "<password>" on signin popup
    And User clicks on Signin button on the signin popup
    Then validate that Signin is unsuccesful for unregistered user

    Examples: 
      | username     | password  |
      | 19sl@abc.com | abcd12345 |

  @SignIn
  Scenario Outline: Sign in without password
    When User clicks on Signin link
    But User enters the username "<username>" and password "<password>" on signin popup
    And User clicks on Signin button on the signin popup
    Then validate that missing username or password error

    Examples: 
      | username              | password |
      | username354@gmail.com |          |
