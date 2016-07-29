/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.mobile.sdk.util;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bruno Farache
 */
public class ClassNames {

	public static String className(String filter) {
		return classNames().getProperty(filter);
	}

	protected static Properties classNames() {
		if (classNames == null) {
			classNames = new Properties();

			InputStream is = ClassNames.class.getResourceAsStream(
				"/class-names.properties");

			try {
				classNames.load(is);
			}
			catch (IOException ioe) {
				log.log(
					Level.SEVERE, "Could not load class-names.properties", ioe);
			}

			InputStream ext = ClassNames.class.getResourceAsStream(
				"/class-names-ext.properties");

			if (ext != null) {
				try {
					classNames.load(ext);
				}
				catch (IOException ioe) {
					log.log(
						Level.SEVERE,
						"Could not load class-names-ext.properties", ioe);
				}
			}
		}

		return classNames;
	}

	protected static Properties classNames;
	protected static final Logger log = Logger.getLogger(
		ClassNames.class.getName());

}