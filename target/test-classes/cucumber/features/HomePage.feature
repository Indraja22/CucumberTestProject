Feature: Home Page Test

Scenario Outline: Best Buy HomePage Title
Given Open the browser and launch the app url
When User is on the HomePage
Then Verify the title is "<expectedTitle>"
Examples:
|expectedTitle|
|Best Buy International: Select your Country - Best Buy|


Scenario Outline: Best Buy HomePage Title
Given Open the browser and launch the app url
When User is on the HomePage
Then Verify the title is "<expectedTitle>"
Examples:
|expectedTitle|
|Best Buy International: Select your Country - Best Buys|


Scenario Outline: Best Buy HomePage Title
Given Open the browser and launch the app url
When User is on the HomePage
Then Verify the count of links present on the homepage is "<noOfLinks>"
Examples:
|noOfLinks|
|12|