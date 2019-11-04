package by.korolenko.xml.service.factory;

import by.korolenko.xml.bean.ParserType;
import by.korolenko.xml.service.builders.AbstractGemsBuilder;
import by.korolenko.xml.service.builders.GemDOMBuilder;
import by.korolenko.xml.service.builders.GemSAXBuilder;
import by.korolenko.xml.service.builders.GemStAXBuilder;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class GemsBuilderFactory {

    /**
     * This method creates builder.
     *
     * @param parserType parser type
     * @return builder
     */
    public AbstractGemsBuilder createGemsBuilder(final String parserType) {
        ParserType type = ParserType.valueOf(parserType.toUpperCase());
        switch (type) {
            case DOM:
                return new GemDOMBuilder();
            case SAX:
                return new GemSAXBuilder();
            case STAX:
                return new GemStAXBuilder();
            default:
                throw new EnumConstantNotPresentException(
                        type.getDeclaringClass(), type.name());
        }
    }
}
