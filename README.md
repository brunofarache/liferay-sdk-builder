![Liferay Mobile SDK logo](../logo.png)

# Liferay SDK Builder

* [Setup](#setup)
* [Run](#run)
* [Properties](#properties)

## Setup

If you are using Gradle 2.1 or higher, you can add the SDK Builder plugin to
your project build.gradle file:

```groovy
plugins {
  id "com.liferay.mobile.sdk.builder" version "1.0.2"
}
```

If you are using an older version of Gradle, or want to use it from a 
subproject:

```groovy
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.com.liferay.mobile:gradle-plugin:1.0.2"
  }
}

apply plugin: "com.liferay.mobile.sdk.builder"
```

Replace the version number `1.0.2` with the
[latest](https://github.com/liferay-mobile/liferay-sdk-builder/releases)
gradle-plugin version.

## Run

The Gradle plugin adds a task called `generate`:

```sh
gradle generate
```

This will use the [default properties](https://github.com/liferay-mobile/liferay-sdk-builder/blob/master/gradle-plugin/src/main/java/com/liferay/mobile/sdk/BuilderPlugin.java#L33-L38) for the
plugin.

You can customize these properties by adding a `builder` closure, for example:

```groovy
builder {
	url = "http://liferay.com"
	contexts = ['calendar-portlet']
	platforms = ['android']
	portalVersion = 62
}
```

## Properties

The properties bellow can be set while running the `generate` task.

* `contexts` - Your portlet's web context. Say for example you are
generating an SDK for Liferay's Calendar portlet, which is generally deployed
to the `calendar-portlet` context, then you should set your context value to
`['calendar-portlet']`. You can set multiple contexts in this array, if you are
generating for multiple portlets.

* `platforms` - By default, you can generate code for Android and iOS 
(`['android', 'ios']`).

* `url` - The URL to your Liferay instance, the SDK Builder will connect to this
instance and find out metadata about your services. Default value is
`http://localhost:8080`.

* `portalVersion` - The Liferay instance version you are using, it accepts
either `62` or `7`. Default value is `7`.

* `packageName` - On Android, this is the package to which your SDK's
classes are written.

* `destination` - This property refers to the destination folder where the
generate source files will be stored. Default values is `src/main/java`.