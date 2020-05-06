# Selenium-Grid

Developed this with an intention to make it a general framework kind of structure, for anyone to execute their tests in local grid, docker grid or a cloud like Browserstack by just giving the inputs in the testng xml file.

Baseclass package:

BaseTest takes care of the @Before and @After actions to be performed for a test. 
BaseCommands has the selenium commands to perform various actions. 
ListenerTest monitors the test execution and helps the extent test instance to log the execution status in the HTML report.

SampleTest: Holds the test cases that calls the methods from SampleImplementation class. This helps a layman to understand the flow of the test without looking deep into the code.

SampleImplementation: The selenium commands defined in BaseCommands class are invoked here to perform necessary actions on the elements in the web page.

SampleLocators: This returns the locators upon which the action needs to be performed.

Testdata: Data is driven from an excel file.

Extent HTML Report: Available under /reports folder after execution.
