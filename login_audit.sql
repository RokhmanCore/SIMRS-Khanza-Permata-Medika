-- Run once on the SIMRS database before deploying the login changes.
CREATE TABLE IF NOT EXISTS `login_audit` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(100) NOT NULL,
  `attempted_at` DATETIME NOT NULL,
  `outcome` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_login_audit_user_time` (`user_id`, `attempted_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
