package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.demo.service.CTSValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CTSValidatorTest {

    private CTSValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CTSValidator();
    }

    @Test
    void validXmlShouldPass() {
        String xml = """
            <CTS versao=\"4.00\">
                <id>123</id>
                <issueDate>2024-01-01</issueDate>
                <sender>Company A</sender>
                <recipient>Company B</recipient>
            </CTS>
            """;
        assertDoesNotThrow(() -> validator.validate(xml));
    }

    @Test
    void invalidXmlShouldThrow() {
        String xml = """
            <CTS versao=\"4.00\">
                <id>123</id>
                <!-- missing issueDate -->
                <sender>Company A</sender>
                <recipient>Company B</recipient>
            </CTS>
            """;
        assertThrows(Exception.class, () -> validator.validate(xml));
    }
}
