SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `depositories`;
DROP TABLE IF EXISTS `transfer_sheets`;
DROP TABLE IF EXISTS `transfers`;
DROP TABLE IF EXISTS `samples`;
DROP TABLE IF EXISTS `departments`;
DROP TABLE IF EXISTS `partners`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `depositories`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `name`        varchar(20)         NOT NULL DEFAULT '',
    `is_expired`  int(1)              NOT NULL DEFAULT 0,
    `is_locked`   int(1)              NOT NULL DEFAULT 0,
    `is_enable`   int(1)              NOT NULL DEFAULT 1,
    `description` varchar(255)        NOT NULL DEFAULT '',
    `created_at`  timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  timestamp           NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

# TransferSheet

CREATE TABLE `transfer_sheets`
(
    `id`             BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
    `name`           VARCHAR(255)        NOT NULL,
    `type`           int(2)              NOT NULL,
    `transferred_at` timestamp           NOT NULL,
    `created_at`     timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`     timestamp           NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE InnoDB
  DEFAULT CHARSET = utf8mb4;

# Transfer
CREATE TABLE `transfers`
(
    `id`                BIGINT(20) unsigned NOT NULL AUTO_INCREMENT,
    `type`              int(2)              NOT NULL,
    `transferred_at`    timestamp           NOT NULL,
    `transfer_sheet_id` BIGINT(20) unsigned NOT NULL,
    `created_at`        timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`        timestamp           NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `transfers_transfer_sheet_id_foreign` (`transfer_sheet_id`),
    CONSTRAINT `transfers_transfer_sheet_id_foreign` FOREIGN KEY (`transfer_sheet_id`) REFERENCES `transfer_sheets` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


CREATE TABLE `samples`
(
    `id`      BIGINT(20)  NOT NULL,
    `barcode` VARCHAR(20) NOT NULL COMMENT '条形码',
    PRIMARY KEY (`id`)
);

# 流水线表
CREATE TABLE `departments`
(
    `id`         bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `name`       varchar(20)         NOT NULL DEFAULT '',
    `time_limit` int unsigned        NOT NULL DEFAULT 168 COMMENT '检测预警时间',
    `created_at` timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp           NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

# 合作伙伴表
CREATE TABLE `partners`
(
    `id`         bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `name`       varchar(20)         NOT NULL DEFAULT '',
    `email`      varchar(50)         NULL COMMENT '邮箱地址',
    `callback`   varchar(255)        NULL COMMENT '回调地址',
    `secret`     varchar(255)        NOT NULL COMMENT '密钥',
    `created_at` timestamp           NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp           NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


