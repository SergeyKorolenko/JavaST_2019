package by.korolenko.xml.service.builders;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class GemSAXBuilder extends AbstractGemsBuilder {

    /**
     * Gem handler.
     */
    private GemHandler gemHandler;
    /**
     * Reader.
     */
    private XMLReader reader;

    /**
     * Constructor.
     */
    public GemSAXBuilder() {
        gemHandler = new GemHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(gemHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    /**
     * Builder.
     *
     * @param fileName file name
     */
    public void buildSetGems(final String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        gems = gemHandler.getGems();
    }
}
