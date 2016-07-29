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

import com.liferay.mobile.sdk.BuilderPlugin.Extension;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.tasks.TaskAction;

/**
 * @author Bruno Farache
 */
public class BuilderTask extends DefaultTask {

	@TaskAction
	public void generate() throws Exception {
		Project project = getProject();

		ExtensionContainer extensions = project.getExtensions();

		Extension ext = extensions.findByType(Extension.class);

		SDKBuilder builder = new SDKBuilder();

		builder.build(
			ext.platforms, ext.url, ext.contexts, ext.packageName, ext.filter,
			ext.portalVersion, ext.destination);
	}

}