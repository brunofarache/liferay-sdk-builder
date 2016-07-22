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

package com.liferay.mobile.sdk.json;

import com.liferay.mobile.sdk.util.ClassNames;

import java.util.ArrayList;

import org.apache.commons.lang.WordUtils;

/**
 * @author Bruno Farache
 */
public class Action {

	public Action() {
	}

	public Action(
		String serviceClassName, String methodName, String path,
		String response, ArrayList<Parameter> parameters) {

		this.serviceClassName = serviceClassName;
		this.filter = serviceClassName.toLowerCase();
		this.methodName = methodName;
		this.path = path;
		this.response = response;
		this.parameters = parameters;
	}

	public String capitalize(String word) {
		return WordUtils.capitalize(word);
	}

	public String getFilter() {
		if (filter == null) {
			int index = path.indexOf("/", 1);
			filter = path.substring(1, index);
		}

		return filter;
	}

	public String getMethodName() {
		if (methodName == null) {
			methodName = getMethodNameFromPath();
		}

		return methodName;
	}

	public String getMethodPath() {
		int index = path.lastIndexOf("/") + 1;
		return path.substring(index);
	}

	public ArrayList<Parameter> getParameters() {
		return parameters;
	}

	public String getResponse() {
		return response;
	}

	public String getServiceClassName() {
		if (serviceClassName == null) {
			StringBuilder sb = new StringBuilder();
			String className = ClassNames.className(filter);

			if (className == null) {
				className = WordUtils.capitalize(filter);
			}

			sb.append(className);
			sb.append("Service");

			serviceClassName = sb.toString();
		}

		return serviceClassName;
	}

	protected String getMethodNameFromPath() {
		String last = getMethodPath();
		String[] methodName = last.split("-");
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < methodName.length; i++) {
			String word = methodName[i];

			if (i > 0) {
				word = capitalize(word);
			}

			sb.append(word);
		}

		return sb.toString();
	}

	protected String filter;
	protected String methodName;
	protected ArrayList<Parameter> parameters = new ArrayList<>();
	protected String path;
	protected String response;
	protected String serviceClassName;

}