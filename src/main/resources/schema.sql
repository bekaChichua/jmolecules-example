DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS test_order;


CREATE TABLE IF NOT EXISTS customer
(
    id   uuid primary key NOT NULL,
    name VARCHAR(100)       NOT NULL
);

CREATE TABLE IF NOT EXISTS test_order
(
    id       uuid primary key NOT NULL,
    customer uuid             NOT NULL REFERENCES customer (id) ON DELETE CASCADE
);