package by.korolenko.adsdesk.service;

import by.korolenko.adsdesk.bean.Locality;
import by.korolenko.adsdesk.service.exception.ServiceException;

import java.util.List;

/**
 * @author Sergei Korolenko
 * @version 1.0
 */
public interface LocalityService {

    List<Locality> readAll() throws ServiceException;
}
