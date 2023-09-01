CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255),
    user_name VARCHAR(255) NOT NULL,
    password VARCHAR(255),
    name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL
);

