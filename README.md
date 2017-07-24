# rozetka

+ ### JAVA 8
+ ### Selenuim WebDriver
+ ###JUnit
+ ### Maven
+ ### Allure

**Project has the following structure:**
```
pom.xml - Maven configuration file;
src/main/resources/settings.properties - property file with initial settings
src/main/drivers - storage for drivers;
src/main/java/pages - Page Object directory;
src/main/java/pages/BasePage.java - superclass for all pages;
src/main/java/utils/DbConnector.java - Class for managing database connection;
src/main/java/utils/DriverFactory.java - class for managing webdriver instance;
src/main/java/utils/PropertyConfig.java - class responsible for reading initial settings;
src/test/java - directory with tests;
src/test/java/BaseTest.java - superclass for all tests;
```
