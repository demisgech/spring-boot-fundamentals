CREATE TABLE wishlist(
    user_id BIGINT,
    product_id BIGINT,
    PRIMARY KEY (user_id, product_id),
    CONSTRAINT users_wishlist_fk FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT products_wishlist_fk FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);