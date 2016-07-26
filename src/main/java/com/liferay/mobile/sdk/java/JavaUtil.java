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

package com.liferay.mobile.sdk.java;

import com.liferay.mobile.sdk.file.UploadData;
import com.liferay.mobile.sdk.http.Response;
import com.liferay.mobile.sdk.util.LanguageUtil;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Bruno Farache
 */
public class JavaUtil extends LanguageUtil {

	public String className(String type) {
		if (type.startsWith(OBJECT_PREFIX)) {
			return type.substring(7, type.length() - 1);
		}
		else if (type.startsWith("map")) {
			return null;
		}
		else {
			return type;
		}
	}

	public Class returnType(String type) {
		type = super.getType(type);

		if (isArray(type)) {
			return JSONArray.class;
		}

		switch (type) {
			case BOOLEAN:
				return Boolean.class;

			case DOUBLE:
				return Double.class;

			case INT:
				return Integer.class;

			case LONG:
				return Long.class;

			case VOID:
				return Response.class;

			case STRING:
				return String.class;

			default:
				return JSONObject.class;
		}
	}

	public Class type(String type) {
		type = super.getType(type);

		if (isArray(type)) {
			if (type.equals(BYTE_ARRAY)) {
				return byte[].class;
			}
			else {
				return JSONArray.class;
			}
		}

		switch (type) {
			case BOOLEAN:
				return boolean.class;

			case DOUBLE:
				return double.class;

			case INT:
				return int.class;

			case LONG:
				return long.class;

			case VOID:
				return Response.class;

			case STRING:
				return String.class;

			case FILE:
			case FILE_JAVA_IO:
				return UploadData.class;

			default:
				return JSONObject.class;
		}
	}

}