package by.korolenko.xml.service.builders;

import by.korolenko.xml.bean.GemEnum;
import by.korolenko.xml.bean.VisualParameters;
import by.korolenko.xml.bean.GemType;
import by.korolenko.xml.bean.Precious;
import by.korolenko.xml.bean.Semiprecious;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class GemStAXBuilder extends AbstractGemsBuilder {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(GemStAXBuilder.class.getName());
    /**
     * XML input factory.
     */
    private XMLInputFactory factory;

    /**
     * Constructor.
     */
    public GemStAXBuilder() {
        factory = XMLInputFactory.newInstance();
    }

    /**
     * This method builds set of gems.
     *
     * @param fileName file name
     */
    public void buildListGems(final String fileName) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream =
                     new FileInputStream(new File(fileName))) {
            reader = factory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (GemEnum.valueOf(name.toUpperCase())
                            == GemEnum.PRECIOUS) {
                        GemType gem = buildGem(reader, GemEnum.PRECIOUS);
                        gems.add(gem);
                    }
                    if (GemEnum.valueOf(name.toUpperCase())
                            == GemEnum.SEMIPRECIOUS) {
                        GemType gem = buildGem(reader, GemEnum.SEMIPRECIOUS);
                        gems.add(gem);
                    }
                }
            }
        } catch (XMLStreamException | IOException e) {
            LOGGER.error("File error", e);
        }
    }

    private GemType buildGem(final XMLStreamReader reader,
                             final GemEnum gemEnum)
            throws XMLStreamException {
        GemType gem = null;
        if (gemEnum == GemEnum.PRECIOUS) {
            gem = new Precious();
            gem.setNumber(reader.getAttributeValue(null,
                    GemEnum.NUMBER.getValue()));
            String name;
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (GemEnum.valueOf(name.toUpperCase())) {
                            case NAME:
                                gem.setName(getXMLText(reader));
                                break;
                            case ORIGIN:
                                gem.setOrigin(getXMLText(reader));
                                break;
                            case PRODUCTION_DATE:
                                gem.setProductionDate(LocalDateTime.
                                        parse(getXMLText(reader)));
                                break;
                            case CARATS:
                                ((Precious) gem).setCarats(Double.
                                        parseDouble(getXMLText(reader)));
                                break;
                            case VISUAL_PARAMETERS:
                                gem.setVisualParameters(
                                        getXMLVisualParameters(reader));
                                break;
                            default:
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (GemEnum.valueOf(name.toUpperCase())
                                == GemEnum.PRECIOUS) {
                            return gem;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        if (gemEnum == GemEnum.SEMIPRECIOUS) {
            gem = new Semiprecious();
            gem.setNumber(reader.getAttributeValue(null,
                    GemEnum.NUMBER.getValue()));
            String name;
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (GemEnum.valueOf(name.toUpperCase())) {
                            case NAME:
                                gem.setName(getXMLText(reader));
                                break;
                            case ORIGIN:
                                gem.setOrigin(getXMLText(reader));
                                break;
                            case PRODUCTION_DATE:
                                gem.setProductionDate(LocalDateTime.
                                        parse(getXMLText(reader)));
                                break;
                            case CARATS:
                                ((Semiprecious) gem).setWeight(Double.
                                        parseDouble(getXMLText(reader)));
                                break;
                            case VISUAL_PARAMETERS:
                                gem.setVisualParameters(
                                        getXMLVisualParameters(reader));
                                break;
                            default:
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (GemEnum.valueOf(name.toUpperCase())
                                == GemEnum.SEMIPRECIOUS) {
                            return gem;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        throw new XMLStreamException("Unknown element in tag "
                + "Precious or Semiprecious");
    }

    private VisualParameters getXMLVisualParameters(
            final XMLStreamReader reader) throws XMLStreamException {
        VisualParameters parameters = new VisualParameters();
        String color = reader.getAttributeValue(null,
                GemEnum.COLOR.getValue());
        if (color == null) {
            parameters.setColor("Transparent");
        } else {
            parameters.setColor(color);
        }
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (GemEnum.valueOf(name.toUpperCase())) {
                        case TRANSPARENCY:
                            parameters.setTransparency(Integer.
                                    parseInt(getXMLText(reader)));
                            break;
                        case CUT_METHOD:
                            parameters.setCutMethod(getXMLText(reader));
                            break;
                        case FACES:
                            parameters.setFaces(Integer.
                                    parseInt(getXMLText(reader)));
                            break;
                        default:
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (GemEnum.valueOf(name.toUpperCase())
                            == GemEnum.VISUAL_PARAMETERS) {
                        return parameters;
                    }
                    break;
                default:
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag VisualParameters");
    }

    private String getXMLText(final XMLStreamReader reader)
            throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
