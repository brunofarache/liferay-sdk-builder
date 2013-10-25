/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import com.liferay.mobile.sdk.BaseBuilder;
import com.liferay.mobile.sdk.http.Discovery;
import com.liferay.mobile.sdk.http.PortalVersion;
import com.liferay.mobile.sdk.velocity.VelocityUtil;

import org.apache.velocity.VelocityContext;

/**
 * @author Bruno Farache
 */
public class iOSBuilder extends BaseBuilder {

	public void build(String filter, PortalVersion version, Discovery discovery)
		throws Exception {

		VelocityContext context = getVelocityContext(
			filter, version, discovery);

		String headerTemplate = "com/liferay/mobile/sdk/ios/header.vm";
		String headerPath = getServiceFilePath(context);

		VelocityUtil.generate(context, headerTemplate, headerPath);
	}

	protected String getServiceFilePath(VelocityContext context) {
		String className = (String)context.get(CLASS_NAME);

		StringBuilder sb = new StringBuilder();

		sb.append("gen/Services/");
		sb.append(className);
		sb.append(".h");

		return sb.toString();
	}

	protected VelocityContext getVelocityContext(
		String filter, PortalVersion version, Discovery discovery) {

		VelocityContext context = new VelocityContext();

		ObjectiveCUtil objectiveCUtil = new ObjectiveCUtil();

		context.put(CLASS_NAME, objectiveCUtil.getServiceClassName(filter));

		return context;
	}

}