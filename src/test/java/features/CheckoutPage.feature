
Feature: Place the orders for products
@placeOrder
Scenario Outline: Search experiance for both home and offers page
Given user landed on GreenKart landing page
When user searched with shortname <Name> and extracted actual product name
And added "3" items of selected product to the cart
Then user proceeds to checkout and validate the <Name> items in page
And Verify user has ability to add promocode and place the order

Examples:
|  Name |
|  Tom  |
|  Car |


