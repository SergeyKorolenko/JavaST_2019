USE `ads_desk`;

CREATE TABLE IF NOT EXISTS `ads_desk`.`country`
(
    `id`   INTEGER     NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(60) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk`.`region`
(
    `id`         INTEGER     NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(60) NOT NULL,
    `country_id` INTEGER     NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_region_country`
        FOREIGN KEY (`country_id`)
            REFERENCES `ads_desk`.`country` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk`.`locality`
(
    `id`        INTEGER     NOT NULL AUTO_INCREMENT,
    `name`      VARCHAR(60) NOT NULL,
    `region_id` INTEGER     NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_locality_region`
        FOREIGN KEY (`region_id`)
            REFERENCES `ads_desk`.`region` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk`.`category`
(
    `id`        INTEGER     NOT NULL AUTO_INCREMENT,
    `name`      VARCHAR(60) NOT NULL,
    `parent_id` INTEGER     NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_category_parent`
        FOREIGN KEY (`parent_id`)
            REFERENCES `ads_desk`.`category` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk`.`user`
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
            REFERENCES `ads_desk`.`locality` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk`.`ads`
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
            REFERENCES `ads_desk`.`locality` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE,
    CONSTRAINT `fk_ads_category`
        FOREIGN KEY (`category_id`)
            REFERENCES `ads_desk`.`category` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE,
    CONSTRAINT `fk_ads_user`
        FOREIGN KEY (`user_id`)
            REFERENCES `ads_desk`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk`.`comment`
(
    `id`             INTEGER       NOT NULL AUTO_INCREMENT,
    `comment`        VARCHAR(2000) NOT NULL,
    `added_datetime` TIMESTAMP     NOT NULL,
    `ads_id`         INTEGER       NOT NULL,
    `user_id`        INTEGER       NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_comment_ads`
        FOREIGN KEY (`ads_id`)
            REFERENCES `ads_desk`.`ads` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE,
    CONSTRAINT `fk_comment_user`
        FOREIGN KEY (`user_id`)
            REFERENCES `ads_desk`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `ads_desk`.`image`
(
    `id`        INTEGER       NOT NULL AUTO_INCREMENT,
    `image_url` VARCHAR(2000) NOT NULL,
    `ads_id`    INTEGER       NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_image_ads`
        FOREIGN KEY (`ads_id`)
            REFERENCES `ads_desk`.`ads` (`id`)
            ON DELETE NO ACTION
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET utf8;

INSERT INTO `country`
    (`id`, `name`)
VALUES (1, 'Беларусь');

INSERT INTO `region`
    (`id`, `name`, `country_id`)
VALUES (1, 'Брестская область', 1),
       (2, 'Витебская область', 1),
       (3, 'Гомельская область', 1),
       (4, 'Гродненская область', 1),
       (5, 'Минская область', 1),
       (6, 'Могилевская область', 1);

INSERT INTO `locality`
    (`id`, `name`, `region_id`)
VALUES (1, 'Минск', 5),
       (2, 'Могилев', 6),
       (3, 'Брест', 1),
       (4, 'Витебск', 2),
       (5, 'Гродно', 4),
       (6, 'Гомель', 3);

INSERT INTO `category`
    (`id`, `name`)
VALUES (1, 'Недвижимость'),
       (2, 'Авто и транспорт'),
       (3, 'Техника'),
       (4, 'Мода и стиль'),
       (5, 'Ремонт и стройка'),
       (6, 'Сад и огород'),
       (7, 'Услуги'),
       (8, 'Работа');

INSERT INTO `category`
    (`id`, `name`, `parent_id`)
VALUES (9, '1-ная квартира', 1),
       (10, '2-ная квартира', 1);

INSERT INTO `user`
(`id`, `login`, `password`, `role`, `name`, `phone`, `register_date`, `status`,
 `email`)
VALUES (1, 'admin', 'admin', 0, 'Sergei', 375291111111, '2019-11-24 13:01:42',
        0, 'admin@gmail.com'),
       (2, 'user', 'user', 1, 'Sergei', 375291513645, '2019-11-24 13:03:43', 0,
        'user@gmail.com');


INSERT INTO `ads`
(`id`, `heading`, `text`, `price`, `state`, `bargain`, `register_date`,
 `locality_id`, `category_id`, `user_id`)
VALUES (1, 'heading 1', 'text 1', 1, 0, 0, '2019-11-24 13:03:43', 1, 1, 2),
       (2, 'heading 2', 'text 2', 2, 0, 1, '2019-11-24 13:03:43', 2, 2, 2),
       (3, 'heading 3', 'text 3', 3, 0, 0, '2019-11-24 13:03:43', 3, 3, 2),
       (4, 'heading 4', 'text 4', 4, 0, 1, '2019-11-24 13:03:43', 4, 4, 2),
       (5, 'heading 5', 'text 5', 5, 0, 0, '2019-11-24 13:03:43', 5, 5, 2),
       (6, 'heading 6', 'text 6', 6, 0, 1, '2019-11-24 13:03:43', 6, 6, 2),
       (7, 'heading 7', 'text 7', 7, 0, 0, '2019-11-24 13:03:43', 1, 7, 2),
       (8, 'heading 8', 'text 8', 8, 0, 1, '2019-11-24 13:03:43', 2, 8, 2),
       (9, 'heading 9', 'text 9', 9, 0, 0, '2019-11-24 13:03:43', 3, 1, 2),
       (10, 'heading 10', 'text 10', 10, 0, 1, '2019-11-24 13:03:43', 4, 2, 2),
       (11, 'heading 11', 'text 11', 11, 0, 0, '2019-11-24 13:03:43', 5, 3, 2),
       (12, 'heading 12', 'text 12', 12, 0, 1, '2019-11-24 13:03:43', 6, 4, 2),
       (13, 'heading 13', 'text 13', 13, 0, 0, '2019-11-24 13:03:43', 1, 5, 2),
       (14, 'heading 14', 'text 14', 14, 0, 1, '2019-11-24 13:03:43', 2, 6, 2),
       (15, 'heading 15', 'text 15', 15, 0, 0, '2019-11-24 13:03:43', 3, 7, 2),
       (16, 'heading 16', 'text 16', 16, 0, 1, '2019-11-24 13:03:43', 4, 8, 2),
       (17, 'heading 17', 'text 17', 17, 0, 0, '2019-11-24 13:03:43', 5, 1, 2),
       (18, 'heading 18', 'text 18', 18, 0, 1, '2019-11-24 13:03:43', 6, 2, 2),
       (19, 'heading 19', 'text 19', 19, 0, 0, '2019-11-24 13:03:43', 1, 3, 2),
       (20, 'heading 20', 'text 20', 20, 0, 1, '2019-11-24 13:03:43', 2, 4, 2);

INSERT INTO `comment`
(`id`, `comment`, `added_datetime`, `user_id`, `ads_id`)
VALUES (1, 'comment 1', '2019-12-05 13:03:43', 2, 1),
       (2, 'comment 2', '2019-12-05 13:03:43', 2, 1),
       (3, 'comment 3', '2019-12-05 13:03:43', 2, 1),
       (4, 'comment 4', '2019-12-05 13:03:43', 2, 1),
       (5, 'comment 5', '2019-12-05 13:03:43', 2, 1),
       (6, 'comment 6', '2019-12-05 13:03:43', 2, 1),
       (7, 'comment 7', '2019-12-05 13:03:43', 2, 1),
       (8, 'comment 8', '2019-12-05 13:03:43', 2, 1),
       (9, 'comment 9', '2019-12-05 13:03:43', 2, 1),
       (10, 'comment 10', '2019-12-05 13:03:43', 2, 1),
       (11, 'comment 11', '2019-12-05 13:03:43', 2, 2),
       (12, 'comment 12', '2019-12-05 13:03:43', 2, 2),
       (13, 'comment 13', '2019-12-05 13:03:43', 2, 2),
       (14, 'comment 14', '2019-12-05 13:03:43', 2, 2),
       (15, 'comment 15', '2019-12-05 13:03:43', 2, 2),
       (16, 'comment 16', '2019-12-05 13:03:43', 2, 2),
       (17, 'comment 17', '2019-12-05 13:03:43', 2, 2),
       (18, 'comment 18', '2019-12-05 13:03:43', 2, 2),
       (19, 'comment 19', '2019-12-05 13:03:43', 2, 2),
       (20, 'comment 20', '2019-12-05 13:03:43', 2, 2);