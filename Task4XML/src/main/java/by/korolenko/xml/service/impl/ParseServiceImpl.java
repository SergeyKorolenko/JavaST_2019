package by.korolenko.xml.service.impl;

import by.korolenko.xml.bean.GemType;
import by.korolenko.xml.service.ParseService;
import by.korolenko.xml.service.builders.AbstractGemsBuilder;
import by.korolenko.xml.service.factory.GemsBuilderFactory;
import by.korolenko.xml.service.validator.XMLValidator;

import java.util.List;

public class ParseServiceImpl implements ParseService {
    /**
     * Parsing method.
     *
     * @param fileName   file name
     * @param parserType parser type
     * @return list of gems
     */
    @Override
    public List<GemType> parse(final String fileName, final String parserType) {
        //XMLValidator validator = new XMLValidator();
        //valid = validator.isValidXML(fileName);
        GemsBuilderFactory factory = new GemsBuilderFactory();
        AbstractGemsBuilder builder = factory.createGemsBuilder(parserType);
        builder.buildListGems(fileName);
        return builder.getGems();
    }
}
