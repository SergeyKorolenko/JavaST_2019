package by.korolenko.adsdesk.dao;

import by.korolenko.adsdesk.bean.enums.EntityType;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public interface Transaction {

    <T extends AbstractDao> T createDao(EntityType entityType);
}
