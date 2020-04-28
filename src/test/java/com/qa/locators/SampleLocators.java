package com.qa.locators;

import org.openqa.selenium.By;

public class SampleLocators {

	public By getStartedButton() {
		return By.xpath("//div[@class='header-search-form']/following-sibling::a[text()='Get Started']");
	}

	public By mainMenuLink(String mainMenu) {
		return By.xpath("//li[contains(@class,'nav-item')]/a[text()='" + mainMenu + "']");
	}

	public By subMenuLink(String subMenu) {
		return By.xpath("//ul[@class='submenu']//li/a[text()='"+subMenu+"']");
	}

	public By pageTitle() {
		return By.xpath("//h1");
	}

	public By dockerForWindowsButton() {
		return By.xpath("//a[text()='Download for Windows']");
	}
}
