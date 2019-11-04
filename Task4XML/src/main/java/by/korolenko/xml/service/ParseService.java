package by.korolenko.xml.service;

import by.korolenko.xml.bean.GemType;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public interface ParseService {
    /**
     * Parsing method.
     *
     * @param fileName file name
     * @return list of gems
     */
    List<GemType> parse(String fileName);
}
