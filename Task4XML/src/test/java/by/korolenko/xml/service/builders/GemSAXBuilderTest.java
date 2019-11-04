package by.korolenko.xml.service.builders;

import by.korolenko.xml.bean.GemType;
import org.testng.annotations.Test;

import java.util.List;

public class GemSAXBuilderTest {

    private GemSAXBuilder builder = new GemSAXBuilder();

    @Test
    public void parse() {
        builder.buildListGems("data/gems.xml");
        List<GemType> set = builder.getGems();
        set.forEach(System.out::println);
    }
}
