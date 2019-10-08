package by.korolenko.composite.bean;

public class Lexeme extends Composite {

    /**
     * This method collects string.
     *
     * @return string
     */
    public String collect() {
        return " " + super.collect();
    }
}
