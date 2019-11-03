package by.korolenko.xml.service.builders;

import by.korolenko.xml.bean.GemType;
import org.testng.annotations.Test;

import java.util.Set;

public class GemStAXBuilderTest {

    private GemStAXBuilder builder = new GemStAXBuilder();

    @Test
    public void parse() {
        builder.buildSetGems("data/gems.xml");
        Set<GemType> set = builder.getGems();
        set.forEach(System.out::println);
    }
}
