package by.korolenko.adsdesk.service;

import by.korolenko.adsdesk.bean.enums.EntityType;

public interface ServiceFactory {

    <T extends AbstractService> T createService(EntityType entityType);

    void close();
}
