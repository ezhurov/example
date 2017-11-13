
CREATE TABLE IF NOT EXISTS users(
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(255) NOT NULL UNIQUE,
	email VARCHAR(255) NOT NULL UNIQUE,
	password VARCHAR(255) NOT NULL,
	role VARCHAR(255) DEFAULT 'ROLE_USER',
	enabled BOOLEAN DEFAULT true
);

INSERT IGNORE INTO users(username, email, password, role) VALUES ('admin', 'admin@example.com', 'admin', 'ROLE_ADMIN');
INSERT IGNORE INTO users(username, email, password, role) VALUES ('user', 'user@example.com', 'user', 'ROLE_USER');