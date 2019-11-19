package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.enums.EntityType;

public interface WrapperConnection {

    <T extends AbstractDao> T createDao(EntityType entityType);
}
