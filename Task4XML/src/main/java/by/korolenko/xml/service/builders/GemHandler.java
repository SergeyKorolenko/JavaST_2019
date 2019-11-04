package by.korolenko.xml.service.builders;

import by.korolenko.xml.bean.GemEnum;
import by.korolenko.xml.bean.Semiprecious;
import by.korolenko.xml.bean.GemType;
import by.korolenko.xml.bean.Precious;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class GemHandler extends DefaultHandler {

    /**
     * List of gems.
     */
    private List<GemType> gems;

    /**
     * Current enum.
     */
    private GemEnum currentEnum;

    /**
     * Semiprecious.
     */
    private GemType currentGem;

    /**
     * Enum set.
     */
    private EnumSet<GemEnum> enumSet;

    /**
     * Constructor.
     */
    public GemHandler() {
        gems = new ArrayList<>();
        enumSet = EnumSet.range(GemEnum.NUMBER, GemEnum.WEIGHT);
    }

    /**
     * Getter for gems.
     *
     * @return gems
     */
    public List<GemType> getGems() {
        return gems;
    }

    /**
     * Start element.
     *
     * @param uri       uri
     * @param localName local name
     * @param qName     qName
     * @param attrs     attributes
     */
    @Override
    public void startElement(final String uri, final String localName,
                             final String qName, final Attributes attrs) {
        if ("precious".equals(localName)) {
            currentGem = new Precious();
            currentGem.setNumber(attrs.getValue(0));

        } else if ("semiprecious".equals(localName)) {
            currentGem = new Semiprecious();
            currentGem.setNumber(attrs.getValue(0));
        } else if ("visual_parameters".equals(localName)) {
            currentGem.getVisualParameters().setColor(attrs.getValue(0));
        } else {
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if (enumSet.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    /**
     * End element.
     *
     * @param uri       uri
     * @param localName local name
     * @param qName     qName
     */
    @Override
    public void endElement(final String uri, final String localName,
                           final String qName) {
        if ("precious".equals(localName)) {
            gems.add(currentGem);
        }
        if ("semiprecious".equals(localName)) {
            gems.add(currentGem);
        }
    }

    /**
     * Characters.
     *
     * @param ch     char array
     * @param start  start
     * @param length length
     */
    @Override
    public void characters(final char[] ch, final int start, final int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    currentGem.setName(s);
                    break;
                case ORIGIN:
                    currentGem.setOrigin(s);
                    break;
                case PRODUCTION_DATE:
                    currentGem.setProductionDate(LocalDateTime.parse(s));
                    break;
                case WEIGHT:
                    ((Semiprecious) currentGem).
                            setWeight(Double.parseDouble(s));
                    break;
                case CARATS:
                    ((Precious) currentGem).
                            setCarats(Double.parseDouble(s));
                    break;
                case TRANSPARENCY:
                    currentGem.getVisualParameters().setTransparency(
                            Integer.parseInt(s));
                    break;
                case CUT_METHOD:
                    currentGem.getVisualParameters().setCutMethod(s);
                    break;
                case FACES:
                    currentGem.getVisualParameters().setFaces(
                            Integer.parseInt(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(),
                            currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
