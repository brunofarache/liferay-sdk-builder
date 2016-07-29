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

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Bruno Farache
 */
public class ActionComparator implements Comparator<Action> {

	@Override
	public int compare(Action action1, Action action2) {
		int compare = action1.getPath().compareTo(action2.getPath());

		if (compare != 0) {
			return compare;
		}

		ArrayList<Parameter> action1Parameters = action1.getParameters();
		ArrayList<Parameter> action2Parameters = action2.getParameters();
		compare = action1Parameters.size() - action2Parameters.size();

		if (compare != 0) {
			return compare;
		}

		for (int i = 0; i < action1Parameters.size(); i++) {
			String name1 = action1Parameters.get(i).getName();
			String name2 = action2Parameters.get(i).getName();
			compare = name1.compareTo(name2);

			if (compare != 0) {
				return compare;
			}
		}

		return compare;
	}

}