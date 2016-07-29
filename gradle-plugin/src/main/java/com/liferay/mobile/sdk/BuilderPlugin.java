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

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author Bruno Farache
 */
public class BuilderPlugin implements Plugin<Project> {

	@Override
	public void apply(final Project project) {
		project.getExtensions().add("builder", new Extension());
		project.getTasks().create("generate", BuilderTask.class);
	}

	class Extension {

		public String[] platforms = new String[]{ "android", "ios" };
		public String url = "http://localhost:8080";
		public String[] contexts = new String[]{ "" };
		public String filter = "";
		public String packageName = "com.liferay.mobile.sdk";
		public int portalVersion = 7;
		public String destination = "src/main/java";

	}

}