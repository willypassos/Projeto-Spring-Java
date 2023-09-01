CREATE TABLE orders (
    id VARCHAR(36) PRIMARY KEY,
    user_id INT,
    status VARCHAR(255) NOT NULL,
    totalPrice DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
