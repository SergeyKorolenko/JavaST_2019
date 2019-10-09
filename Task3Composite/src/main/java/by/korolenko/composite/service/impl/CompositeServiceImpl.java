package by.korolenko.composite.service.impl;

import by.korolenko.composite.bean.TextComposite;
import by.korolenko.composite.repository.Repository;
import by.korolenko.composite.repository.impl.CompositeRepository;
import by.korolenko.composite.service.CompositeService;
import by.korolenko.composite.service.input.FileDataReader;
import by.korolenko.composite.service.input.PropertyReader;
import by.korolenko.composite.service.input.enums.PropertyKey;
import by.korolenko.composite.service.parser.ParagraphParser;
import by.korolenko.composite.service.parser.Parser;

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
        System.out.println(text.length());
        System.out.println(text);
        Parser paragraphParser = new ParagraphParser();
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
        System.out.println();
        System.out.println(result.length());
        System.out.println(result);
        return result;
    }
}
