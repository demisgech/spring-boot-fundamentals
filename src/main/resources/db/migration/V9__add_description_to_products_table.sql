ALTER TABLE
    products
ADD
    COLUMN `description` TEXT NULL;

ALTER TABLE
    products
MODIFY
    COLUMN `description` TEXT NOT NULL;