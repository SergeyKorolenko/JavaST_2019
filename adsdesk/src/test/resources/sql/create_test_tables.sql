USE `ads_desk_test`;

CREATE TABLE IF NOT EXISTS `ads_desk_test`.`country`
(
    `id`   INTEGER     NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(60) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk_test`.`region`
(
    `id`         INTEGER     NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(60) NOT NULL,
    `country_id` INTEGER     NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_region_country`
        FOREIGN KEY (`country_id`)
            REFERENCES `ads_desk_test`.`country` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk_test`.`locality`
(
    `id`        INTEGER     NOT NULL AUTO_INCREMENT,
    `name`      VARCHAR(60) NOT NULL,
    `region_id` INTEGER     NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_locality_region`
        FOREIGN KEY (`region_id`)
            REFERENCES `ads_desk_test`.`region` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk_test`.`category`
(
    `id`        INTEGER     NOT NULL AUTO_INCREMENT,
    `name`      VARCHAR(60) NOT NULL,
    `parent_id` INTEGER     NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_category_parent`
        FOREIGN KEY (`parent_id`)
            REFERENCES `ads_desk_test`.`category` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk_test`.`user`
(
    `id`            INTEGER       NOT NULL AUTO_INCREMENT,
    `login`         VARCHAR(255)  NOT NULL UNIQUE,
    `password`      VARCHAR(255)  NOT NULL,
    `role`          TINYINT       NOT NULL CHECK ( `role` IN (0, 1)),
    `name`          VARCHAR(60)   NOT NULL,
    `surname`       VARCHAR(60)   NULL,
    `patronymic`    VARCHAR(60)   NULL,
    `phone`         BIGINT        NOT NULL,
    `register_date` TIMESTAMP     NOT NULL,
    `status`        TINYINT       NOT NULL CHECK ( `status` IN (0, 1)),
    `email`         VARCHAR(255)  NOT NULL,
    `avatar_url`    VARCHAR(2000) NULL,
    `locality_id`   INTEGER       NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_user_locality`
        FOREIGN KEY (`locality_id`)
            REFERENCES `ads_desk_test`.`locality` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk_test`.`ads`
(
    `id`            INTEGER        NOT NULL AUTO_INCREMENT,
    `heading`       VARCHAR(100)   NOT NULL,
    `text`          VARCHAR(4000)  NOT NULL,
    `price`         DECIMAL(10, 2) NOT NULL,
    `state`         TINYINT        NOT NULL CHECK ( `state` IN (0, 1)),
    `bargain`       TINYINT        NOT NULL CHECK ( `bargain` IN (0, 1) ),
    `register_date` TIMESTAMP      NOT NULL,
    `locality_id`   INTEGER        NOT NULL,
    `category_id`   INTEGER        NOT NULL,
    `user_id`       INTEGER        NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_ads_locality`
        FOREIGN KEY (`locality_id`)
            REFERENCES `ads_desk_test`.`locality` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE,
    CONSTRAINT `fk_ads_category`
        FOREIGN KEY (`category_id`)
            REFERENCES `ads_desk_test`.`category` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE,
    CONSTRAINT `fk_ads_user`
        FOREIGN KEY (`user_id`)
            REFERENCES `ads_desk_test`.`user` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk_test`.`comment`
(
    `id`             INTEGER       NOT NULL AUTO_INCREMENT,
    `comment`        VARCHAR(2000) NOT NULL,
    `added_datetime` TIMESTAMP     NOT NULL,
    `ads_id`         INTEGER       NOT NULL,
    `user_id`        INTEGER       NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_comment_ads`
        FOREIGN KEY (`ads_id`)
            REFERENCES `ads_desk_test`.`ads` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT `fk_comment_user`
        FOREIGN KEY (`user_id`)
            REFERENCES `ads_desk_test`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk_test`.`image`
(
    `id`        INTEGER       NOT NULL AUTO_INCREMENT,
    `image_url` VARCHAR(2000) NOT NULL,
    `ads_id`    INTEGER       NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_image_ads`
        FOREIGN KEY (`ads_id`)
            REFERENCES `ads_desk_test`.`ads` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;