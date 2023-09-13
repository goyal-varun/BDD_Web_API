Feature: Student Api Feature
  I want to be able to test the Student api in the application

  @api @getstudentapi
  Scenario: Fetch students details with api
    When User send the GET api to fetch the student details
    Then validate the student response is 200
    
  @api @poststudentapi
  Scenario: Add students details with api
    When User send the POST api to add the student details
    #Then validate the student response is 201
    
  @api @putstudentapi
  Scenario: Update students details with api
    When User send the PUT api to update the student details
    Then validate the student response is 200