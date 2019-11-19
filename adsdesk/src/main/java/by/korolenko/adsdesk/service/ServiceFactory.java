package by.korolenko.adsdesk.service;

import by.korolenko.adsdesk.bean.enums.EntityType;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public interface ServiceFactory {

    <T extends AbstractService> T createService(EntityType entityType);

    void close();
}
