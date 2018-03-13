# Dreadball Toolkit Webpage

Web application for Dreadball.

[![Release docs](https://img.shields.io/badge/docs-release-blue.svg)][site-release]
[![Development docs](https://img.shields.io/badge/docs-develop-blue.svg)][site-develop]

[![Release javadocs](https://img.shields.io/badge/javadocs-release-blue.svg)][javadoc-release]
[![Development javadocs](https://img.shields.io/badge/javadocs-develop-blue.svg)][javadoc-develop]

## Documentation

Documentation is always generated for the latest release, kept in the 'master' branch:

- The [latest release documentation page][site-release].
- The [the latest release Javadoc site][javadoc-release].

Documentation is also generated from the latest snapshot, taken from the 'develop' branch:

- The [the latest snapshot documentation page][site-develop].
- The [the latest snapshot Javadoc site][javadoc-develop].

The documentation site sources come along the source code (as it is a Maven site), so it is always possible to generate them using the following Maven command:

```
$ mvn verify site -P h2,jetty
```

The verify phase is required, as otherwise some of the reports won't be created.

## Usage

The application is coded in Java, using Maven to manage the project.

### Prerequisites

The project has been tested on the following Java versions:
* JDK 8

All other dependencies are handled through Maven, and noted in the included POM file.

### Installing

The project can be installed by creating the war file and deploying it into a server.

### Running

To run the project locally in an embedded server just use the following Maven command for Jetty:

```
$ mvn jetty:run-war -P h2,jetty
```

Or this one for Tomcat:

```
$ mvn tomcat7:run-war -P h2,tomcat7
```

After this the project will be accessible at [http://localhost:8080/dreadball/].

### Running tests

The integration tests require a database and a running server, and the easiest way to run them is in a similar way to running the project locally.

To run the tests with Jetty:

```
$ mvn verify -P h2,jetty
```

To run them with Tomcat:

```
$ mvn verify -P h2,tomcat7
```

Maven will run both the frontend and backend tests.

To run only the frontend tests:

```
$ npm run test
```

### Packaging the WAR

When creating the WAR file the database connection credentials should be set manually:

```
$ mvn package -P production,mysql -Ddatabase.username=[username] -Ddatabase.password=[password] -Ddatabase.url=[DB url]
```

Otherwise the project will try to use the default testing values.

## Collaborate

Any kind of help with the project will be well received, and there are two main ways to give such help:

- Reporting errors and asking for extensions through the issues management
- or forking the repository and extending the project

### Issues management

Issues are managed at the GitHub [project issues tracker][issues], where any Github user may report bugs or ask for new features.

### Getting the code

If you wish to fork or modify the code, visit the [GitHub project page][scm], where the latest versions are always kept. Check the 'master' branch for the latest release, and the 'develop' for the current, and stable, development version.

## License

The project has been released under the [MIT License][license].

[issues]: https://github.com/bernardo-mg/dreadball-toolkit-webpage/issues
[javadoc-develop]: http://docs.bernardomg.com/development/maven/dreadball-toolkit-webpage/apidocs
[javadoc-release]: http://docs.bernardomg.com/maven/dreadball-toolkit-webpage/apidocs
[license]: http://www.opensource.org/licenses/mit-license.php
[scm]: https://github.com/bernardo-mg/dreadball-toolkit-webpage
[site-develop]: http://docs.bernardomg.com/development/maven/dreadball-toolkit-webpage
[site-release]: http://docs.bernardomg.com/maven/dreadball-toolkit-webpage
