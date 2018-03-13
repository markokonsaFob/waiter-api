1. [What is Waiter API?](#markdown-header-what-is-waiter-api)
1. [How the project structure looks like?](#markdown-header-how-the-project-structure-looks-like)
1. [What are the preconditions for the project?](#markdown-header-what-are-the-preconditions-for-the-project)
1. [Step-By-Step guide for beginners](#markdown-header-step-by-step-guide-for-beginners)
1. [How to run waiter API Project?](#markdown-header-how-to-run-waiter-api-project)

## What is Waiter API?

Waiter API is a API project used in FOB Solutions to teach API testing and API development.
This project uses Spring Boot and mongoDB.

## Preconditions for the project

- Java 8
- IntelliJ IDEA (or similar IDE)
- Gradle

## How the project structure looks like?

### Project structure
    
    /
    |-- build
    |-- gradle
    |   |-- wrapper
    |-- src
    |   |-- main
    |           |-- ee
    |               |-- fobsolutions
    |                   |-- waiter
    |                       |-- controller
    |                       |-- dao
    |                       |-- models
    |                       |-- service
    |                       |-- Application.java
    |       |-- resources
    |       |       |-- static
    |       |       |-- templates
    |-- build.gradle
    |-- README.md
    
**gradle/wrapper/** - Gradle wrapper

**build** - Framework logs

**src/test/main/ee/fobsolutions/waiter/controller** - API Endpoints

**src/test/main/ee/fobsolutions/waiter/dao** - Database structure

**src/test/main/ee/fobsolutions/waiter/models** - Data models

**src/test/main/ee/fobsolutions/waiter/service** - Service package

**src/test/main/ee/fobsolutions/waiter/Application.java** - Starting point of the Application

**src/test/resources/static** - static components of HTML pages

**src/test/resources/templates** - HTML templates

## Step-By-Step guide for beginners

### Run clean build to make sure that everything is okay

Just to make sure that everything is in order run gradle clean build task

On Mac OS X

    ./gradlew clean build
   
On Windows

    gradlew clean build

Start API with command

On Mac OS X

    ./gradlew waiter
   
On Windows

    gradlew waiter