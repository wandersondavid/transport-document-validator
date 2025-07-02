# transport-document-validator

This project demonstrates a minimal Spring Boot application using Java 21.

## CTS validator

A simple validator for CTS version 4.00 is provided. The validator checks an XML document against the `cts_400.xsd` schema located in `src/main/resources/xsd`.

Run tests with Maven:

```bash
./mvnw test
```

