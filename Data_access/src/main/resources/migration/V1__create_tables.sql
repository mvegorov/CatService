
CREATE TABLE owners (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL
);

CREATE TABLE cats (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birth_date DATE,
    breed VARCHAR(100),
    color VARCHAR(100),
    owner_id INTEGER,
    FOREIGN KEY (owner_id) REFERENCES owners(id)
);

CREATE TABLE cat_friends (
    cat_id1 INTEGER,
    cat_id2 INTEGER,
    FOREIGN KEY (cat_id1) REFERENCES cats(id),
    FOREIGN KEY (cat_id2) REFERENCES cats(id),
    PRIMARY KEY (cat_id1, cat_id2)
);
