package org.bongz.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.bongz.enums.CategoryType;


/**
 *  Framework Annotation is user built annotation which is annotated on top of test methods to log the author details and 
 * category details to the extent report.<p>
 * 
 * Runtime retention value indicate that this annotation will be available at run time for reflection operations.
 * 
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 *
 * @see org.bongz.tests.MultiplyTests
 * @see org.bongz.enums.CategoryType
 */

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotations {
	
	/**
	 *  Store the authors who created the tests in String[]<p>
	 * Manadatory to enter atleast a value
	 * 
	 * @author Bongz
	 * @return
	 */
	public String[] author();
	
	/**
	 * /**
	 * Stores the category in form of Enum Array. Include the possible values in {@link org.bongz.enums.CategoryType}
	 * 
	 * @author Bongz
	 * @return
	 */
	public CategoryType[] category();

}
