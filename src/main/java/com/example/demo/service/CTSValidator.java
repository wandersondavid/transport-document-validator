package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class CTSValidator {

    private final Validator validator;

    public CTSValidator() {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            InputStream xsdStream = getClass().getClassLoader().getResourceAsStream("xsd/cts_400.xsd");
            Schema schema = factory.newSchema(new StreamSource(xsdStream));
            this.validator = schema.newValidator();
        } catch (SAXException e) {
            throw new RuntimeException("Failed to load CTS schema", e);
        }
    }

    public void validate(String xml) throws Exception {
        try (InputStream xmlStream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))) {
            validator.validate(new StreamSource(xmlStream));
        }
    }
}
