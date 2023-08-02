# java-reactor-starter

![Build](https://github.com/rbento/java-reactor-starter/actions/workflows/gradle.yml/badge.svg)

A starter project to practice [Reactive Programming](https://en.wikipedia.org/wiki/Reactive_programming) with [Project Reactor](https://projectreactor.io).

### Requirements
---

- [JDK 17](https://www.azul.com/downloads/?package=jdk#zulu) from Azul
- [Gradle](https://gradle.org/releases/) 8.2.1
- [Project Reactor](https://projectreactor.io)

### Build
---

```bash
./gradlew clean build
```

### Run
---

```bash
./gradlew run
```

### Testing with BlockHound
---

BlockHound is a Java agent that detects blocking calls from non-blocking threads.

- [https://github.com/reactor/BlockHound](https://github.com/reactor/BlockHound)

```
# At the entry point:

    public static void main(String[] args) {
        BlockHound.install();
        // ...
    }

# Set the VM options for BlockHound:

    -XX:+AllowRedefinitionToAddDeleteMethods

# Result when a blocking call is present:

    reactor.blockhound.BlockingOperationError: Blocking call! java.lang.Thread.sleep
	    at java.base/java.lang.Thread.sleep(Native Method)
	    at com.example.Example.lambda$exampleTest$0(Example.java:16)
```
