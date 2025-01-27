CREATE DATABASE library_management;

\c library_management;

-- Table Books --
CREATE TABLE  IF NOT EXISTS "Books" (
    id_books VARCHAR(50) PRIMARY KEY,
    book_name VARCHAR(100) NOT NULL,
    author_id VARCHAR(50) NOT NULL,
    page_numbers INT NOT NULL,
    topic VARCHAR(200) NOT NULL,
    release_date DATE NOT NULL,
    FOREIGN KEY (author_id) REFERENCES "Authors"(author_id) ON DELETE CASCADE
);

-- Table Authors --
CREATE TABLE  IF NOT EXISTS "Authors" (
    author_id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birthDate DATE NOT NULL,
    sex CHAR(1) CHECK (sex IN ('M', 'F')) NOT NULL
);