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
public class DiscoveryDeserializer implements JsonDeserializer<Discovery> {

	@Override
	public Discovery deserialize(
			JsonElement json, Type typeOfT, JsonDeserializationContext context)
		throws JsonParseException {

		JsonObject root = json.getAsJsonObject();

		String contextName = root.get("contextName").getAsString();
		JsonArray jsonArray = root.getAsJsonArray("services");

		try {
			ArrayList<Action> services = JSONParser.fromJSON(
				jsonArray, new GenericListType<>(Action.class));

			return new Discovery(contextName, services);
		}
		catch (Exception e) {
			throw new JsonParseException(e);
		}
	}

}