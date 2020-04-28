package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.baseclass.BaseTest;
import com.qa.implementations.SampleImplementation;
import com.qa.utils.ExcelUtility;

public class SampleTest extends BaseTest {
	SampleImplementation implementation = new SampleImplementation();
	@Test
	public void dockerDesktop() throws Exception {
		implementation.clickGetStarted();
		implementation.navigateToMenu(ExcelUtility.getCellData(1, 0), ExcelUtility.getCellData(1, 1));
		implementation.assertTitleDisplayed(ExcelUtility.getCellData(1, 2));
		implementation.scrollToDockerForWindowsButton();
		implementation.clickDockerForWindows();
		implementation.switchToTab(1);
		implementation.assertTitleDisplayed(ExcelUtility.getCellData(1, 3));
		implementation.switchToTab(0);
		implementation.assertTitleDisplayed(ExcelUtility.getCellData(1, 2));
	}
	
	@Test
	public void dockerAboutUs() throws Exception {
		implementation.clickGetStarted();
		implementation.navigateToMenu(ExcelUtility.getCellData(2, 0), ExcelUtility.getCellData(2,1));
		implementation.assertTitleDisplayed(ExcelUtility.getCellData(2, 2));
	}
}
