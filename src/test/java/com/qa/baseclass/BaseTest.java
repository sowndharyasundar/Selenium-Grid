package com.qa.baseclass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.utils.ExcelUtility;

public class BaseTest {
	private static WebDriver driver;
	private static WebDriverWait webdriverWait;
	private static ExtentReports report;
	private static ExtentHtmlReporter htmlReporter;

	@BeforeTest(alwaysRun = true)
	public void setUp() throws Exception {
		setReport();
		ExcelUtility.setExcelFile(System.getProperty("user.dir") + "/Testdata.xlsx", "Sheet1");
	}

	public void setReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/test-report.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Execution Report");
		htmlReporter.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
	}

	@Parameters({ "browser", "url", "wait", "local","docker","cloud" })
	@BeforeMethod(alwaysRun = true)
	public void setup(String browser, String url, long waitTimeout, boolean local,boolean docker, boolean cloud) throws MalformedURLException {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		setDriver(browser, local,docker,cloud);
		setWait(waitTimeout);
		driver.manage().window().maximize();
		driver.get(url);
	}

	public void setDriver(String browser, boolean local,boolean docker,boolean cloud) throws MalformedURLException {
		if (browser.toLowerCase().equals("chrome")) {
			if (local) {
				driver = new ChromeDriver();
			} else {
				if (docker) {
					driver = new RemoteWebDriver(new URL("http://localhost:4646/wd/hub"), getCapabilities());
				}if(cloud){
					 driver=new RemoteWebDriver(new
					 URL("https://sowndharyasundar1:EHm3krb4Ec77nGYURws7@hub-cloud.browserstack.com/wd/hub"),getCapabilities());
				}
			}
		}
	}

	private Capabilities getCapabilities() {
		DesiredCapabilities capability = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		capability.setCapability(ChromeOptions.CAPABILITY, options);
		capability.setCapability("browser", "chrome");
		capability.setCapability("browser_version", "80.0");
		capability.setCapability("os", "Windows");
		capability.setCapability("os_version", "10");
		capability.setCapability("acceptSslCerts", "true");
		capability.setCapability("name", "Sample Test Trial");
		return capability;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public ExtentReports getReport() {
		return report;
	}

	public void setWait(long waitTimeout) {
		webdriverWait = new WebDriverWait(driver, waitTimeout);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public WebDriverWait getWait() {
		return webdriverWait;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDownDriver() {
		driver.quit();
	}

	@AfterTest(alwaysRun = true)
	public void tearDownReport() {
		report.flush();
	}
}