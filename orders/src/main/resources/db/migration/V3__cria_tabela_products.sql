CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL,
    description TEXT,
    category VARCHAR(255),
    image VARCHAR(255),
    rating_id BIGINT,
    FOREIGN KEY (rating_id) REFERENCES ratings(id)
);