SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `user_role`;
DROP TABLE IF EXISTS `role_permission`;
DROP TABLE IF EXISTS `permissions`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `users`
(
    `id`         bigint(11)   NOT NULL AUTO_INCREMENT,
    `username`   varchar(255) NOT NULL,
    `password`   varchar(255) NOT NULL,
    `is_expired` int(1)       NOT NULL DEFAULT 0,
    `is_locked`  int(1)       NOT NULL DEFAULT 0,
    `is_enable`  int          NOT NULL DEFAULT 1,
    PRIMARY KEY (`id`)
);
CREATE TABLE `roles`
(
    `id`   bigint(11)   NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `user_role`
(
    `user_id` bigint(11) NOT NULL,
    `role_id` bigint(11) NOT NULL
);
CREATE TABLE `role_permission`
(
    `role_id`       bigint(11) NOT NULL,
    `permission_id` bigint(11) NOT NULL
);
CREATE TABLE `permissions`
(
    `id`          bigint(11)   NOT NULL AUTO_INCREMENT,
    `url`         varchar(255) NOT NULL,
    `name`        varchar(255) NOT NULL,
    `description` varchar(255) NULL,
    `pid`         bigint(11)   NOT NULL,
    PRIMARY KEY (`id`)
);
