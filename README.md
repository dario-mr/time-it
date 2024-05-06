# Time It!

Lightweight yet comprehensive library to log the execution time of your methods in Spring Boot components.

Relies on [slf4j](https://www.slf4j.org/api/index.html) for logging.

## Requirements

- java 17
- an existing Spring Boot application
    - minimum Spring Boot version supported: `2.5.0`
    - implementing
      either [spring-boot-starter-aop](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-aop)
      or [aspectjweaver](https://mvnrepository.com/artifact/org.aspectj/aspectjweaver) dependency

## Installation

### Maven Central

Get the latest version from [Maven Central](https://central.sonatype.com/artifact/io.github.dario-mr/time-it/overview).

```
<dependency>
    <groupId>io.github.dario-mr</groupId>
    <artifactId>time-it</artifactId>
    <version>${latestVersion}</version>
</dependency>
```

### JAR

Get the latest JAR from [Github Packages](https://github.com/dario-mr?tab=packages&repo_name=time-it), or generate your
own with the maven command:

```
mvn package
```

## Usage

```java

@Service
public class MyService {

    @TimeIt
    public void myMethod() {
        // my code
    }
}
```

## Configuration

`@TimeIt` can be configured at annotation level via the properties:

- `unit` (default `MILLISECONDS`)
- `logLevel` (default `INFO`)

```java

@Service
public class MyService {

    @TimeIt(unit = TimeUnit.SECONDS, logLevel = Level.WARN)
    public void myMethod() {
        // my code
    }
}
```
