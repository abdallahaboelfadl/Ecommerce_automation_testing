@smoke
Feature:  F06_homeSliders | user select slider from home page

  Scenario: user select first slider from home page and open it
    When user press on first home slider iphone
    Then user navigate to iphone page

  Scenario: user select second slider from home page
    When user press on first home slider galaxy
    Then user redirect to galaxy page