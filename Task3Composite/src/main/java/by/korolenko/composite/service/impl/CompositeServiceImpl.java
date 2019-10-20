package by.korolenko.composite.service.impl;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.repository.Repository;
import by.korolenko.composite.repository.impl.CompositeRepository;
import by.korolenko.composite.service.CompositeService;
import by.korolenko.composite.service.exception.ProblemFileException;
import by.korolenko.composite.service.input.FileDataReader;
import by.korolenko.composite.service.input.PropertyReader;
import by.korolenko.composite.service.input.enums.PropertyKey;
import by.korolenko.composite.service.output.FileDataWriter;
import by.korolenko.composite.service.parser.LexemeParser;
import by.korolenko.composite.service.parser.ParagraphParser;
import by.korolenko.composite.service.parser.Parser;
import by.korolenko.composite.service.parser.SentenceParser;
import by.korolenko.composite.service.parser.SymbolParser;
import by.korolenko.composite.service.parser.WordParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class CompositeServiceImpl implements CompositeService {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(CompositeServiceImpl.class.getName());
    /**
     * Repository.
     */
    private Repository repository = new CompositeRepository();

    /**
     * This method parses text.
     *
     * @return parsed text
     */
    public String parse() {
        FileDataReader fileDataReader = new FileDataReader();
        PropertyReader propertyReader = new PropertyReader();
        String text;
        try {
            text = fileDataReader.readData(propertyReader.
                    readFilePath(PropertyKey.TEXT.getKeyName()));
        } catch (ProblemFileException e) {
            LOGGER.error("Property file error", e);
            return "No such file";
        }
        Parser paragraphParser = new ParagraphParser();
        Parser sentenceParser = new SentenceParser();
        Parser lexemeParser = new LexemeParser();
        Parser wordParser = new WordParser();
        Parser symbolParser = new SymbolParser();

        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(wordParser);
        wordParser.setNextParser(symbolParser);

        Composite composite = paragraphParser.parse(text);
        repository.addComposite(composite);
        return text;
    }

    /**
     * This method collects text.
     *
     * @return text
     */
    public String collect() {
        Composite composite = repository.getComposite();
        String result = composite.collect();
        FileDataWriter fileDataWriter = new FileDataWriter();
        PropertyReader propertyReader = new PropertyReader();
        try {
            fileDataWriter.writeData(result, propertyReader.
                    readFilePath(PropertyKey.OUTPUT.getKeyName()));
        } catch (ProblemFileException e) {
            LOGGER.error("Writing to file error");
            return "Writing to file error " + result;
        }
        return result;
    }
}
