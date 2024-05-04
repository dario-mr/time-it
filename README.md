# Time It!

Lightweight yet comprehensive library to log execution time in your Spring Boot components.

Relies on [slf4j](https://www.slf4j.org/api/index.html) for logging.

## Requirements

- java 17
- an existing Spring Boot application
    - minimum Spring Boot version supported: `2.5.0`
    - implementing
      either [spring-boot-starter-aop](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-aop)
      or [aspectjweaver](https://mvnrepository.com/artifact/org.aspectj/aspectjweaver) dependency

## Installation

### Maven

// TODO

### JAR

You can generate the JAR yourself by running the following maven command from the root directory:

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
