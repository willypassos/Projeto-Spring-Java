CREATE TABLE order_items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    price DECIMAL(10, 2),
    amount INT NOT NULL,
    partialAmount DECIMAL(10, 2),
    order_id UUID NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);