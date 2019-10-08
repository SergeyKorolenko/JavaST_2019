package by.korolenko.composite.service.impl;

import by.korolenko.composite.bean.Composite;
import by.korolenko.composite.repository.Repository;
import by.korolenko.composite.repository.impl.CompositeRepository;
import by.korolenko.composite.service.CompositeService;
import by.korolenko.composite.service.input.FileDataReader;
import by.korolenko.composite.service.input.PropertyReader;
import by.korolenko.composite.service.input.enums.PropertyKey;
import by.korolenko.composite.service.parser.ParagraphParser;
import by.korolenko.composite.service.parser.Parser;

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
        Composite composite = new Composite();
        Parser paragraphParser = new ParagraphParser();
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
        System.out.println(result);
        return result;
    }
}
