CREATE TABLE address_users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    number INT NOT NULL,
    city VARCHAR(255) NOT NULL,
    zipcode VARCHAR(10) NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
