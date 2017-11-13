
CREATE TABLE IF NOT EXISTS statistic(
	id INT AUTO_INCREMENT PRIMARY KEY,
	user_id INT NOT NULL,
	wins INT,
	fails INT,
	draws INT,
	FOREIGN KEY (user_id) REFERENCES users (id)
);