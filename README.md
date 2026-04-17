# Home Assistant Automation Framework

Selenium + TestNG automation framework for controlling and testing a Home Assistant smart home instance. Runs on a Selenium Grid deployed in a K3s Kubernetes cluster, triggered via Jenkins CI/CD pipelines.

## What It Does

- Automates Home Assistant through the browser UI, navigating shadow DOM web components
- Logs into HA, navigates the dashboard, and interacts with panels (Energy, Lights, etc.)
- Generates ExtentReports with embedded screenshots at each step
- Designed to be extended with test cases for home automation scenarios (scheduling lights, monitoring energy, toggling switches)

## Tech Stack

- **Selenium 4** (WebDriver, RemoteWebDriver)
- **TestNG** (test execution, data-driven via Excel)
- **ExtentReports** (HTML reporting with screenshots)
- **Maven** (build & dependency management)
- **Selenium Grid 4** on K3s (remote browser execution)
- **Jenkins** (CI/CD pipeline)
- **Home Assistant** (system under test)

## Project Structure

```
src/main/java/org/bongz/
├── configs/        # Framework config (Owner library)
├── constants/      # Framework constants
├── driver/         # WebDriver lifecycle & thread-safe management
├── enums/          # WaitStrategy, ConfigProperties, CategoryType
├── factories/      # DriverFactory, ExplicitWaitFactory
├── listeners/      # TestNG listeners (reporting, retry, data provider)
├── pages/          # Page objects (HomeAssistantLoginPage, DashboardPage, etc.)
├── reports/        # ExtentReport setup & logging
└── utils/          # Excel reader, property utils, screenshot utils

src/test/java/org/bongz/tests/
├── BaseTest.java       # @BeforeMethod/@AfterMethod driver setup
└── MultiplyTests.java  # Test cases
```

## Running

```bash
# Run all tests via Maven (uses testng.xml suite)
mvn clean test

# Run a specific test
mvn test -Dtest=MultiplyTests
```

## Configuration

Test data is driven from `src/test/resources/excel/Book2.xlsx` with two sheets:
- **RUNMANAGER** — controls which tests to execute
- **DATA** — test data (credentials, browser, URLs)

Environment config lives in `src/test/resources/config/config.properties`:
- `environment` — which URL set to use (zapre, corepre, etc.)
- `runmode` — `local`, `remote` (Selenium Grid), or `selenoid`
- `seleniumgridurl` — Grid hub endpoint

## Jenkins Pipeline

The included `Jenkinsfile` runs:
1. Checkout from Git
2. `mvn clean compile`
3. `mvn test` (against the Selenium Grid)
4. Publish JUnit results

## Adding New Home Automation Tests

1. Add test data row in the Excel DATA sheet
2. Mark it as `execute=yes` in RUNMANAGER
3. Create a new `@Test` method in `MultiplyTests` (or a new test class)
4. Use `HomeAssistantDashboardPage.navigateToSidebarItem()` to reach the target panel
5. Build page objects for the specific HA panel you want to automate
