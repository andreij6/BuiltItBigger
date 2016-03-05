# Gradle for Android

This is a Udacity Nanodegree project which includes an app with multiple flavors that uses
multiple libraries and Google Could Endpoints. It consists
of four modules. A Java library that provides jokes, a Google Could Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## Why this Project

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

* Added free and paid flavors to an app, and set up your build to share code between them
* Factored reusable functionality into a Java library
* Factored reusable Android functionality into an Android library
* Configured a multi project build to compile your libraries and app
* Used the Gradle App Engine plugin to deploy a backend
* Configured an integration test suite that runs against the local App Engine development server
