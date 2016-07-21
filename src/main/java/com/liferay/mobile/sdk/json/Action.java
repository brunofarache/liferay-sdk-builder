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

import java.util.ArrayList;

/**
 * @author Bruno Farache
 */
public class Action {

	public Action() {
	}

	public Action(
		String path, String response, ArrayList<Parameter> parameters) {

		this.path = path;
		this.response = response;
		this.parameters = parameters;
	}

	public ArrayList<Parameter> getParameters() {
		return parameters;
	}

	public String getPath() {
		return path;
	}

	public String getResponse() {
		return response;
	}

	protected ArrayList<Parameter> parameters = new ArrayList<>();
	protected String path;
	protected String response;

}