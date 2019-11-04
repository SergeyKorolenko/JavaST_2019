package by.korolenko.xml.service.impl;

import by.korolenko.xml.bean.GemType;
import by.korolenko.xml.service.ParseService;
import by.korolenko.xml.service.builders.GemSAXBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class SAXService implements ParseService {
    /**
     * Parsing method.
     *
     * @param fileName file name
     * @return list of gems
     */
    @Override
    public List<GemType> parse(final String fileName) {
        GemSAXBuilder builder = new GemSAXBuilder();
        builder.buildSetGems(fileName);
        return new ArrayList<>(builder.getGems());
    }
}
