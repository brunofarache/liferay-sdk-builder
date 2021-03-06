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

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import java.util.ArrayList;

/**
 * @author Bruno Farache
 */
public class ActionDeserializer implements JsonDeserializer<Action> {

	@Override
	public Action deserialize(
			JsonElement json, Type typeOfT, JsonDeserializationContext context)
		throws JsonParseException {

		JsonObject root = json.getAsJsonObject();

		String path = root.get("path").getAsString();
		String response = root.getAsJsonObject("returns").get("type")
			.getAsString();

		String serviceClassName = null;
		String methodName = null;

		String name = root.get("name").getAsString();

		String[] values = name.split("#");

		if (values.length == 2) {
			serviceClassName = values[0];
			methodName = values[1];
		}

		JsonArray jsonArray = root.getAsJsonArray("parameters")
			.getAsJsonArray();

		try {
			ArrayList<Parameter> parameters = JSONParser.fromJSON(
				jsonArray, new GenericListType<>(Parameter.class));

			return new Action(
				serviceClassName, methodName, path, response, parameters);
		}
		catch (Exception e) {
			throw new JsonParseException(e);
		}
	}

}