Feature: User Api Feature
  I want to be able to test the user api in the application

  @api @createuserapi
  Scenario: Create user with api
    When User send the post api for creating the user
    Then validate the users response is 200
    

  