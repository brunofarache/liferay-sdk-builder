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

package com.liferay.mobile.sdk;

import com.liferay.mobile.sdk.json.Action;
import com.liferay.mobile.sdk.json.ActionDeserializer;
import com.liferay.mobile.sdk.json.Discovery;
import com.liferay.mobile.sdk.json.DiscoveryDeserializer;
import com.liferay.mobile.sdk.json.JSONParser;
import com.liferay.mobile.sdk.util.Validator;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.InputStream;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bruno Farache
 */
public class SDKBuilder {

	public static void main(String[] args) throws IOException {
		SDKBuilder builder = new SDKBuilder();

		Map<String, String> arguments = builder.parseArguments(args);

		String[] platforms = arguments.get("platforms").split(",");
		String url = arguments.get("url");
		String[] contexts = arguments.get("contexts").split(",");
		String packageName = arguments.get("packageName");
		int portalVersion = Integer.valueOf(arguments.get("portalVersion"));
		String destination = arguments.get("destination");

		try {
			builder.build(
				platforms, url, contexts, packageName, portalVersion,
				destination);
		}
		catch (Exception e) {
			_log.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public SDKBuilder() throws IOException {
		_properties = new Properties();
		InputStream is = getClass().getResourceAsStream("/builder.properties");
		_properties.load(is);
	}

	public void build(
			String[] platforms, String url, String[] contexts,
			String packageName, int portalVersion, String destination)
		throws Exception {

		for (String context : contexts) {
			Discovery discovery = discover(url, context, portalVersion);

			for (String platform : platforms) {
				String className = _properties.getProperty(platform);
				Builder builder = (Builder)Class.forName(
					className).newInstance();

				builder.build(
					discovery, packageName, portalVersion, destination);
			}
		}
	}

	public Discovery discover(String url, String context, int portalVersion)
		throws Exception {

		if ("portal".equals(context)) {
			context = "";
		}

		if (portalVersion == 62) {
			if (Validator.isNotNull(context)) {
				context = "/" + context;
			}

			url = String.format("%s%s/api/jsonws?discover", url, context);
		}
		else if (portalVersion == 7) {
			url = String.format(
				"%s/api/jsonws?discover&contextName=%s", url, context);
		}

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();

		if (!response.isSuccessful()) {
			throw new IOException("Unexpected HTTP response: " + response);
		}

		if (portalVersion == 7) {
			JSONParser.registerTypeAdapter(
				Discovery.class, new DiscoveryDeserializer());

			JSONParser.registerTypeAdapter(
				Action.class, new ActionDeserializer());
		}

		return JSONParser.fromJSON(response.body().string(), Discovery.class);
	}

	protected Map<String, String> parseArguments(String[] args) {
		Map<String, String> arguments = new HashMap<>();

		for (String arg : args) {
			int pos = arg.indexOf('=');

			if (pos <= 0) {
				throw new IllegalArgumentException("Bad argument " + arg);
			}

			String key = arg.substring(0, pos).trim();
			String value = arg.substring(pos + 1).trim();

			arguments.put(key, value);
		}

		return arguments;
	}

	private static final Logger _log = Logger.getLogger(
		SDKBuilder.class.getName());

	private Properties _properties;

}