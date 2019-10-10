package by.korolenko.composite.service.impl;

import by.korolenko.composite.bean.TextComposite;
import by.korolenko.composite.repository.Repository;
import by.korolenko.composite.repository.impl.CompositeRepository;
import by.korolenko.composite.service.CompositeService;
import by.korolenko.composite.service.input.FileDataReader;
import by.korolenko.composite.service.input.PropertyReader;
import by.korolenko.composite.service.input.enums.PropertyKey;
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
        TextComposite textComposite = new TextComposite();
        System.out.println(text);
        Parser paragraphParser = new ParagraphParser();
        SentenceParser sentenceParser = new SentenceParser();
        LexemeParser lexemeParser = new LexemeParser();
        WordParser wordParser = new WordParser();
        SymbolParser symbolParser = new SymbolParser();

        paragraphParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(lexemeParser);
        lexemeParser.setNextParser(wordParser);
        wordParser.setNextParser(symbolParser);

        textComposite = paragraphParser.parse(textComposite, text);
        repository.add(textComposite);
    }

    /**
     * Collect text.
     *
     * @return text
     */
    public String collect() {
        TextComposite textComposite = repository.take();
        String result = textComposite.collect();
        System.out.println(result);
        return result;
    }
}
