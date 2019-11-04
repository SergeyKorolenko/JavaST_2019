package by.korolenko.xml.service.validator;

import org.testng.annotations.Test;

public class XMLValidatorTest {

    @Test
    public void checkXML() {
        XMLValidator validator = new XMLValidator();
        boolean result = validator.isValidXML("testdata/gems.xml");
        System.out.println(result);
    }
}
