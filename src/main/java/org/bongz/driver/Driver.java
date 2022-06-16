
/*
MIT License
Copyright (c) 2021 Bongani Maseko
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package org.bongz.driver;

import java.util.Objects;

import org.aeonbits.owner.ConfigFactory;
import org.bongz.configs.FrameworkConfig;
import org.bongz.factories.DriverFactory;


/**
 * 
 * Driver class is responsible for invoking and closing the browsers.
 * <p>
 * It is also responsible for setting the driver variable to DriverManager <p>
 * which handles the thread safety for the webdriver instance<p>
 * 
 * 
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 *
 * @see DriverManager
 * @see org.bongz.tests.BaseTest
 */
public final class Driver {

	/**
	 *  Private constructor to avoid external instantiation
	 */
	private Driver() {}


	/**
	 * Gets the browser value and initialise the browser based on that
	 * 
	 * @param browser Value will be passed from {@link org.bongz.tests.BaseTest}. Values can be chrome and firefox
	 * @param version
	 * @throws Exception
	 */
	public static void initDriver(String browser, String version) throws Exception {
		
		FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
		
		if(Objects.isNull(DriverManager.getDriver())) {
			
			
			DriverManager.setDriver(DriverFactory.getDriver(browser, version));
			//DriverManager.getDriver().get(PropertyUtils.getPropertyValue(ConfigProperties.URL));
			//DriverManager.getDriver().get(JsonUtils.getPropertyValue(ConfigProperties.URL));
			DriverManager.getDriver().get(config.url());
			
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().manage().window().maximize();
			
		}
	}

	/**
	 *  Terminates the browser instance.
	 * Sets the threadlocal to default value, i.e null.
	 * @author Bongz
	 */
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
