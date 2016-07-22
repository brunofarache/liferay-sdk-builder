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

import org.apache.commons.lang.WordUtils;

/**
 * @author Bruno Farache
 */
public class LanguageUtil {

	public static final String BOOLEAN = "boolean";

	public static final String BYTE_ARRAY = "byte[]";

	public static final String DOUBLE = "double";

	public static final String FILE = "object<java.io.File>";

	public static final String INT = "int";

	public static final String LONG = "long";

	public static final String OBJECT_PREFIX = "object<";

	public static final String STRING = "string";

	public static final String VOID = "void";

	public LanguageUtil() {
		_classNames = new Properties();

		InputStream is = getClass().getResourceAsStream(
			"/class-names.properties");

		try {
			_classNames.load(is);
		}
		catch (IOException ioe) {
			_log.log(
				Level.SEVERE, "Could not load class-names.properties", ioe);
		}

		InputStream ext = getClass().getResourceAsStream(
			"/class-names-ext.properties");

		if (ext != null) {
			try {
				_classNames.load(ext);
			}
			catch (IOException ioe) {
				_log.log(
					Level.SEVERE, "Could not load class-names-ext.properties",
					ioe);
			}
		}
	}

	public String contextPath(String context, String filter) {
		if (Validator.isNotNull(context)) {
			context = context + "." + filter;
		}
		else {
			context = filter;
		}

		if (!context.startsWith("/")) {
			context = "/" + context;
		}

		return context;
	}

	public String getJSONWrapperClassName(String type) {
		if (type.startsWith(OBJECT_PREFIX)) {
			return type.substring(7, type.length() - 1);
		}

		return type;
	}

	public String getServiceClassName(String filter) {
		StringBuilder sb = new StringBuilder();

		String className = _classNames.getProperty(filter);

		if (className == null) {
			className = WordUtils.capitalize(filter);
		}

		sb.append(className);
		sb.append("Service");

		return sb.toString();
	}

	public String getType(String type) {
		switch (type) {
			case "object<java.lang.Boolean>":
				return BOOLEAN;

			case "object<java.lang.Double>":
				return DOUBLE;

			case "object<java.lang.Integer>":
				return INT;

			case "object<java.lang.Long>":
				return LONG;

			default:
				return type;
		}
	}

	public boolean isArray(String type) {
		return type.endsWith("[]") || type.equals("object<list>") ||
			type.equals("object<com.liferay.portal.kernel.json.JSONArray>") ||
			type.startsWith("list");
	}

	private static final Logger _log = Logger.getLogger(
		LanguageUtil.class.getName());

	private Properties _classNames;

}