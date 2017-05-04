# rozetka
Framework is written on JAVA with using of Selenium + Junit. 
Maven is used as build tool. Allure is used for reporting.
Build runs on CI Jenkins periodically with the following schedule settings:

30 01 * * *

Project has the following structure:

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
