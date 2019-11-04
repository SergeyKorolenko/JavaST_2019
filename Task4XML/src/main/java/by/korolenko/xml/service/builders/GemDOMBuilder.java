package by.korolenko.xml.service.builders;

import by.korolenko.xml.bean.GemType;
import by.korolenko.xml.bean.Precious;
import by.korolenko.xml.bean.Semiprecious;
import by.korolenko.xml.bean.VisualParameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class GemDOMBuilder extends AbstractGemsBuilder {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(GemDOMBuilder.class.getName());
    /**
     * Builder.
     */
    private DocumentBuilder builder;

    /**
     * Constructor.
     */
    public GemDOMBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Configuration parser error.", e);
        }
    }

    /**
     * Building set of gems.
     *
     * @param fileName filename
     */
    public void buildSetGems(final String fileName) {
        try {
            Document doc = builder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList gemsList = root.getChildNodes();
            for (int i = 0; i < gemsList.getLength(); i++) {
                Node current = gemsList.item(i);
                if (current.getNodeType() == Node.ELEMENT_NODE) {
                    Element gemElement = (Element) current;
                    GemType gem = buildGem(gemElement);
                    gems.add(gem);
                }
            }
        } catch (IOException e) {
            LOGGER.error("File error or I/O error.", e);
        } catch (SAXException e) {
            LOGGER.error("Parsing failure.", e);
        }
    }

    private GemType buildGem(final Element element) {
        String number = element.getAttribute("number");
        String name = getElementTextContent(element, "name");
        String origin = getElementTextContent(element, "origin");
        VisualParameters visualParameters = new VisualParameters();
        Element parameters = (Element) element.
                getElementsByTagName("visual_parameters").item(0);
        if (!parameters.hasAttribute("color")) {
            visualParameters.setColor("Transparent");
        } else {
            visualParameters.setColor(parameters.getAttribute("color"));
        }
        visualParameters.setTransparency(Integer.parseInt(
                getElementTextContent(parameters, "transparency")));
        visualParameters.setCutMethod(
                getElementTextContent(parameters, "cut_method"));
        visualParameters.setFaces(Integer.parseInt(
                getElementTextContent(parameters, "faces")));
        LocalDateTime localDateTime = LocalDateTime.parse(
                getElementTextContent(element, "production_date"));
        if (element.getTagName().equals("precious")) {
            Precious gem = new Precious();
            gem.setNumber(number);
            gem.setName(name);
            gem.setOrigin(origin);
            gem.setVisualParameters(visualParameters);
            gem.setProductionDate(localDateTime);
            gem.setCarats(Double.parseDouble(
                    getElementTextContent(element, "carats")));
            return gem;
        } else {
            Semiprecious gem = new Semiprecious();
            gem.setNumber(number);
            gem.setName(name);
            gem.setOrigin(origin);
            gem.setVisualParameters(visualParameters);
            gem.setProductionDate(localDateTime);
            gem.setWeight(Double.parseDouble(
                    getElementTextContent(element, "weight")));
            return gem;
        }
    }

    private static String getElementTextContent(final Element element,
                                                final String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
