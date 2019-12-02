CREATE DATABASE IF NOT EXISTS `ads_desk` DEFAULT CHARACTER SET utf8;

CREATE USER 'adsdesk_user'@'localhost' IDENTIFIED BY 'adsdesk_password';

GRANT ALL PRIVILEGES ON ads_desk.* TO 'adsdesk_user'@'localhost';

FLUSH PRIVILEGES;