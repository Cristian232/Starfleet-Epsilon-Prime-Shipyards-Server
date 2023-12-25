CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          price DOUBLE PRECISION NOT NULL
);

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL
);

CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        user_id BIGINT REFERENCES users(id)
);

CREATE TABLE order_products (
                                order_id BIGINT REFERENCES orders(id),
                                product_id BIGINT REFERENCES products(id),
                                PRIMARY KEY (order_id, product_id)
);

CREATE TABLE supply_chain (
                              id SERIAL PRIMARY KEY,
                              resource_type VARCHAR(255) NOT NULL,
                              available_quantity INT NOT NULL
);

CREATE TABLE missions (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT
);

CREATE TABLE mission_logs (
                              id SERIAL PRIMARY KEY,
                              user_id BIGINT REFERENCES users(id),
                              mission_id BIGINT REFERENCES missions(id),
                              completion_time TIMESTAMP
);
