package by.korolenko.composite.bean;

public class Paragraph extends Composite {

    /**
     * This method collects string.
     *
     * @return string
     */
    public String collect() {
        return "    " + super.collect();
    }
}
