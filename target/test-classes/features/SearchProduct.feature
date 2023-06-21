
Feature: Search and place orders for products
@offerPage
Scenario Outline: Search experiance for both home and offers page
Given user landed on GreenKart landing page
When user searched with shortname <Name> and extracted actual product name
Then user searched with same shortname <Name> in offerspage to check if product has same name
And Validating offers page productName with home page productName

Examples:
|  Name |
|  Tom  |
|  Beet |


