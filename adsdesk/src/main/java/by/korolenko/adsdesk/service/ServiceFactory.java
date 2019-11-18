package by.korolenko.adsdesk.service;

import by.korolenko.adsdesk.bean.enums.EntityType;

public interface ServiceFactory {

    AbstractService createService(EntityType entityType);

    void close();
}
