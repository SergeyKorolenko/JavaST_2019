package by.korolenko.xml.service.builders;

import by.korolenko.xml.bean.GemType;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class GemSAXBuilder {
    /**
     * Gem type set.
     */
    private Set<GemType> gemTypeSet;

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
     * Getter for gem site set.
     *
     * @return gem type set
     */
    public Set<GemType> getGems() {
        return gemTypeSet;
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
        gemTypeSet = gemHandler.getGems();
    }
}
