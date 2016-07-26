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

package com.liferay.mobile.sdk.velocity;

import java.io.FileWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;

/**
 * @author Bruno Farache
 */
public class VelocityUtil {

	public static void generate(
			VelocityContext context, String templatePath, String filePath)
		throws Exception {

		String resourceLoader = FormatterResourceLoader.class.getName();

		Velocity.setProperty(
			RuntimeConstants.VM_LIBRARY, "templates/macros.vm");

		Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		Velocity.setProperty("classpath.resource.loader.class", resourceLoader);

		Velocity.init();

		Template template = Velocity.getTemplate(templatePath);

		Writer writer = new FileWriter(filePath);

		template.merge(context, writer);

		writer.flush();
		writer.close();
	}

}