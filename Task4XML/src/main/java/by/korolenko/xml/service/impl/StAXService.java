package by.korolenko.xml.service.impl;

import by.korolenko.xml.bean.GemType;
import by.korolenko.xml.service.ParseService;
import by.korolenko.xml.service.builders.GemStAXBuilder;

import java.util.ArrayList;
import java.util.List;

public class StAXService implements ParseService {
    /**
     * Parsing method.
     *
     * @param fileName file name
     * @return list of gems
     */
    @Override
    public List<GemType> parse(final String fileName) {
        GemStAXBuilder builder = new GemStAXBuilder();
        builder.buildSetGems(fileName);
        return new ArrayList<>(builder.getGems());
    }
}
