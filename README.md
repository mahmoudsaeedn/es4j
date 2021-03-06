[![Build Status](https://travis-ci.org/eventsourcing/es4j.svg?branch=master)](https://travis-ci.org/eventsourcing/es4j)
[ ![Download](https://api.bintray.com/packages/eventsourcing/maven/eventsourcing-core/images/download.svg) ](https://bintray.com/eventsourcing/maven/eventsourcing-core/_latestVersion)
[ ![Download](https://api.bintray.com/packages/eventsourcing/maven-snapshots/eventsourcing-core/images/download.svg) ](https://bintray.com/eventsourcing/maven-snapshots/eventsourcing-core/_latestVersion)
[![Join the chat at https://gitter.im/eventsourcing/eventsourcing](https://badges.gitter.im/eventsourcing/eventsourcing.svg)](https://gitter.im/eventsourcing/eventsourcing?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

# ![logo](https://eventsourcing.com/android-icon-48x48.png) Eventsourcing for Java

### *Keep the past, because predicting future is hard*

Instead of mutating data in a database, Eventsourcing stores all changes (*events*) and what caused them (*commands*). To make this data useful,
Eventsourcing builds indices over it.

This helps developing applications faster because there is no need to worry
about designing the *right* domain models upfront (or as close to *right* as possible). By keeping all the commands and events, we can enrich or change
our domain models over time with very little friction. Furthermore, this approach removes a need to have a *one and only* domain model for every entity. We experience the world and reality in different ways, depending on circumstances and points of view, and our programs should be able to reflect that.

To learn more about what kind of problems ES4J addresses, please read [Why Use Eventsourcing Database](https://blog.eventsourcing.com/why-use-eventsourcing-database-6b5e2ac61848)

## Key benefits

* Domain model flexibility
* Late domain model binding
* Persistence of causal information
* Serializable conflict resolution
* Audit trail logging
* Mapping application functionality

## Key features

* Strongly typed schemas
* Event migrations
* Domain protocols
* Batteries included (shared event languages)
* Basic support for [Kotlin](http://kotlinlang.org)
* Causality-preserving [Hybrid Logical Clocks](http://www.cse.buffalo.edu/tech-reports/2014-04.pdf)
* In-memory, server (**PostgreSQL**) and on-disk (**H2/MVStore**) storage
* Locking synchronization primitive
* JMX-based introspection and management

# Presentation

You can find our current slide deck at https://eventsourcing.com/presentation

# Documentation

Installation instructions and documentation can be found at [es4j-doc.eventsourcing.com](http://es4j-doc.eventsourcing.com)

We strive to specify the building blocks behind Eventsourcing and its ecosystem as succinct specifications, you can find the current list of them at [rfc.eventsourcing.com](http://rfc.eventsourcing.com)

# Roadmap

As this project is striving to be a decentralized, community-driven project governed by the [C4 process](http://rfc.unprotocols.org/spec:1/C4), there is no central roadmap per se. However, individual
contributors are free to publish their own roadmaps to help indicating their intentions. Current roadmaps available:

* [Yurii Rashkovskii](https://github.com/yrashk/es4j/milestones/Roadmap)

Also, there's a [centralized list of reported issues](https://github.com/eventsourcing/es4j/issues). These do not imply an actual roadmap, just what has been reported.

# Snapshot versions

Every successful build is published into a [separate Maven repository on Bintray](https://bintray.com/eventsourcing/maven-snapshots) (using a `git describe`
version), you can find the last snapshot version mentioned in a badge at the top of this file.

Gradle configuration:

```groovy
repositories {
    maven {
        url  "http://dl.bintray.com/eventsourcing/maven-snapshots"
    }
}
```

Maven configuration:

```xml
<repository>
	<id>bintray-eventsourcing-maven-snapshots</id>
	<name>bintray</name>
	<url>http://dl.bintray.com/eventsourcing/maven-snapshots</url>
</repository>
```

# Contributing

Contributions of all kinds (code, documentation, testing, artwork, etc.) are highly encouraged. Please open a GitHub issue if you want to suggest an idea or ask a question.

We use Unprotocols [C4 process](http://rfc.unprotocols.org/1/). In a nutshell, this means:

* We merge pull requests rapidly (try!)
* We are open to diverse ideas
* We prefer code now over consensus later

For more details, please refer to [CONTRIBUTING](CONTRIBUTING.md)

# Related projects

* [es4j-graphql](https://github.com/eventsourcing/es4j-graphql) A Relay.js/GraphQL adaptor for ES4J-based applications.
