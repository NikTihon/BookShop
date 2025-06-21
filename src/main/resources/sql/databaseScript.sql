CREATE TABLE IF NOT EXISTS book
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    name  NVARCHAR(50) NOT NULL,
    image NVARCHAR(2048),
    price INT          NOT NULL CHECK (price > 0)
);


CREATE TABLE description_book
(
    book_id               INT PRIMARY KEY,
    description      NVARCHAR(4000),
    publishing_house NVARCHAR(30) NOT NULL,
    age_limit        INT          NOT NULL,
    page_size        INT,
    date_of_writing  DATE,
    FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS genre
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS author
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(30) UNIQUE NOT NULL
);


CREATE TABLE IF NOT EXISTS list_of_authors
(
    book_id   INT,
    author_id INT,
    FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE,
    FOREIGN KEY (author_id) REFERENCES author (id) ON DELETE CASCADE,
    PRIMARY KEY (book_id, author_id)
);

CREATE TABLE IF NOT EXISTS list_of_genres
(
    book_id  INT,
    genre_id INT,
    FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genre (id) ON DELETE CASCADE,
    PRIMARY KEY (book_id, genre_id)
);


