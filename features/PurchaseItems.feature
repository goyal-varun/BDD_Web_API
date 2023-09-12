Feature: Purchase Items feature
  User is able to add product to cart

  Background: 
    #Given Initialize the elements on the PurchaseItems page
    #And User has Login into the application with username "username354@gmail.com" and password "abcd123"

  @PurchaseItems
  Scenario Outline: Add product(s) to cart
    Given User has Login into the application with username "username354@gmail.com" and password "abcd123"
    And Initialize the elements on the PurchaseItems page
    When User clicks on product type link "<productType>"
    And User searches for a product "<productName>"
    And User adds multiple quantities <productQty> of above product to cart
    And User navigates to cart
    Then validate products in a cart
    And User clears the cart
    And User clicks on Logout button

    Examples: 
      | productType | productName  | productQty |
      | Laptops     | Sony vaio i5 |          2 |

  @PurchaseItems
 	Scenario Outline: Validate items in cart and Cart Value
    Given User has Login into the application with username "username812@gmail.com" and password "abcd123"
    And Initialize the elements on the PurchaseItems page
    When User adds the following product "<productName>" and quantity "<productQty>" under category "<productType>" to cart
    And User navigates to cart
    Then validate that selected products are added to cart
    And User clears the cart
    And User clicks on Logout button

    Examples: 
      | productType 							| productName | productQty |
      | Laptops,Phones, Monitors  | Sony vaio i5: MacBook Pro,Samsung galaxy s6: Iphone 6 32gb, Apple monitor 24	|1:2,1:2,2  | 

  @PurchaseItems
  Scenario Outline: Purchase product(s) added in cart
  	Given User has Login into the application with username "username354@gmail.com" and password "abcd123"
    And User has added product "<productName>" and quantity <productQty> under category "<productType>" to cart
    When User clicks on Place Order button
    And User enters name in Name field "Varun Goyal"
    And User enters country in Country field "India"
    And User enters city in City field "Chandigarh"
    And User enters card details in Credit Card field "1234567812345678"
    And User enters month in Month field "09"
    And User enters year in Year field "28"
    And User clicks on Purchase button
    Then validate that order ID is generated
    And User Logout of the application after final purchase

    Examples: 
      | productType | productName      | productQty |
      | Laptops     | Sony vaio i5     |          2 |
      | Laptops     | Sony vaio i7     |          2 |
      #| Monitors    | Apple monitor 24 |          2 |
      #| Monitors    | Apple monitor 24 |          2 |
      #| Monitors    | Apple monitor 24 |          2 |
      #| Monitors    | Apple monitor 24 |          2 |
