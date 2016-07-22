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
import com.liferay.mobile.sdk.json.Discovery;

import java.util.List;

/**
 * @author Bruno Farache
 */
public interface Builder {

	void build(
			Discovery discovery, List<Action> actions, String packageName,
			int version, String destination)
		throws Exception;

	void buildAll(
		Discovery discovery, String packageName, int version,
		String destination);

}