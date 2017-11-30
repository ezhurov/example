
CREATE TABLE IF NOT EXISTS users(
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(255) NOT NULL UNIQUE,
	email VARCHAR(255) NOT NULL UNIQUE,
	password VARCHAR(255) NOT NULL,
	role VARCHAR(255) DEFAULT 'ROLE_USER',
	enabled BOOLEAN DEFAULT true
);

INSERT IGNORE INTO users (username, email, password, role) VALUES ('admin', 'admin@example.com', '$2a$10$5Wu4k6IFJqqURLpZGaFPluwAIsYMZ.vGE.KXbALAHhKoSbFmPny2K', 'ROLE_ADMIN');
INSERT IGNORE INTO users (username, email, password, role) VALUES ('guest', 'guest@example.com', '$2a$10$tNJ0CIoE63tv2cJjqTh.OuBQWboxZ5.nwy8N3ucX8SJc2vIOxkwMq', 'ROLE_USER');