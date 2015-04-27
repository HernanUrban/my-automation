@SmokeTest
Feature: Google Search
   In order to see who is Carlos Gardel
   As a googler user I should be able to find information about Carlos Gardel

Scenario: Google about Carlos Gardel
   Given me in the Google search page
   When I enter "Carlos Gardel" into search field
   And click on search button
   Then verify first link text "Carlos Gardel"
