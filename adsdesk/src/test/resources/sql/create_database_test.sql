CREATE DATABASE IF NOT EXISTS `ads_desk_test` DEFAULT CHARACTER SET utf8;

CREATE USER 'adsdesk_user_test'@'localhost' IDENTIFIED BY 'adsdesk_password';

GRANT ALL PRIVILEGES ON ads_desk_test.* TO 'adsdesk_user_test'@'localhost';

FLUSH PRIVILEGES;