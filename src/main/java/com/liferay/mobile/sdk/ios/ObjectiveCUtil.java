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

package com.liferay.mobile.sdk.ios;

import com.liferay.mobile.sdk.util.LanguageUtil;

/**
 * @author Bruno Farache
 */
public class ObjectiveCUtil extends LanguageUtil {

	public static final String BOOL = "BOOL";

	public static final String LONG_LONG = "long long";

	public static final String LR_JSON_OBJECT_WRAPPER = "LRJSONObjectWrapper *";

	public static final String LR_UPLOAD_DATA = "LRUploadData *";

	public static final String NS_ARRAY = "NSArray *";

	public static final String NS_DATA = "NSData *";

	public static final String NS_DICTIONARY = "NSDictionary *";

	public static final String NS_NUMBER = "NSNumber *";

	public static final String NS_STRING = "NSString *";

	public String getParamValue(String name, String type) {
		type = getType(type);

		switch (type) {
			case BOOL:
			case DOUBLE:
			case INT:
			case LONG_LONG:
				return "@(" + name + ")";

			case NS_DATA:
				return "[self toString:" + name + "]";

			default:
				return "[self checkNull: " + name + "]";
		}
	}

	public String getReturnType(String type) {
		type = getType(type);

		switch (type) {
			case DOUBLE:
			case INT:
			case LONG_LONG:
				return NS_NUMBER;

			case LR_JSON_OBJECT_WRAPPER:
			case LR_UPLOAD_DATA:
				return NS_DICTIONARY;

			case NS_DATA:
				return NS_ARRAY;

			default:
				return type;
		}
	}

	public String getType(String type) {
		type = super.getType(type);

		if (isArray(type)) {
			if (type.equals(BYTE_ARRAY)) {
				return NS_DATA;
			}
			else {
				return NS_ARRAY;
			}
		}

		switch (type) {
			case DOUBLE:
			case INT:
			case VOID:
				return type;

			case BOOLEAN:
				return BOOL;

			case LONG:
				return LONG_LONG;

			case STRING:
				return NS_STRING;

			case FILE:
				return LR_UPLOAD_DATA;

			default:
				if (type.startsWith(OBJECT_PREFIX)) {
					return LR_JSON_OBJECT_WRAPPER;
				}
				else {
					return NS_DICTIONARY;
				}
		}
	}

}