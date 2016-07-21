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

import com.google.gson.Gson;

import com.liferay.mobile.sdk.json.Discovery;
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
		String context = arguments.get("context");
		String packageName = arguments.get("packageName");
		String filter = arguments.get("filter");
		int portalVersion = Integer.valueOf(arguments.get("portalVersion"));
		String destination = arguments.get("destination");

		try {
			builder.build(
				platforms, url, context, packageName, filter, portalVersion,
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
			String[] platforms, String url, String context, String packageName,
			String filter, int portalVersion, String destination)
		throws Exception {

		Discovery discovery = discover(url, context, filter, portalVersion);

		for (String platform : platforms) {
			String className = _properties.getProperty(platform);
			Builder builder = (Builder)Class.forName(className).newInstance();

			if (Validator.isNull(filter)) {
				builder.buildAll(
					discovery, packageName, portalVersion, destination);
			}
			else {
				builder.build(
					discovery, discovery.getActions(), packageName,
					portalVersion, filter, destination);
			}
		}
	}

	public Discovery discover(
			String url, String context, String filter, int portalVersion)
		throws Exception {

		if (Validator.isNull(filter)) {
			filter = "*";
		}
		else {
			filter = filter + "/*";
		}

		if (portalVersion == 62) {
			if (Validator.isNotNull(context)) {
				context = "/" + context;
			}

			url = String.format(
				"%s%s/api/jsonws?discover=/%s", url, context, filter);
		}
		else if (portalVersion == 7) {
			url = String.format(
				"%s/api/jsonws?discover=/%s&contextName=%s", url, filter,
				context);
		}

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();

		if (!response.isSuccessful()) {
			throw new IOException("Unexpected HTTP response: " + response);
		}

		return new Gson().fromJson(
			response.body().charStream(), Discovery.class);
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