@tag
Feature: To create an order placement flow an confirmtion through ecommerce 

Background: 
Given I Landed on ecommerce page


@tag2
Scenario Outline: Positive test to submit the order 
Given I logged in with username <username> and password <password>
When I select the product with productname <productname>
And verify if the cart has product with <productname> and checkout to Checkout page and place the order
Then "THANKYOU FOR THE ORDER." message is displayed.

Examples:
  |        username           |        password          |      productname        |
  |  kichu@gmail.com          |       Kichu@123          |      ZARA COAT 3        |
  


