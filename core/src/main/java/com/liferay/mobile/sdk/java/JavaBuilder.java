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

package com.liferay.mobile.sdk.java;

import com.liferay.mobile.sdk.BaseBuilder;
import com.liferay.mobile.sdk.Call;
import com.liferay.mobile.sdk.annotation.Param;
import com.liferay.mobile.sdk.annotation.Path;
import com.liferay.mobile.sdk.file.UploadData;
import com.liferay.mobile.sdk.http.ContentType;
import com.liferay.mobile.sdk.json.Action;
import com.liferay.mobile.sdk.json.Discovery;
import com.liferay.mobile.sdk.json.Parameter;
import com.liferay.mobile.sdk.util.Validator;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.File;

import java.util.List;

import javax.lang.model.element.Modifier;

import org.json.JSONObject;

/**
 * @author Bruno Farache
 */
public class JavaBuilder extends BaseBuilder {

	@Override
	public void build(
			Discovery discovery, List<Action> actions, String packageName,
			int version, String destination)
		throws Exception {

		TypeSpec.Builder classBuilder = classBuilder(discovery, actions.get(0));

		for (Action action : actions) {
			MethodSpec.Builder methodBuilder = methodBuilder(action);
			classBuilder.addMethod(methodBuilder.build());
		}

		StringBuilder sb = new StringBuilder(packageName);

		sb.append(".v");
		sb.append(version);
		sb.append(".");
		sb.append(actions.get(0).getFilter());

		packageName = sb.toString();

		JavaFile file = JavaFile
			.builder(packageName, classBuilder.build())
			.build();

		if (Validator.isNull(destination)) {
			destination = "src/gen/java";
		}

		File directory = new File(destination);

		directory.mkdirs();

		file.writeTo(directory);
	}

	protected TypeSpec.Builder classBuilder(
		Discovery discovery, Action action) {

		String contextPath = javaUtil.contextPath(
			discovery.getContext(), action.getFilter());

		AnnotationSpec servicePathAnnotation = AnnotationSpec
			.builder(Path.class)
			.addMember("value", "$S", contextPath)
			.build();

		return TypeSpec
			.interfaceBuilder(action.getServiceClassName())
			.addModifiers(Modifier.PUBLIC)
			.addAnnotation(servicePathAnnotation);
	}

	protected boolean hasUploadData(List<Parameter> params) {
		for (Parameter param : params) {
			Class type = new JavaUtil().type(param.getType());

			if (type == UploadData.class) {
				return true;
			}
		}

		return false;
	}

	protected MethodSpec.Builder methodBuilder(Action action) {
		AnnotationSpec.Builder methodPathAnnotationBuilder =
			methodPathAnnotationBuilder(action);

		TypeName returnType = ParameterizedTypeName.get(
			Call.class, javaUtil.returnType(action.getResponse()));

		String methodName = action.getMethodName();

		MethodSpec.Builder methodBuilder = MethodSpec
			.methodBuilder(methodName)
			.addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
			.addAnnotation(methodPathAnnotationBuilder.build())
			.returns(returnType);

		for (Parameter parameter : action.getParameters()) {
			ParameterSpec.Builder parameterBuilder = parameterBuilder(
				parameter);

			methodBuilder.addParameter(parameterBuilder.build());
		}

		return methodBuilder;
	}

	protected AnnotationSpec.Builder methodPathAnnotationBuilder(
		Action action) {

		String methodPath = action.getMethodPath();

		AnnotationSpec.Builder methodPathAnnotationBuilder = AnnotationSpec
			.builder(Path.class)
			.addMember("value", "$S", methodPath);

		if (hasUploadData(action.getParameters())) {
			methodPathAnnotationBuilder.addMember(
				"contentType", "$T.MULTIPART", ContentType.class);
		}

		return methodPathAnnotationBuilder;
	}

	protected ParameterSpec.Builder parameterBuilder(Parameter parameter) {
		String name = parameter.getName();

		AnnotationSpec.Builder parameterAnnotationBuilder = AnnotationSpec
			.builder(Param.class)
			.addMember("name", "$S", name);

		String parameterType = parameter.getType();

		Class clazz = javaUtil.type(parameterType);
		String className = javaUtil.className(parameterType);

		if ((clazz == JSONObject.class) && (className != null)) {
			parameterAnnotationBuilder = parameterAnnotationBuilder.addMember(
				"className", "$S", className);
		}

		return ParameterSpec
			.builder(clazz, name)
			.addAnnotation(parameterAnnotationBuilder.build());
	}

	protected JavaUtil javaUtil = new JavaUtil();

}