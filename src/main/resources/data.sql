-- GROUPS TABLE
DROP TABLE IF EXISTS groups;
CREATE TABLE groups (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(10) NOT NULL
);
INSERT INTO groups (name) VALUES
    ('UserA'),
    ('UserB'),
    ('UserC');


-- MODULES TABLE
DROP TABLE IF EXISTS modules;
CREATE TABLE modules (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);
INSERT INTO modules (name) VALUES
    ('PromoCard'),
    ('CategoryCard'),
    ('FlashSaleCard'),
    ('HistoryCard'),
    ('NewsCard');


--  GROUPS_MODULES TABLE
DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    group_id INT NOT NULL,
    module_id INT NOT NULL,
    orders INT NOT NULL,
    FOREIGN KEY (group_id) REFERENCES groups(id),
    FOREIGN KEY (module_id) REFERENCES modules(id)
);
INSERT INTO orders (group_id, module_id, orders) VALUES
    (1, 1, 1),
    (1, 2, 2),
    (1, 3, 3),
    (1, 4, 4),
    (1, 5, 5),
    (2, 1, 1),
    (2, 5, 2),
    (2, 3, 3),
    (2, 2, 4),
    (2, 4, 5),
    (3, 1, 1),
    (3, 3, 2),
    (3, 2, 3),
    (3, 5, 4),
    (3, 4, 5);
