package org.bongz.constants;

import org.bongz.enums.ConfigProperties;
import org.bongz.utils.PropertyUtils;


/**Framework Constants holds all the constant values used within the framework. If some value needs to be changed
 * or modified often, then it should be stored in the property files
 * 
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 */
public final class FrameworkConstants {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private FrameworkConstants() {}

	private static final int WAITSTRATEGY = 10;
	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executables/chromedriver96.exe";
	private static final String GECKODRIVERPATH = RESOURCESPATH + "/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
	private static final String JSONFILEPATH = RESOURCESPATH + "/config/config.json";
	private static final String EXCELPATH = RESOURCESPATH + "/excel/Book1.xlsx";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA"; 
    public static final String ICON_LAPTOP = "<i class='fa fa-laptop' style='font-size:18px'></i>";
    public static final String ICON_SOCIAL_GITHUB_PAGE_URL = "https://github.com/BoMaseko/";
    public static final String ICON_SOCIAL_LINKEDIN_URL = "https://www.linkedin.com/in/koos-bongani-maseko-13216490/";
    public static final String ICON_SOCIAL_GITHUB_URL = "https://github.com/BoMaseko/SeleniumAutomationFramework/";
    public static final String ICON_SOCIAL_LINKEDIN = "<a href='" + ICON_SOCIAL_LINKEDIN_URL
            + "'><i class='fa fa-linkedin-square' style='font-size:24px'></i></a>";
    public static final String ICON_SOCIAL_GITHUB = "<a href='" + ICON_SOCIAL_GITHUB_URL
            + "'><i class='fa fa-github-square' style='font-size:24px'></i></a>";
    public static final String ICON_CAMERA = "<i class=\"fa fa-camera\" aria-hidden=\"true\"></i>";

    public static final String ICON_BROWSER_EDGE = "edge";
    public static final String ICON_BROWSER_PREFIX = "<i class=\"fa fa-";
    public static final String ICON_BROWSER_SUFFIX = "\" aria-hidden=\"true\"></i>";
    public static final String PROJECT_NAME = "Bongz Automation Project";
    
    public static final String BOLD_START = "<b>";
    public static final String BOLD_END = "</b>";

    /* ICONS - START */

    public static final String ICON_SMILEY_PASS = "<i class='fa fa-smile-o' style='font-size:24px'></i>";
    public static final String ICON_SMILEY_SKIP = "<i class=\"fas fa-frown-open\"></i>";
    public static final String ICON_SMILEY_FAIL = "<i class='fa fa-frown-o' style='font-size:24px'></i>";

    public static final String ICON_OS_WINDOWS = "<i class='fa fa-windows' ></i>";
    public static final String ICON_OS_MAC = "<i class='fa fa-apple' ></i>";
    public static final String ICON_OS_LINUX = "<i class='fa fa-linux' ></i>";
    
    public static final String ICON_Navigate_Right = "<i class='fa fa-arrow-circle-right' ></i>";
    public static final String ICON_BUG = "<i class='fa fa-bug' ></i>";

	private static String extentReportFilePath = "";
	
	
	/**
	 * @author Bongz
	 * @return Extent Report path where the index.html file will be generated.
	 * @throws Exception
	 */
	public static String getExtentReportFilePath() throws Exception {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}
	
	/**
	 * 
	 *@author Bongz
	 * @return If Override reports value in the 
	 * property file is no,then the timestamp will be appended
	 */
	private static String createReportPath() throws Exception {
		if(PropertyUtils.getPropertyValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"/_index.html";
		}
	}

	public static int getWaitstrategy() {
		return WAITSTRATEGY;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static String getJsonfilepath() {
		return JSONFILEPATH;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}

	public static String getGeckodriverpath() {
		return GECKODRIVERPATH;
	}
	
	
}
