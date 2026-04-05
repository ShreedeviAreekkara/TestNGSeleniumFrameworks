@tag
Feature: purchase the order from an ecommerce website 


Background:
Given I landed on ecommerce page 


@tag2
Scenario Outline:
Given I entered the username <user> and password <password> and logged in 
When I selected the product <productName> and added it to cart
And I checkedout the product <productName> from checkout page
Then "THANKYOU FOR THE ORDER." confirmation message was displayed

Examples:
|          user              |     password     |    productName    |
|       "kichu@gmail.com"    |    "Kichu@123"   |   "ZARA COAT 3"   |

