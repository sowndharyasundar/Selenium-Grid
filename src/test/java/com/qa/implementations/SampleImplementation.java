package com.qa.implementations;

import com.qa.baseclass.BaseCommands;
import com.qa.locators.SampleLocators;

public class SampleImplementation {
	BaseCommands baseCommands = new BaseCommands();
	SampleLocators locators = new SampleLocators();

	public void clickGetStarted() throws Exception {
		baseCommands.clickElement(locators.getStartedButton());
	}

	public void navigateToMenu(String menu, String subMenu) throws Exception {
		baseCommands.waitForElementClickability(locators.mainMenuLink(menu));
		baseCommands.hoverAndClickElement(locators.mainMenuLink(menu), locators.subMenuLink(subMenu));
	}

	public void assertTitleDisplayed(String expectedTitle) throws Exception {
		baseCommands.assertElementText(locators.pageTitle(), expectedTitle);
	}

	public void clickDockerForWindows() throws Exception {
		baseCommands.clickElement(locators.dockerForWindowsButton());
	}

	public void switchToTab(int index) throws Exception {
		baseCommands.switchFocusToTab(index);
		// TODO Auto-generated method stub

	}

	public void scrollToDockerForWindowsButton() throws Exception {
		baseCommands.scrollToElement(locators.dockerForWindowsButton());
	}
}
