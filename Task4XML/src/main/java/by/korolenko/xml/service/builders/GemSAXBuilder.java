package by.korolenko.xml.service.builders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(GemSAXBuilder.class.getName());
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
            LOGGER.error("SAXException", e);
        }
    }

    /**
     * Builder.
     *
     * @param fileName file name
     */
    public void buildListGems(final String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            LOGGER.error("Error of SAX parser", e);
        } catch (IOException e) {
            LOGGER.error("Error of I/O stream", e);
        }
        gems = gemHandler.getGems();
    }
}
