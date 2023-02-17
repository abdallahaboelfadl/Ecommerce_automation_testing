@smoke
Feature:  F07_followUs | users could open links in follow us

  Scenario: user open facebook
    When user click on facebook
    Then user navigate to facebook page
  Scenario: user opens twitter link
    When user click on twitter icon
    Then user navigate to twitter page

  Scenario: user opens rss link
    When user click on rss icon
    Then user navigate to rss

  Scenario: user opens youtube link
    When user click on youtube icon
    Then user navigate to youtube page