
CREATE TABLE IF NOT EXISTS games(
	id INT AUTO_INCREMENT PRIMARY KEY,
	white_id INT,
	black_id INT,
	FOREIGN KEY (white_id) REFERENCES users (id),
	FOREIGN KEY (black_id) REFERENCES users (id)
);