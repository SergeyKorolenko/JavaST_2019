package by.korolenko.composite.service.impl;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.bean.enums.TextPart;
import by.korolenko.composite.repository.Repository;
import by.korolenko.composite.repository.impl.CompositeRepository;
import by.korolenko.composite.service.CompositeService;
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

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 08.10.2019
 */
public class CompositeServiceImpl implements CompositeService {

    /**
     * Repository.
     */
    private Repository repository = new CompositeRepository();

    /**
     * Add.
     */
    public void add() {
        FileDataReader fileDataReader = new FileDataReader();
        PropertyReader propertyReader = new PropertyReader();
        String text = fileDataReader.readData(propertyReader.
                readFilePath(PropertyKey.TEXT.getKeyName()));
        Composite composite = new Composite(TextPart.TEXT);
        System.out.println(text.length());
        System.out.println(text);
        Parser paragraphParser = new ParagraphParser();
        Parser sentenceParser = new SentenceParser();
        Parser lexemeParser = new LexemeParser();
        Parser wordParser = new WordParser();
        Parser symbolParser = new SymbolParser();

        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(wordParser);
        wordParser.setNextParser(symbolParser);

        composite = paragraphParser.parse(composite, text);
        repository.add(composite);
    }

    /**
     * Collect text.
     *
     * @return text
     */
    public String collect() {
        Composite composite = repository.take();
        String result = composite.collect();
        System.out.println(result.length());
        System.out.println(result);
        FileDataWriter fileDataWriter = new FileDataWriter();
        PropertyReader propertyReader = new PropertyReader();
        fileDataWriter.writeData(result, propertyReader.
                readFilePath(PropertyKey.OUTPUT.getKeyName()));
        return result;
    }

    /**
     * Sort text.
     *
     * @return sorted text
     */
    public String sortBySentence() {
        return null;
    }

    /**
     * Sort method.
     *
     * @return sorted text
     */
    public String sortByWordLength() {
        return null;
    }
}
