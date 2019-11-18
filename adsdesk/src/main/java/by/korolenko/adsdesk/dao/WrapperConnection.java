package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.enums.EntityType;

public interface WrapperConnection {

    AbstractDao createDao(EntityType entityType);
}
