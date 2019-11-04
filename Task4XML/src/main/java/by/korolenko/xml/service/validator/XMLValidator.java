package by.korolenko.xml.service.validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class XMLValidator {

    /**
     * Path of the schema file.
     */
    private static final String SCHEMA = "data/gems.xsd";

    /**
     * Checking method.
     *
     * @param fileName file name
     * @return result
     */
    public boolean isValidXML(final String fileName) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(SCHEMA);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
            return true;
        } catch (SAXException e) {
            System.err.print("validation " + fileName + " is not valid because "
                    + e.getMessage());
        } catch (IOException e) {
            System.err.print(fileName + " is not valid because "
                    + e.getMessage());
        }
        return false;
    }
}
