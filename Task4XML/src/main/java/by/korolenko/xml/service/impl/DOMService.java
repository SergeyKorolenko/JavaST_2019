package by.korolenko.xml.service.impl;

import by.korolenko.xml.bean.GemType;
import by.korolenko.xml.service.ParseService;
import by.korolenko.xml.service.builders.GemDOMBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class DOMService implements ParseService {
    /**
     * Parsing method.
     *
     * @param fileName file name
     * @return list of gems
     */
    @Override
    public List<GemType> parse(final String fileName) {
        GemDOMBuilder builder = new GemDOMBuilder();
        builder.buildSetGems(fileName);
        return new ArrayList<>(builder.getGems());
    }
}
