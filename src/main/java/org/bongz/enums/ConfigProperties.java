package org.bongz.enums;


/**
 * Enums to restrict the values used on Property files. Without using enums there can be null pointer exceptions happening
 * because of typos.
 * <p>
 * Whenever a new value is added to property file, corresponding enum should be created here.<p>
 * 
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 *@see org.bongz.utils.PropertyUtils
 */
public enum ConfigProperties {
	URL,
	OVERRIDEREPORTS,
	PASSEDSTEPSCREENSHOT,
	FAILEDSTEPSCREENSHOT,
	SKIPPEDSTEPSCREENSHOT,
	RETRYFAILEDTESTS,
	SENDRESULTSTOELK,
	SELENIUMGRIDURL,
	ELASTICURL,
	SENDEMAILREPORT,
	RUNMODE,
	BROWSER
}
