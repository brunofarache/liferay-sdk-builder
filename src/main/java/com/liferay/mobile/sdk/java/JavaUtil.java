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

	public static final String INTEGER = "Integer";

	public static final String JSON_ARRAY = "JSONArray";

	public static final String JSON_OBJECT = "JSONObject";

	public static final String JSON_OBJECT_WRAPPER = "JSONObjectWrapper";

	public static final String UPLOAD_DATA = "UploadData";

	public String className(String type) {
		if (!type.startsWith(OBJECT_PREFIX)) {
			return "";
		}

		return type.substring(7, type.length() - 1);
	}

	public String getType(String type) {
		type = super.getType(type);

		if (type.equals(BOOLEAN) || type.equals(BYTE_ARRAY) ||
			type.equals(DOUBLE) || type.equals(INT) || type.equals(LONG) ||
			type.equals(VOID)) {

			return type;
		}

		if (isArray(type)) {
			return JSON_ARRAY;
		}

		if (type.equals(STRING)) {
			return "String";
		}

		if (type.equals(FILE)) {
			return UPLOAD_DATA;
		}

		if (type.startsWith(OBJECT_PREFIX)) {
			return JSON_OBJECT_WRAPPER;
		}

		return JSON_OBJECT;
	}

	public Class returnType(String type) {
		type = super.getType(type);

		if (type.equals(BOOLEAN)) {
			return Boolean.class;
		}

		if (type.equals(DOUBLE)) {
			return Double.class;
		}

		if (type.equals(INT)) {
			return Integer.class;
		}

		if (type.equals(LONG)) {
			return Long.class;
		}

		if (type.equals(VOID)) {
			return Response.class;
		}

		if (isArray(type)) {
			return JSONArray.class;
		}

		if (type.equals(STRING)) {
			return String.class;
		}

		return JSONObject.class;
	}

	public Class type(String type) {
		type = super.getType(type);

		if (type.equals(BOOLEAN)) {
			return boolean.class;
		}

		if (type.equals(BYTE_ARRAY)) {
			return byte[].class;
		}

		if (type.equals(DOUBLE)) {
			return double.class;
		}

		if (type.equals(INT)) {
			return int.class;
		}

		if (type.equals(LONG)) {
			return long.class;
		}

		if (type.equals(VOID)) {
			return Response.class;
		}

		if (isArray(type)) {
			return JSONArray.class;
		}

		if (type.equals(STRING)) {
			return String.class;
		}

		if (type.equals(FILE)) {
			return UploadData.class;
		}

		if (type.startsWith(OBJECT_PREFIX)) {
			return JSONObject.class;
		}

		return JSONObject.class;
	}

}