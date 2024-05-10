Feature: Demo Case Suite

  Background:
    Given user on the homepage

  @smoke
  Scenario: Verify home page is open
    Then verify that home page is open

  @smoke
  Scenario: Insider QA jobs positions
    And select "Company" from main manu and "Careers" from submenu on homepage
    Then verify that careers page is open
    And verify that teams section on careers page
    And verify that locations section on careers page
    And verify that life at insider section on careers page
    When click see all teams button on careers page
    And click Quality Assurance team on careers page
    And click see all QA jobs button on quality assurance page
    And select "Istanbul, Turkey" as location and "Quality Assurance" as department on open positions page
    Then verify QA jobs list on open positions page
    When click first job view role button on open positions page
    Then verify that job detail page is open