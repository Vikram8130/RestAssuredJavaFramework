# Rest Assured API Automation Project

## Overview

This project is designed to automate the specified API test scenarios for a demo web api service using REST Assured with Java.

## Project Structure

- `src/main/java/api/endpoints`: Contains API endpoints and routes.
- `src/main/java/api/payload`: Contains API test payload.
- `src/main/java/api/tests`: Contains classes for executing and coordinating the test suite.
- `src/main/java/api/reports`: Contains classes related to generating and managing test reports.
- `src/main/java/api/utility`: Contains utility classes.

## Setup

1. Clone the repository.
2. Make you are not connected to any VPN at first run.

## Running the Tests

Execute the `RestAssuredJavaFramework` test suite in following two ways:

1. Through .bat file: Navigate to project parent folder(../RestAssuredJavaFramework/) and double click on "run-Test-Suite.bat" file present there.
2. Through maven build tool: Navigate to project parent folder(../RestAssuredJavaFramework/) and execute "mvn test" command using cmd in the same location.

## Tests Results

- For each test run, test result report will be created at ../nseindiaWebAutomation/test-reports/ folder location.
- User can get into latest dynamically created folder at ../nseindiaWebAutomation/test-reports/Report_YYYYMMDDHHMMSS/HTMLReports/index.html location.

## Test Logs

-For each test run, logs will be saved at ../RestAssuredJavaFramework/logs folder location